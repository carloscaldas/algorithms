package com.carloscaldas.algorithms.crackingthecode.parkinglot;

public class Bus extends Vehicle {

	public Bus() {
		//TODO: the number of spots should be on the vehicleSize?
		this.spotsNeeded = 5;
		size = VehicleSize.Compact;
	}
	
	@Override
	public boolean canFitInSpot(ParkingSpot s) {
		return false;
	}

}
