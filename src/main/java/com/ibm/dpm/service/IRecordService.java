package com.ibm.dpm.service;

import java.util.Date;
import java.util.List;

import com.ibm.dpm.domain.Record;

public interface IRecordService {
	
	List<Record> findAll();
	
	Record save(Record record);
	
	void delete(long id);
	
	Record findOne(long id);
	
	List<Record> findByNameAndDate(String name, Date date);
	
	List<Record> findByCountryAndLocation(String country, String location);
	
	List<Record> findByTester(String tester);
	
	List<Record> findByDateBetween(Date dateStart, Date dateEnd);
	
	List<Record> findAllByTestedOnBetweenAndDownloadTypeAndLocationAndIsvpn(
			Date testedOnStart, Date testedOnEnd, String downloadtype, String location, boolean isvpn);
	
}
