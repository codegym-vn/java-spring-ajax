package com.codegym.service;

import com.codegym.model.Smartphone;

public interface SmartphoneService {

	Iterable<Smartphone> findAll();

	Smartphone findById(Integer id);

	Smartphone save(Smartphone phone);

	void remove(Integer id);
}
