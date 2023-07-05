package com.example.crud.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.crud.controller.CrudServiceTddController;
import com.example.crud.entity.CrudServiceTddEntity;
import com.example.crud.repository.CrudServiceTddRepository;


@Service
public class CrudServiceTddServiceImpl implements CrudServiceTddService{
	
	private static Logger logger = LogManager.getLogger(CrudServiceTddServiceImpl.class);
	
	@Autowired
	CrudServiceTddRepository repo;
	
	//@Autowired
	CrudServiceTddEntity crudServiceTddEntity = new CrudServiceTddEntity();

	@Override
	public Object findByKey(String convertedUnit) {
		
	 crudServiceTddEntity =	repo.findByName(convertedUnit);
	 logger.info(crudServiceTddEntity.getFormula());
		
		return crudServiceTddEntity.getFormula();
	}

}
