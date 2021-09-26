package com.springboot.parkinglot.example.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.parkinglot.example.entity.Vehicle;
import com.springboot.parkinglot.example.repository.ParkingRepository;
import com.springboot.parkinglot.example.service.ParkingService;

@Service
public class ParkingServiceImpl implements ParkingService {

	@Autowired
	ParkingRepository parkingRepository;
	
	@Override
	public List<Vehicle> getVehicleList() {
		 return parkingRepository.findAll();
	}
	
	@Override
	public String park(Vehicle vehicle) {
		 long id = vehicle.getId();
		 List<Vehicle> parkedVehicles = new ArrayList<>();
		 parkedVehicles = parkingRepository.findAll();
		 for(Vehicle v: parkedVehicles) {
			 if(v.getId() == id) {
				 throw new RuntimeException("Parking lot is not available");
			 }
		 }
		 if (vehicle.getId() <= 10 && vehicle.getId() != 0) {
			parkingRepository.save(vehicle);
			return "Parked";
		}
		 else {
			 throw new RuntimeException("Parking lot is not available Kindly provide a parkig lot number between 1 to 10, according to availability of parking slots");
		 }
	}

	@Override
	public String unParkVehicle(Long id) {
		if (id <= 10) {
			parkingRepository.deleteById(id);
			return "Parking slot " + id + " is now available";
		}
		throw new RuntimeException("Provide id between 1 to 10");
	}

}
