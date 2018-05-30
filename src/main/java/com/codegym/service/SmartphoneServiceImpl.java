package com.codegym.service;
import org.springframework.beans.factory.annotation.Autowired;
import com.codegym.model.Smartphone;
import com.codegym.repository.SmartphoneRepository;

public class SmartphoneServiceImpl implements SmartphoneService {

    @Autowired
    private SmartphoneRepository smartphoneRepository;

    @Override
    public Iterable<Smartphone> findAll() {
        return smartphoneRepository.findAll();
    }

    @Override
    public Smartphone findById(Integer id) {
        return smartphoneRepository.findOne(id);
    }

    @Override
    public Smartphone save(Smartphone phone) {
       return smartphoneRepository.save(phone);
    }

    @Override
    public void remove(Integer id) {
        smartphoneRepository.delete(id);
    }
}
