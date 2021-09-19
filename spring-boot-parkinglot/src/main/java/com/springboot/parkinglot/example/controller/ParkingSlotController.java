package com.springboot.parkinglot.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
	public List<Vehicle> park() {
		List<Vehicle> vehicleList = parkingService.getVehicleList();
		return vehicleList;
	}

	@PostMapping(value = "/vehicle/park")
	public String park(@RequestBody Vehicle vehicle) { 
		return parkingService.park(vehicle);
		//return new ResponseEntity<>(parkingService.park(vehicle), HttpStatus.CREATED);
	}

	@DeleteMapping("/vehicle/unPark/{id}")
	String newStudent(@PathVariable Long id) {
		return parkingService.unParkVehicle(id);
	}

}
