package com.ibm.dpm.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ibm.dpm.BaseTest;
import com.ibm.dpm.domain.Record;

public class RecordServiceTest extends BaseTest {

	@Autowired
	private IRecordService recordService;
	
	@Test
	public void findAllTest() {
		List<Record> records = recordService.findAll();
		System.out.println("Total Records are: " + records.size());
	}
	
	@Test
	public void findByTesterTest() {
		List<Record> records = recordService.findByTester("brian");
		System.out.println("Total Records for Brian are: " + records.size());
	}
	
	@Test
	public void findByCountryAndLocation() {
		List<Record> records = recordService.findByCountryAndLocation("US", "Offsite");
		System.out.println("Total Records for US + Offsite are: " + records.size());
	}
	
	@Test
	public void findAllByTestedOnBetweenAndDownloadTypeAndLocationAndIsvpn() throws ParseException {
		List<Record> records = recordService.findAllByTestedOnBetweenAndDownloadTypeAndLocationAndIsvpn(
				new SimpleDateFormat("yyyy-MM-dd").parse("2018-03-01"), 
				new SimpleDateFormat("yyyy-MM-dd").parse("2018-09-01"),
				"1st Akamai IWM", "Offsite", false);
		
		System.out.println("Total Records for 1st Akamai IWM + Offsite are: " + records.size());
		for(Record record : records) {
			System.out.println(record.toString());
		}
		
	}
}
