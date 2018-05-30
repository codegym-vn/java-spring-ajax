package com.codegym.service;

import java.util.List;

import com.codegym.exception.SmartphoneNotFoundException;
import com.codegym.model.Smartphone;

public interface SmartphoneService {
	
	public Smartphone create(Smartphone sp);
	public Smartphone get(Integer id);
	public List<Smartphone> getAll();
	public Smartphone update(Smartphone sp) throws SmartphoneNotFoundException;
	public Smartphone delete(Integer id) throws SmartphoneNotFoundException;

}
