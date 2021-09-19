package com.springboot.parkinglot.example.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.mock.web.server.MockWebSession;

import com.springboot.parkinglot.example.entity.Vehicle;
import com.springboot.parkinglot.example.repository.ParkingRepository;

public class ParkingServiceImplTest {
	
	@Mock
	ParkingRepository parkingRepository;
	
	@InjectMocks
	ParkingServiceImpl parkingServiceImpl; 
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void getVehicleList() {
		List<Vehicle> vehicles = new ArrayList<Vehicle>();
		vehicles.add(Vehicle.builder().id(20l).carNumber("MH47 1889").ownerName("Samarth Narula").build());
		vehicles.add(Vehicle.builder().id(202l).carNumber("MH49 1234").ownerName("Ankit Shah").build());
		Mockito.when(parkingRepository.findAll()).thenReturn(vehicles);
		List<Vehicle> vehicleList = parkingServiceImpl.getVehicleList();
		Assert.assertEquals(2, vehicleList.size());
	}
	
	@Test
	public void park() {
		List<Vehicle> vehicles = new ArrayList<Vehicle>();
		Vehicle entity = Vehicle.builder().id(201l).carNumber("MH47 1889").ownerName("Samarth Narula").build();
		vehicles.add(Vehicle.builder().id(20l).carNumber("MH49 1234").ownerName("Ankit Shah").build());
		Mockito.when(parkingRepository.findAll()).thenReturn(vehicles);
		Mockito.when(parkingRepository.save(entity)).thenReturn(entity);
		parkingServiceImpl.park(entity);
	}
	
	
}
