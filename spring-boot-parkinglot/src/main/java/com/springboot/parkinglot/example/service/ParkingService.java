package com.springboot.parkinglot.example.service;
import java.util.List;

import com.springboot.parkinglot.example.entity.Vehicle;

public interface ParkingService {
	List<Vehicle> getVehicleList();
	String park(Vehicle vehicle);
	String unParkVehicle(Long id);

}
