package com.codegym.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.codegym.exception.SmartphoneNotFoundException;
import com.codegym.model.Smartphone;
import com.codegym.repository.SmartphoneRepository;

@Service
@Transactional(rollbackFor=SmartphoneNotFoundException.class)
public class SmartphoneServiceImpl implements SmartphoneService {
	
	@Autowired
	private SmartphoneRepository smartphoneRepository;

	@Override
	public Smartphone create(Smartphone sp) {
		return smartphoneRepository.save(sp);
	}

	@Override
	public Smartphone get(Integer id) {
		return smartphoneRepository.findOne(id);
	}

	@Override
	public List<Smartphone> getAll() {
		return smartphoneRepository.findAll();
	}

	@Override
	public Smartphone update(Smartphone sp) throws SmartphoneNotFoundException {
		Smartphone sPhoneToUpdate = get(sp.getId());
		if (sPhoneToUpdate == null)
			throw new SmartphoneNotFoundException(sp.getId().toString());
		sPhoneToUpdate.update(sp);
		return sPhoneToUpdate;
	}

	@Override
	public Smartphone delete(Integer id) throws SmartphoneNotFoundException {
		Smartphone sPhone = get(id);
		if (sPhone == null)
			throw new SmartphoneNotFoundException(id.toString());
		smartphoneRepository.delete(id);
		return sPhone;
	}

}
