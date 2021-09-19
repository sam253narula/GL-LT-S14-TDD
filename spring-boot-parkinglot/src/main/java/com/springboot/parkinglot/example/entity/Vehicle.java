package com.springboot.parkinglot.example.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class Vehicle {
	@Id
	private Long id;
	private String carNumber;
	private String ownerName;

}

 
