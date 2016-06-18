package com.carloscaldas.algorithms.crackingthecode.parkinglot;

import java.util.LinkedList;
import java.util.List;

public abstract class Vehicle {
	protected List<ParkingSpot> parkingSpots = new LinkedList<ParkingSpot>();
	protected String licensePlate;
	protected int spotsNeeded;
	protected VehicleSize size;
	
	public void parkInSpot(ParkingSpot s) {
		parkingSpots.add(s);
	}
	
	public void clearSpots() {
		parkingSpots.clear();
	}
	
	//TODO: coloca comentario ou nao coloca
	public abstract boolean canFitInSpot(ParkingSpot s);
	
}
