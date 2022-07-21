package com.mymobileservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mymobileservice.beans.Phone;
import com.mymobileservice.data.PhoneRepository;

@Service
public class PhoneService {
	@Autowired
	PhoneRepository repo;
	
	public List<Phone> findAll() {
		
		return repo.findAll();
	}

	public Phone save(Phone phone) {
		return repo.save(phone);
	}

}
