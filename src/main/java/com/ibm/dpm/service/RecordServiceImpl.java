package com.ibm.dpm.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.dpm.domain.Record;
import com.ibm.dpm.repository.RecordJpaRepository;

@Service
@Transactional
public class RecordServiceImpl implements IRecordService {

	@Autowired
	private RecordJpaRepository recordJpaRepository;
	
	public List<Record> findAll(){
		return recordJpaRepository.findAll();
	}
	
	public Record save(Record record) {
		return recordJpaRepository.save(record);
	}
	
	public void delete(long id) {
		recordJpaRepository.deleteById(id);
	}
	
	public Record findOne(long id) {
		return recordJpaRepository.getOne(id);
	}

	public List<Record> findByNameAndDate(String name, Date date) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<Record> findByCountryAndLocation(String country, String location) {
		return recordJpaRepository.findByCountryAndLocation(country, location);
	}

	public List<Record> findByTester(String tester) {
		return recordJpaRepository.findByTester(tester);
	}
	
	public List<Record> findByDateBetween(Date dateStart, Date dateEnd) {
		return recordJpaRepository.findAllByTestedOnBetween(dateStart, dateEnd);
	}
	
	public List<Record> findAllByTestedOnBetweenAndDownloadTypeAndLocationAndIsvpn(
			Date testedOnStart, Date testedOnEnd, String downloadtype, String location, boolean isvpn) {
		if (isvpn) {
			return recordJpaRepository.findAllByTestedOnBetweenAndDownloadTypeAndLocationAndIsvpnTrue(
					testedOnStart, testedOnEnd, downloadtype, location);
		}else {
			return recordJpaRepository.findAllByTestedOnBetweenAndDownloadTypeAndLocationAndIsvpnFalse(
					testedOnStart, testedOnEnd, downloadtype, location);
		}
	}
	
}
