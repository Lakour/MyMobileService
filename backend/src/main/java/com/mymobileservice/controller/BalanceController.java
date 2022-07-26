package com.mymobileservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mymobileservice.beans.Balance;
import com.mymobileservice.beans.Lines;
import com.mymobileservice.beans.Plans;
import com.mymobileservice.services.PlansService;
import com.mymobileservice.services.BalanceService;
import com.mymobileservice.services.LinesService;

@RestController
@RequestMapping(path="/balance/v1")
@CrossOrigin("http://localhost:4200")
public class BalanceController {
    @Autowired
    BalanceService balanceService;
    @Autowired
    PlansService plansService;
    @Autowired
    LinesService linesService;
    
    @GetMapping("/account/{accountid}")
	public ResponseEntity<List<Balance>> findAccount(@PathVariable int accountid) {
		return new ResponseEntity<List<Balance>>(balanceService.findByAccount(accountid), HttpStatus.OK);
	}

    @PutMapping("/planswap/{accountid},{phonenumber},{balance}")
    public void planSwap(@PathVariable int accountid, @PathVariable String phonenumber,@PathVariable double balance){
        List<Lines> line = linesService.findByPhoneNumber(phonenumber);
        // index 1 is phoneid / index 3 is remphonebal / index 4 is plan id
        double phoneBal;
        int planId;
        Double planCost;


        for (Object lines : line){
            int i = 0;
            while(i < 5){
                if (i == 3){
                    phoneBal = (Double) lines;
                }
                if(i == 4){
                    planId = (Integer)lines;
                }
                ++i;
            }
        }

        //Optional<Plans> plan = plansService.findById(planId);

        balanceService.updateBalance(accountid, balance);
     }
}