package com.ibm.dpm.web;

import java.text.ParseException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ibm.dpm.service.IReportService;
import com.ibm.dpm.utils.DateUtil;

@Controller
@RequestMapping("/report")
public class ReportController {

	private static final Logger logger = LoggerFactory.getLogger(ReportController.class);
	
	@Autowired
	private IReportService reportService;
	
	@Value("${server.servlet.context-path}")
	private String contextpath;
	
	@RequestMapping("/dashboard")
	public String Dashboard() {
		
		//TODO: add function for dashboard
		
		logger.trace("Application Context Path is {}", contextpath);
		logger.debug("Application Context Path is {}", contextpath);
		logger.info("Application Context Path is {}", contextpath);
		logger.warn("Application Context Path is {}", contextpath);
		logger.error("Application Context Path is {}", contextpath);
		
		return "report/dashboard";
				
	}
	
	@RequestMapping("/query")
	public String Query() {
		return "report/query";
	}
	
	@ResponseBody
	@RequestMapping("/getReport")
	public String doQuery(@RequestBody String selectedDate) {
		logger.info("do query");
		logger.info("Selected Date is: {}", selectedDate);
		
		try {
			List<String> barchartList = reportService.getReportByWeek(DateUtil.getDate(selectedDate));
			return barchartList.toString();
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "success";
	}
	
}
