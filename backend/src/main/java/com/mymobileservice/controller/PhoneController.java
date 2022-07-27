package com.mymobileservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mymobileservice.beans.Phone;
import com.mymobileservice.services.PhoneService;

@RestController
@RequestMapping("/phones/v1")
@CrossOrigin("http://localhost:4200")
public class PhoneController {
	
	@Autowired
	PhoneService phoneService;
	
	@GetMapping
	public ResponseEntity<List<Phone>> findAll(){
		List<Phone> models = phoneService.findAll();

		return new ResponseEntity<List<Phone>>(models, HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Phone> save(@RequestBody Phone newPhone){
		return new ResponseEntity<Phone>(phoneService.add(newPhone), HttpStatus.CREATED);
	}

	@GetMapping("/phone/{model}")
	public List<Phone> findByName(@PathVariable String model){
		return phoneService.findByPhoneModel(model);
	}

	@GetMapping("/priceabove/{price}")
	public List<Phone> findByPriceGreater(@PathVariable double price){
		return phoneService.findByPriceGreater(price);
	}

	@GetMapping("/pricebelow/{price}")
	public List<Phone> findByPriceLess(@PathVariable double price){
		return phoneService.findByPriceLower(price);
	}

	@GetMapping("/id/{id}")
	public ResponseEntity<Phone> findById(@PathVariable int id) {
		return new ResponseEntity<Phone>(phoneService.findById(id), HttpStatus.OK);
	}
}
