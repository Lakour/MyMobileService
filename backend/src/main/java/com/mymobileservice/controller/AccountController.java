package com.mymobileservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mymobileservice.services.AccountService;

import io.swagger.v3.oas.annotations.tags.Tag;

import com.mymobileservice.beans.Account;



@RestController
@RequestMapping(path="/account/v1")
@CrossOrigin("http://localhost:4200")
@Tag(name = "Account Controller")
public class AccountController {

    @Autowired
    AccountService accountService;

    @PostMapping("/add")
    //add a new account to the db
    public ResponseEntity<Account> save(@RequestBody Account newAccount){
        return new ResponseEntity<Account>(accountService.add(newAccount), HttpStatus.CREATED);
    }

    @PutMapping("/makeBill/{id}/{balance}/{phoneBal}")
    //updates balance and phoneBal columns in db
    public ResponseEntity<Account> makeBill(@PathVariable int id, @PathVariable Double balance, @PathVariable double phoneBal){
        return new ResponseEntity<Account>(accountService.makeBill(id, balance, phoneBal), HttpStatus.OK);
    }

    @GetMapping
    //get them all... disable in prod
    public ResponseEntity<List<Account>> findAll(){ 
        return new ResponseEntity<List<Account>>(accountService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/email/{email}")
    //get by email
	public ResponseEntity<Account> findByEmail(@PathVariable String email) {
		return new ResponseEntity<Account>(accountService.findByEmailLike(email), HttpStatus.OK);
	}

    @GetMapping("/id/{id}")
    //get account by account id
	public ResponseEntity<Account> findById(@PathVariable int id) {
		return new ResponseEntity<Account>(accountService.findById(id), HttpStatus.OK);
	}
    
    
}
