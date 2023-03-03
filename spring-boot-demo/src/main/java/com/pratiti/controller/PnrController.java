package com.pratiti.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pratiti.model.Passenger;
import com.pratiti.model.Passenger.Gender;
import com.pratiti.model.Passenger.Status;
import com.pratiti.model.Pnr;

//assumption : we are working for indian railways
@RestController
@CrossOrigin
public class PnrController {
	
	@GetMapping("/checkStatus")
	public Pnr checkStatus(@RequestParam(required = false, name="pnrNo")int pnrNo, String name) {
		//for the time being we will hard code some data 
		Pnr pnr = new Pnr();
		pnr.setPnrNo(pnrNo);
		pnr.setTrainNo(123445);
		pnr.setTravelDate(LocalDate.of(2023, 3, 10));
		
		List<Passenger> passengers = new ArrayList<>();
		
		Passenger passenger1 = new Passenger();
		passenger1.setName("Harry");
		passenger1.setGender(Gender.MALE);
		passenger1.setStatus(Status.RAC);
		passengers.add(passenger1);
		
		Passenger passenger2 = new Passenger();
		passenger2.setName("Sally");
		passenger2.setGender(Gender.FEMALE);
		passenger2.setStatus(Status.CONFIRMED);
		passengers.add(passenger2);
		
		pnr.setPassengers(passengers);
		Status status = Status.WAITING;
		for(Passenger pas : passengers) {
			if(pas.getName().equals(name)) {
				 status = pas.getStatus();
			}
			
		}
		
		return  pnr;
		
	}
}
