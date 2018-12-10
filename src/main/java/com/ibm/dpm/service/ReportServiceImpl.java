package com.ibm.dpm.service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.dpm.constant.DownloadOptions;
import com.ibm.dpm.domain.Record;
import com.ibm.dpm.utils.DateUtil;

import be.ceau.chart.BarChart;
import be.ceau.chart.data.BarData;
import be.ceau.chart.dataset.BarDataset;
import be.ceau.chart.options.BarOptions;
import be.ceau.chart.options.Title;

@Service
public class ReportServiceImpl implements IReportService {

	private static final Logger logger = LoggerFactory.getLogger(ReportServiceImpl.class);
	
	@Autowired
	private IRecordService recordService;
	
	@Override
	public List<String> getReportByWeek(Date selectedDate) throws ParseException {
		
		logger.debug("getReportByWeek");
		logger.debug("Selected Date: {}", selectedDate.toString());
		
		List<String> barchartList = new ArrayList<String>();
		
		String[] countries = DownloadOptions.COUNTRY;
		List<String> countryList = new ArrayList<String>();
		for (String c:countries) {
			countryList.add(c);
		}
		logger.debug("Country Number is: " + countries.length);
		
		String[] iwm_testcases = DownloadOptions.TYPE_IWM;
		
		String[] dsw_testcases = DownloadOptions.TYPE_DSW;
		
		Date beginDate = DateUtil.getFirstDayOfWeekByGivenDate(selectedDate);
		Date endDate = DateUtil.getLastDayOfWeekByGivenDate(selectedDate);
		logger.debug("BeginDate={}, EndDate={}", beginDate, endDate);
		
		//1. IWM Offsite VPN
		BarChart barChart1 = getOneWeekReport(beginDate, endDate,iwm_testcases, countryList, "Offsite", true);
		barChart1.setOptions(new BarOptions().setTitle(new Title().setDisplay(true).setText("IWM Offsite VPN")));
		barchartList.add(barChart1.toJson());
		
		//2. IWM Offsite No VPN
		BarChart barChart2 = getOneWeekReport(beginDate, endDate,iwm_testcases, countryList, "Offsite", false);
		barChart2.setOptions(new BarOptions().setTitle(new Title().setDisplay(true).setText("IWM Offsite No VPN")));
		barchartList.add(barChart2.toJson());
		
		//3. IWM Onsite
		BarChart barChart3 = getOneWeekReport(beginDate, endDate,iwm_testcases, countryList, "Onsite", false);
		barChart3.setOptions(new BarOptions().setTitle(new Title().setDisplay(true).setText("IWM Onsite")));
		barchartList.add(barChart3.toJson());
		
		//4. DSW Offsite VPN
		BarChart barChart4 = getOneWeekReport(beginDate, endDate,dsw_testcases, countryList, "Offsite", true);
		barChart4.setOptions(new BarOptions().setTitle(new Title().setDisplay(true).setText("DSW Offsite VPN")));
		barchartList.add(barChart4.toJson());
		
		//5. DSW Offsite No VPN
		BarChart barChart5 = getOneWeekReport(beginDate, endDate,dsw_testcases, countryList, "Offsite", false);
		barChart5.setOptions(new BarOptions().setTitle(new Title().setDisplay(true).setText("DSW Offsite No VPN")));
		barchartList.add(barChart5.toJson());
		
		//6. DSW Onsite
		BarChart barChart6 = getOneWeekReport(beginDate, endDate,dsw_testcases, countryList, "Onsite", false);
		barChart6.setOptions(new BarOptions().setTitle(new Title().setDisplay(true).setText("DSW Onsite")));
		barchartList.add(barChart6.toJson());
		
		return barchartList;
	}
	
	public BarChart getOneWeekReport(Date startDate, Date endDate, String[] testcases, List<String> countryList, 
			String location, boolean isvpn) {
		
		logger.debug("getOneWeekReport");
		
		BarChart barChart = new BarChart();
		BarData bardata = new BarData();
		
		for (int x=0, len=testcases.length; x<len; x++) {
			List<Record> records = recordService
					.findAllByTestedOnBetweenAndDownloadTypeAndLocationAndIsvpn(
							startDate, endDate, testcases[x], location, isvpn);
			logger.debug("Total Records: {}", records.size());
			
			double[] downloadspeed = new double[countryList.size()];
			
			for(Record r:records) {
				
				logger.debug(r.toString());
				
				//Bytes to Mb
				double tmp = (double)(r.getDownloadSpeed())/1024/1024;
				
				if(downloadspeed[countryList.indexOf(r.getCountry())]==0.0) {
					//double to 00.00 
					downloadspeed[countryList.indexOf(r.getCountry())] = 
							(double)(Math.round(tmp*100))/100;
				}else {
					
					logger.info("Find One More Record: Country({}), TestCase({})", 
							r.getCountry(), testcases[x]);
					logger.info("Current Download Speed: {}", downloadspeed[countryList.indexOf(r.getCountry())]);
					logger.info("New Download Speed: {}", tmp);
					
					downloadspeed[countryList.indexOf(r.getCountry())] = 
							(downloadspeed[countryList.indexOf(r.getCountry())]+(double)(Math.round(tmp*100))/100)/2;
					logger.info("Final Download Speed: {}", downloadspeed[countryList.indexOf(r.getCountry())]);
				}
				
			}

			BarDataset ds = new BarDataset()
					.setLabel(testcases[x])
					.setData(downloadspeed)
					.setBackgroundColor(DownloadOptions.BACKGROUND_COLOR[x])
					.setBorderColor(DownloadOptions.BORDER_COLOR[x])
					.setBorderWidth(1);
			
			bardata.addDataset(ds);
		}
		
		return barChart.setData(bardata.setLabels(countryList));
	}

}
