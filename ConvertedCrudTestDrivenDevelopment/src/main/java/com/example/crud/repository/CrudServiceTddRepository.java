package com.example.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.crud.entity.CrudServiceTddEntity;

@Repository
public interface CrudServiceTddRepository extends JpaRepository<CrudServiceTddEntity, String> {

	CrudServiceTddEntity findByName(String convertedUnit);

}
