package com.springboot.parkinglot.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.parkinglot.example.entity.Vehicle;

@Repository
public interface ParkingRepository extends JpaRepository<Vehicle, Long> {

}
