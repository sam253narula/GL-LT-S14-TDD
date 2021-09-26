package com.springboot.parkinglot.example.serviceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.springboot.parkinglot.example.entity.Vehicle;
import com.springboot.parkinglot.example.repository.ParkingRepository;

@SpringBootTest
public class ParkingServiceImplTest {
	
	 List<Vehicle> vehicles = new ArrayList<Vehicle>();
	
	@Mock
	ParkingRepository parkingRepository;
	
	@InjectMocks
	ParkingServiceImpl parkingServiceImpl; 
	
	@BeforeEach
	public void setup(){
		vehicles.add(Vehicle.builder().id(1l).carNumber("MH47 1889").ownerName("Samarth Narula").build());
		vehicles.add(Vehicle.builder().id(2l).carNumber("MH49 1234").ownerName("Ankit Shah").build());
	}
	
	@Test
	@DisplayName(value = "Number of vehicles returned should be 2")
	public void getVehicleList() {
		Mockito.when(parkingRepository.findAll()).thenReturn(vehicles);
		List<Vehicle> vehicleList = parkingServiceImpl.getVehicleList();
		assertEquals(2, vehicleList.size());
	}
	
	@Test
	@DisplayName(value = "Testing the park method positive workflow, where we are parking a vehicle in a valid parking slot")
	public void park() {
		Mockito.when(parkingRepository.findAll()).thenReturn(vehicles);
		Vehicle vehicle = Vehicle.builder().id(3l).carNumber("MH47 1889").ownerName("Harshit Singh").build();
		assertEquals(3l, (long) vehicle.getId());
		Mockito.when(parkingRepository.save(vehicle)).thenReturn(vehicle);
		parkingServiceImpl.park(vehicle);
	}
	
	@Test
	@DisplayName(value = "Testing park method when it should throw RuntimeException with messsage : Parking lot is not available")
	public void park_whenParkingLotNotAvailable() {
		Mockito.when(parkingRepository.findAll()).thenReturn(vehicles);
		Vehicle vehicle = Vehicle.builder().id(1l).carNumber("MH47 2021").ownerName("Sahil Shah").build();
		RuntimeException ex = assertThrows(RuntimeException.class, () -> parkingServiceImpl.park(vehicle));
	    assertEquals("Parking lot is not available", ex.getMessage());
	}
	
	@Test
	public void park_WhenWeHaveInValidParkingLotId() {
		Mockito.when(parkingRepository.findAll()).thenReturn(vehicles);
		Vehicle vehicle = Vehicle.builder().id(20l).carNumber("MH47 2021").ownerName("Sahil Shah").build();
		RuntimeException ex = assertThrows(RuntimeException.class, () -> parkingServiceImpl.park(vehicle));
		assertEquals("Parking lot is not available Kindly provide a parkig lot number between 1 to 10, according to availability of parking slots", ex.getMessage());
	}
	
	@Test
	public void park_WhenParkingLotIdIsZero() {
		Mockito.when(parkingRepository.findAll()).thenReturn(vehicles);
		Vehicle vehicle = Vehicle.builder().id(0l).carNumber("MH47 2021").ownerName("Sahil Shah").build();
		RuntimeException ex = assertThrows(RuntimeException.class, () -> parkingServiceImpl.park(vehicle));
		assertEquals("Parking lot is not available Kindly provide a parkig lot number between 1 to 10, according to availability of parking slots", ex.getMessage());
	}

	@Test
	public void unParkVehicle() {
		parkingServiceImpl.unParkVehicle(1l);
		// If I add the verify before the above line, will it work or it will fail
		Mockito.verify(parkingRepository).deleteById(1l);
	}
	
	@Test
	public void unParkVehicle_WhenWeHaveInValidParkingLotId() {
		RuntimeException ex = assertThrows(RuntimeException.class, () -> parkingServiceImpl.unParkVehicle(20l));
		assertEquals("Provide id between 1 to 10", ex.getMessage());
	}
	
	
}
