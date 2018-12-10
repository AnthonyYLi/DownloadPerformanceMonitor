package com.ibm.dpm.repository;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ibm.dpm.domain.Record;

public interface RecordJpaRepository extends 
	JpaRepository<Record,Long>, 
	JpaSpecificationExecutor<Record>,
	Serializable {
	
	List<Record> findByCountryAndLocation(String country, String location);
	
	@Query(value = "from Record r where r.testedBy = :tested_by")
	List<Record> findByTester(@Param("tested_by") String testedBy);
	
	List<Record> findAllByTestedOnBetween(Date testedOnStart, Date testedOnEnd);
	
	List<Record> findAllByTestedOnBetweenAndCountry(
			Date testedOnStart, Date testedOnEnd, String Country);
	
	List<Record> findAllByTestedOnBetweenAndDownloadType(
			Date testedOnStart, Date testedOnEnd, String downloadtype);
	
	List<Record> findAllByTestedOnBetweenAndDownloadTypeAndCountry(
			Date testedOnStart, Date testedOnEnd, String downloadtype, String country);
	
	List<Record> findAllByTestedOnBetweenAndDownloadTypeAndCountryAndLocationAndIsvpnTrue(
			Date testedOnStart, Date testedOnEnd, String downloadtype, 
			String country, String location);
	
	List<Record> findAllByTestedOnBetweenAndDownloadTypeAndLocationAndIsvpnTrue(
			Date testedOnStart, Date testedOnEnd, String downloadtype, String location);
	
	List<Record> findAllByTestedOnBetweenAndDownloadTypeAndLocationAndIsvpnFalse(
			Date testedOnStart, Date testedOnEnd, String downloadtype, String location);
	
}
