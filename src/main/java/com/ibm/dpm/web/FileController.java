package com.ibm.dpm.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/file")
public class FileController {

	@RequestMapping("/download")
	public String download() {
		
		return "file/download";
	}
}
