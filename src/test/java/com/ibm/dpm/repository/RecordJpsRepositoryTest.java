package com.ibm.dpm.repository;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ibm.dpm.BaseTest;
import com.ibm.dpm.domain.Record;

public class RecordJpsRepositoryTest extends BaseTest {

	@Autowired
	private RecordJpaRepository recordJpaRepository;
	
	@Test
	public void findAllTest() {
		List<Record> records = recordJpaRepository.findAll();
		System.out.println("Total Records are: " + records.size());
		System.out.println(records.get(0).getTestedOn());
	}
	
	@Test
	public void findByTesterTest() {
		List<Record> records = recordJpaRepository.findByTester("brian");

		System.out.println("Total Records for Biran are: " + records.size());
		
		assertEquals(16, records.size());
		
	}
	
	@Test
	public void findByCountryAndLocationTest() {
		List<Record> records = recordJpaRepository.findByCountryAndLocation("US", "Offsite");
		System.out.println("US & Offsite records are: " + records.size());
	}
	
	@Test
	public void findAllByTestedOnBetweenTest() throws ParseException {
		List<Record> records = recordJpaRepository.findAllByTestedOnBetween(
				new SimpleDateFormat("yyyy-MM-dd").parse("2018-03-01"), 
				new SimpleDateFormat("yyyy-MM-dd").parse("2018-09-01"));
		
		assertEquals(79, records.size());
		
	}
	
	@Test
	public void findAllByTestedOnBetweenAndCountryTest() throws ParseException {
		List<Record> records = recordJpaRepository.findAllByTestedOnBetweenAndCountry(
				new SimpleDateFormat("yyyy-MM-dd").parse("2018-03-01"), 
				new SimpleDateFormat("yyyy-MM-dd").parse("2018-09-01"),
				"US");
		
		assertEquals(16, records.size());
	}
	
	@Test
	public void findAllByTestedOnBetweenAndDownloadTypeTest() throws ParseException {
		List<Record> records = recordJpaRepository.findAllByTestedOnBetweenAndDownloadType(
				new SimpleDateFormat("yyyy-MM-dd").parse("2018-03-01"), 
				new SimpleDateFormat("yyyy-MM-dd").parse("2018-09-01"),
				"1st Akamai IWM");
		
		System.out.println("findAllByTestedOnBetweenAndDownloadTypeTest");
		for(Record record : records) {
			System.out.println(record.toString());
		}
		
		assertEquals(11, records.size());
	}
	
	@Test
	public void findAllByTestedOnBetweenAndDownloadTypeAndCountryTest() throws ParseException {
		List<Record> records = recordJpaRepository.findAllByTestedOnBetweenAndDownloadTypeAndCountry(
				new SimpleDateFormat("yyyy-MM-dd").parse("2018-03-01"), 
				new SimpleDateFormat("yyyy-MM-dd").parse("2018-09-01"),
				"1st Akamai IWM","Slovakia");
		
		System.out.println("findAllByTestedOnBetweenAndDownloadTypeAndCountryTest");
		for(Record record : records) {
			System.out.println(record.toString());
		}
		assertEquals(11, records.size());
	}
	
	@Test
	public void findAllByTestedOnBetweenAndDownloadTypeAndCountryAndLocationAndIsvpnTest() throws ParseException {
		List<Record> records = recordJpaRepository.findAllByTestedOnBetweenAndDownloadTypeAndCountryAndLocationAndIsvpnTrue(
				new SimpleDateFormat("yyyy-MM-dd").parse("2018-03-01"), 
				new SimpleDateFormat("yyyy-MM-dd").parse("2018-06-01"),
				"1st Akamai IWM","Slovakia", "Offsite");
		
		assertEquals(16, records.size());
		
	}
	
	@Test
	public void findAllByTestedOnBetweenAndDownloadTypeAndLocationAndIsvpnTest() throws ParseException {
		List<Record> records = recordJpaRepository.findAllByTestedOnBetweenAndDownloadTypeAndLocationAndIsvpnTrue(
				new SimpleDateFormat("yyyy-MM-dd").parse("2018-03-01"), 
				new SimpleDateFormat("yyyy-MM-dd").parse("2018-06-01"),
				"1st Akamai IWM","Offsite");
		
		for(Record record : records) {
			System.out.println(record.toString());
		}
		
		assertEquals(3, records.size());
		
	}
	
}
