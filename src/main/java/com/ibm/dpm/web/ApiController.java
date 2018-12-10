package com.ibm.dpm.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.dpm.domain.Record;
import com.ibm.dpm.service.IRecordService;

@RestController
@RequestMapping("/api")
public class ApiController {

private static final Logger logger = LoggerFactory.getLogger(ReportController.class);
	
	@Autowired
	IRecordService recordService;
	
	@RequestMapping(value="/record", method=RequestMethod.GET)
	public List<Record> list() {
		
		return recordService.findAll();
	}
	
	@RequestMapping(value="/record/", method=RequestMethod.POST)
	public Record save(@RequestBody Record record) {
		logger.info(record.toString());
		return recordService.save(record);
	}
	
	@RequestMapping(value="/record/{id}", method=RequestMethod.DELETE)
	public String delete(@PathVariable long id) {
		recordService.delete(id);
		return "SUCCESS";
	}
	
	@ResponseBody
	@RequestMapping(value="/record/{selectedDate}", method=RequestMethod.GET)
	public List<Record> getRecordByDate(@PathVariable String selectedDate) {
		
		//TODO
		return recordService.findAll();
	}
	
}
