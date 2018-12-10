package com.ibm.dpm.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ibm.dpm.BaseTest;

public class ReportServiceTest  extends BaseTest {

	@Autowired
	private IReportService reportService;
	
	@Test
	public void getReportByWeekTest() throws ParseException {
		
		List<String> barchartlist = reportService.getReportByWeek(new SimpleDateFormat("yyyy-MM-dd").parse("2018-03-01"));
		System.out.println(barchartlist.size());
	}
	
	
}
