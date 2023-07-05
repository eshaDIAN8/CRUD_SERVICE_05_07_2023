package com.example.crud.controller;

import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.crud.service.CrudServiceTddService;

@RequestMapping("/getConvertedUnit")
@RestController
public class CrudServiceTddController {
	
	private static Logger logger = LogManager.getLogger(CrudServiceTddController.class);
	
	@Autowired
	private CrudServiceTddService service;

	
	
	@GetMapping("/crud")
	public ResponseEntity<String> getFormula(@RequestParam String fromUnit,@RequestParam String toUnit) {
		String formula = null;
		logger.info("inside  crud MS CrudServiceTddController");
		
		String convertedUnitKey = fromUnit + "-" + toUnit;
		try {
			if(Objects.nonNull(service)) {
	 formula = (String) service.findByKey(convertedUnitKey);
	 
	 logger.info("in crud controller::"+formula);
			}
			
			else {
				logger.info("service object is null");
			}
	
		}catch(Exception e) {
			logger.error("exception "+e);
			
		}
		
		return ResponseEntity.ok(formula);
		
		
		
	}

}
