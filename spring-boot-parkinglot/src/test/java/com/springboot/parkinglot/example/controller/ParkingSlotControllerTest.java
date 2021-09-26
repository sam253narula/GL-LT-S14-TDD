package com.springboot.parkinglot.example.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.parkinglot.example.entity.Vehicle;
import com.springboot.parkinglot.example.service.ParkingService;

/*@WebMvcTest: This annotation initializes web MVC related configurations 
 * required to write the JUnit test case for controller classes.*/
@WebMvcTest
public class ParkingSlotControllerTest {

	/*
	 * MockMvc: This class provides the required methods to test the Spring MVC
	 * layer. with perform() method, we can test different HTTP endpoints(GET, POST,
	 * PUT, DELETE, etc)
	 */
	@Autowired
	private MockMvc mockMvc;

	/*
	 * @MockBean: This annotation creates mocked beans in the spring application
	 * context.
	 */
	@MockBean
	ParkingService parkingService;

	private static ObjectMapper mapper = new ObjectMapper();

	// @Test: Indicated that the method is a test case.
	@Test
	public void getVehicleList() throws Exception {
		List<Vehicle> vehicles = new ArrayList<>();
		vehicles.add(Vehicle.builder().id(1l).carNumber("MH481234").ownerName("Denrick Rich").build());
		Mockito.when(parkingService.getVehicleList()).thenReturn(vehicles);
		/*
		 * jsonpath: Spring boot provides built-in supports JsonPath that is helpful to
		 * verify the JSON response.
		 */
		mockMvc.perform(get("/system/parkingLot/getAllVehicles")).andExpect(status().isOk())
				.andExpect(jsonPath("$", Matchers.hasSize(1)))
				.andExpect(jsonPath("$[0].carNumber", Matchers.equalTo("MH481234")));
	}

	@Test
	public void park() throws Exception {

		Vehicle vehicle = Vehicle.builder().id(1l).carNumber("MH481234").ownerName("Denrick Rich").build();
		String json = mapper.writeValueAsString(vehicle);
		Mockito.when(parkingService.park(vehicle)).thenReturn("Parked");
		/*
		 * MvcResult: MockMvc returns a result object on calling andReturn(), that
		 * contains the response details of a particular MVC operation.
		 */
		MvcResult responseOfRequest = mockMvc
				.perform(post("/system/parkingLot/vehicle/park").contentType(MediaType.APPLICATION_JSON)
						.characterEncoding("utf-8").content(json).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isCreated()).andReturn();
		String response = responseOfRequest.getResponse().getContentAsString();
		assertEquals(response, "Parked");
	}

	@Test
	public void unPark() throws Exception {
		Mockito.when(parkingService.unParkVehicle(ArgumentMatchers.anyLong())).thenReturn("Parking slot 1 is now available");
		MvcResult responseOfRequest = mockMvc.perform(delete("/system/parkingLot/vehicle/unPark").param("id", "1"))
				.andExpect(status().isOk()).andReturn();
		
		String result = responseOfRequest.getResponse().getContentAsString();
		assertEquals(result, "Parking slot 1 is now available");
		
	}

}
