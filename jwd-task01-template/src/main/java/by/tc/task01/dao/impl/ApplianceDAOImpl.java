package by.tc.task01.dao.impl;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.entity.*;
import by.tc.task01.entity.criteria.Criteria;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ApplianceDAOImpl implements ApplianceDAO{

	@Override
	public <E> Appliance find(Criteria<E> criteria) {
		// you may add your own code
		String line;
		boolean flag = false;
		Appliance appliance = null;
		String[] criterions = criteria.getCriterions();

		try (final BufferedReader br = new BufferedReader(
				new InputStreamReader(
						new FileInputStream(new File("jwd-task01-template/src/main/resources/appliances_db.txt"))))){

			while ((line = br.readLine()) != null) {

				if (line.contains(criteria.getApplianceType())) {

					for (String str : criterions) {

						if (Pattern.matches("^.+"+str+"((^\\.)|,|;)(.+)?$", line)) {
							flag = true;
						} else {
							if (Pattern.matches("^(.+)FREQUENCY_RANGE=(.+)$", line)) {
								Pattern pat = Pattern.compile("[-]?[0-9]+(.[0-9]+)?(^-)");
								Matcher matcher = pat.matcher(line);
								List<Double> doubleSet = new ArrayList<>();
								while (matcher.find()) {
									doubleSet.add(Double.valueOf(matcher.group()));
								}
								for (int i = 0; i < doubleSet.size(); i++) {
									if (line.contains("FRFREQUENCY_RANGE=" + doubleSet.get(i))) {
										matcher = pat.matcher(str);
										if (doubleSet.get(i) >= Double.valueOf(matcher.group()) && doubleSet.get(i + 1) <= Double.valueOf(matcher.group())) {
											flag = true;
										}
									}
								}
							}

							else {
								flag = false;
								break;
							}
						}


					}
				}

				if (flag) {
					return createAppleance(line,criteria.getApplianceType());
				}

			}
		}
		catch (UnsupportedEncodingException | FileNotFoundException ex) {
			System.out.println("Cannot open the file appliances_db.txt");
		}
		catch (IOException ex) {
			System.out.println("Cannot open the file appliances_db.txt");
		}


		return appliance;
	}
	
	// you may add your own code here
	private <E> Appliance createAppleance(String line, String criteria) {
		Appliance appliance = null;
		if (criteria.equals("Oven")) {
			appliance = createOven(line);
		}
		if (criteria.equals("Laptop")) {
			appliance = createLaptop(line);
		}
		if (criteria.equals("Refrigerator")) {
			appliance = createRefrigerator(line);
		}
		if (criteria.equals("Speakers")) {
			appliance = createSpeakers(line);
		}
		if (criteria.equals("TabletPC")) {
			appliance = createTabletPC(line);
		}
		if (criteria.equals("VacuumCleaner")) {
			appliance = createVacuumCleaner(line);
		}

		return appliance;
	}

	private Appliance createOven(String line) {
		Appliance appliance;

		Pattern pat = Pattern.compile("POWER_CONSUMPTION=[0-9]+(.[0-9]+)?");
		Matcher matcher = pat.matcher(line);
		matcher.find();
		double powerConsumption = Double.valueOf(matcher.group().replaceAll("\\D+", " ").trim());

		pat = Pattern.compile("WEIGHT=[0-9]+(.[0-9]+)?");
		matcher = pat.matcher(line);
		matcher.find();
		double weight = Double.valueOf(matcher.group().replaceAll("\\D+", " ").trim());

		pat = Pattern.compile("CAPACITY=[0-9]+(.[0-9]+)?");
		matcher = pat.matcher(line);
		matcher.find();
		double capasity = Double.valueOf(matcher.group().replaceAll("\\D+", " ").trim());

		pat = Pattern.compile("DEPTH=[0-9]+(.[0-9]+)?");
		matcher = pat.matcher(line);
		matcher.find();
		double depth = Double.valueOf(matcher.group().replaceAll("\\D+", " ").trim());

		pat = Pattern.compile("WIDTH=[0-9]+(.[0-9]+)?");
		matcher = pat.matcher(line);
		matcher.find();
		double width = Double.valueOf(matcher.group().replaceAll("\\D+", " ").trim());

		pat = Pattern.compile("HEIGHT=[0-9]+(.[0-9]+)?");
		matcher = pat.matcher(line);
		matcher.find();
		double height = Double.valueOf(matcher.group().replaceAll("\\D+", " ").trim());

		appliance = new Oven(powerConsumption, weight, capasity, depth, height, width);

		return appliance;
	}

	private Appliance createLaptop(String line) {
		Appliance appliance;

		Pattern pat = Pattern.compile("BATTERY_CAPACITY=[0-9]+(.[0-9]+)?");
		Matcher matcher = pat.matcher(line);
		matcher.find();
		double  batteryCapacity= Double.valueOf(matcher.group().replaceAll("([a-z]|[A-Z]|=|_)", " ").trim());

		pat = Pattern.compile("MEMORY_ROM=[0-9]+(.[0-9]+)?");
		matcher = pat.matcher(line);
		matcher.find();
		double memoryRom = Double.valueOf(matcher.group().replaceAll("([a-z]|[A-Z]|=|_)", " ").trim());

		pat = Pattern.compile("SYSTEM_MEMORY=[0-9]+(.[0-9]+)?");
		matcher = pat.matcher(line);
		matcher.find();
		double systemMemory = Double.valueOf(matcher.group().replaceAll("([a-z]|[A-Z]|=|_)", " ").trim());

		pat = Pattern.compile("CPU=[0-9]+(.[0-9]+)?");
		matcher = pat.matcher(line);
		matcher.find();
		double CPU = Double.valueOf(matcher.group().replaceAll("([a-z]|[A-Z]|=|_)", " ").trim());

		pat = Pattern.compile("DISPLAY_INCHS=[0-9]+(.[0-9]+)?");
		matcher = pat.matcher(line);
		matcher.find();
		double displayInchs = Double.valueOf(matcher.group().replaceAll("([a-z]|[A-Z]|=|_)", " ").trim());

		pat = Pattern.compile("OS=[a-z|A-Z]+(.[a-z|A-z]+)?");
		matcher = pat.matcher(line);
		matcher.find();
		String OS = matcher.group().substring(3);

		appliance = new Laptop(batteryCapacity, memoryRom, systemMemory, CPU, displayInchs, OS);

		return appliance;
	}

	private Appliance createRefrigerator(String line) {
		Appliance appliance;

		Pattern pat = Pattern.compile("POWER_CONSUMPTION=[0-9]+(.[0-9]+)?");
		Matcher matcher = pat.matcher(line);
		matcher.find();
		double  powerConsumption = Double.valueOf(matcher.group().replaceAll("([a-z]|[A-Z]|=|_)", " ").trim());

		pat = Pattern.compile("WEIGHT=[0-9]+(.[0-9]+)?");
		matcher = pat.matcher(line);
		matcher.find();
		double weight = Double.valueOf(matcher.group().replaceAll("([a-z]|[A-Z]|=|_)", " ").trim());

		pat = Pattern.compile("FREEZER_CAPACITY=[0-9]+(.[0-9]+)?");
		matcher = pat.matcher(line);
		matcher.find();
		double freezerCapacity = Double.valueOf(matcher.group().replaceAll("([a-z]|[A-Z]|=|_)", " ").trim());

		pat = Pattern.compile("OVERALL_CAPACITY=[0-9]+(.[0-9]+)?");
		matcher = pat.matcher(line);
		matcher.find();
		double overallCapacity = Double.valueOf(matcher.group().replaceAll("([a-z]|[A-Z]|=|_)", " ").trim());

		pat = Pattern.compile("HEIGHT=[0-9]+(.[0-9]+)?");
		matcher = pat.matcher(line);
		matcher.find();
		double height = Double.valueOf(matcher.group().replaceAll("([a-z]|[A-Z]|=|_)", " ").trim());

		pat = Pattern.compile("WIDTH=[0-9]+(.[0-9]+)?");
		matcher = pat.matcher(line);
		matcher.find();
		double width = Double.valueOf(matcher.group().replaceAll("([a-z]|[A-Z]|=|_)", " ").trim());

		appliance = new Refrigerator(powerConsumption, weight, freezerCapacity, overallCapacity, height, width);

		return appliance;
	}

	private Appliance createSpeakers(String line) {
		Appliance appliance;

		Pattern pat = Pattern.compile("POWER_CONSUMPTION=[0-9]+(.[0-9]+)?");
		Matcher matcher = pat.matcher(line);
		matcher.find();
		double  powerConsumption = Double.valueOf(matcher.group().replaceAll("([a-z]|[A-Z]|=|_)", " ").trim());

		pat = Pattern.compile("NUMBER_OF_SPEAKERS=[0-9]+(.[0-9]+)?");
		matcher = pat.matcher(line);
		matcher.find();
		double numberOfSpeakers = Double.valueOf(matcher.group().replaceAll("([a-z]|[A-Z]|=|_)", " ").trim());

		pat = Pattern.compile("FREQUENCY_RANGE=[0-9]+(.[0-9]+)?");
		matcher = pat.matcher(line);
		matcher.find();
		String frequencyRange = matcher.group().substring("FREQUENCY_RANGE=".length());

		pat = Pattern.compile("CORD_LENGTH=[0-9]+(.[0-9]+)?");
		matcher = pat.matcher(line);
		matcher.find();
		double cordLength = Double.valueOf(matcher.group().replaceAll("([a-z]|[A-Z]|=|_)", " ").trim());

		appliance = new Speakers(powerConsumption, numberOfSpeakers, frequencyRange, cordLength);

		return appliance;
	}

	private Appliance createTabletPC(String line) {
		Appliance appliance;

		Pattern pat = Pattern.compile("BATTERY_CAPACITY=[0-9]+(.[0-9]+)?");
		Matcher matcher = pat.matcher(line);
		matcher.find();
		double  batteryCapacity = Double.valueOf(matcher.group().replaceAll("([a-z]|[A-Z]|=|_)", " ").trim());

		pat = Pattern.compile("DISPLAY_INCHES=[0-9]+(.[0-9]+)?");
		matcher = pat.matcher(line);
		matcher.find();
		double displayInches = Double.valueOf(matcher.group().replaceAll("([a-z]|[A-Z]|=|_)", " ").trim());

		pat = Pattern.compile("MEMORY_ROM=[0-9]+(.[0-9]+)?");
		matcher = pat.matcher(line);
		matcher.find();
		double memoryRom = Double.valueOf(matcher.group().replaceAll("([a-z]|[A-Z]|=|_)", " ").trim());

		pat = Pattern.compile("FLASH_MEMORY_CAPACITY=[0-9]+(.[0-9]+)?");
		matcher = pat.matcher(line);
		matcher.find();
		double flashMemoryCapacity = Double.valueOf(matcher.group().replaceAll("([a-z]|[A-Z]|=|_)", " ").trim());

		pat = Pattern.compile("COLOR=[a-z|A-Z]+(.[a-z|A-z]+)?");
		matcher = pat.matcher(line);
		matcher.find();
		String color = matcher.group().substring("COLOR=".length());

		appliance = new TabletPC(batteryCapacity, displayInches, memoryRom, flashMemoryCapacity, color);

		return appliance;
	}

	private Appliance createVacuumCleaner(String line) {
		Appliance appliance;

		Pattern pat = Pattern.compile("POWER_CONSUMPTION=[0-9]+(.[0-9]+)?");
		Matcher matcher = pat.matcher(line);
		matcher.find();
		double  powerConsumption = Double.valueOf(matcher.group().replaceAll("([a-z]|[A-Z]|=|_)", " ").trim());

		pat = Pattern.compile("MOTOR_SPEED_REGULATION=[0-9]+(.[0-9]+)?");
		matcher = pat.matcher(line);
		matcher.find();
		double motorSpeedRegulation = Double.valueOf(matcher.group().replaceAll("([a-z]|[A-Z]|=|_)", " ").trim());

		pat = Pattern.compile("CLEANING_WIDTH=[0-9]+(.[0-9]+)?");
		matcher = pat.matcher(line);
		matcher.find();
		double cleaningWidth = Double.valueOf(matcher.group().replaceAll("([a-z]|[A-Z]|=|_)", " ").trim());

		pat = Pattern.compile("FILTER_TYPE=[a-z|A-Z]+(.[a-z|A-z]+)?");
		matcher = pat.matcher(line);
		matcher.find();
		String filterType = matcher.group().substring("FILTER_TYPE=".length());

		pat = Pattern.compile("BAG_TYPE=[a-z|A-Z|0-9|-]+(.[a-z|A-Z|0-9|-]+)?");
		matcher = pat.matcher(line);
		matcher.find();
		String bagType = matcher.group().substring("BAG_TYPE=".length());

		pat = Pattern.compile("WAND_TYPE=[a-z|A-Z|0-9|-]+(.[a-z|A-Z|0-9|-]+)?");
		matcher = pat.matcher(line);
		matcher.find();
		String wandType = matcher.group().substring("WAND_TYPE=".length());

		appliance = new VacuumCleaner(powerConsumption, motorSpeedRegulation, cleaningWidth, filterType, bagType, wandType);

		return appliance;
	}
}


//you may add your own new classes