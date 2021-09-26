package com.springboot.parkinglot.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.parkinglot.example.entity.Vehicle;
import com.springboot.parkinglot.example.service.ParkingService;

@CrossOrigin
@RestController
@RequestMapping("/system/parkingLot")
public class ParkingSlotController {

	@Autowired
	private ParkingService parkingService;

	@GetMapping(value = "/getAllVehicles")
	public List<Vehicle> getAllVehicles() {
		List<Vehicle> vehicleList = parkingService.getVehicleList();
		return vehicleList;
	}

	@PostMapping(value = "/vehicle/park")
	public ResponseEntity<String> park(@RequestBody Vehicle vehicle) { 
		String parked = parkingService.park(vehicle);
		return new ResponseEntity<>(parked, HttpStatus.CREATED);
		//return new ResponseEntity<>(parkingService.park(vehicle), HttpStatus.CREATED);
	}

	@DeleteMapping("/vehicle/unPark")
	public String unPark(Long id) {
		return parkingService.unParkVehicle(id);
	}

}
