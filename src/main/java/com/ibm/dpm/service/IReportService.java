package com.ibm.dpm.service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;


public interface IReportService {

	List<String> getReportByWeek(Date selectedDate) throws ParseException;
	
}
