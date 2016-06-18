package com.carloscaldas.algorithms.crackingthecode.parkinglot;

public class Car extends Vehicle {

	public Car() {
		this.spotsNeeded = 1;
		size = VehicleSize.Compact;
	}
	
	@Override
	public boolean canFitInSpot(ParkingSpot s) {
		// TODO Auto-generated method stub
		return false;
	}

}
