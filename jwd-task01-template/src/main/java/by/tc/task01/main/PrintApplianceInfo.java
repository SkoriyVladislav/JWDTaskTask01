package by.tc.task01.main;

import by.tc.task01.entity.Appliance;

public class PrintApplianceInfo {
	
	public static void print(Appliance appliance) {
		// you may add your own code here
		System.out.println(appliance != null ? appliance.toString() : "null");
	}

}
