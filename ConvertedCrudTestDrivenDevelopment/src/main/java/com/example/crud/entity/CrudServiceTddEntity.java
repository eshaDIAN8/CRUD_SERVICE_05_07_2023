package com.example.crud.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;


@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name ="TDD_CONVERT_CRUD_ENTITY")
public class CrudServiceTddEntity {
	

	@Id
	@Column(name="FROM_UNIT_TO_UNIT")
	private String name;
	
	@Column(name="FORMULA")
	private String formula;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFormula() {
		return formula;
	}

	public void setFormula(String formula) {
		this.formula = formula;
	}
	
	

}
