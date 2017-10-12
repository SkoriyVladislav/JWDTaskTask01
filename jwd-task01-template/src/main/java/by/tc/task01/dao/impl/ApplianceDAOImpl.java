package by.tc.task01.dao.impl;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.entity.*;
import by.tc.task01.entity.criteria.Criteria;

import java.io.*;
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
								Pattern pat = Pattern.compile("FREQUENCY_RANGE=[0-9]+(.[0-9]+)");
								Matcher matcher = pat.matcher(line);
								String[] arr = null;
								if (matcher.find())	{
									arr = (matcher.group().replaceAll("([a-z]|[A-Z]|=|_|-)", " ").trim().split(" "));
								}

								if (Double.valueOf(arr[0]) <= Double.valueOf(str.replaceAll("([a-z]|[A-Z]|=|_|-)", " ").trim()) && Double.valueOf(arr[1]) >= Double.valueOf(str.replaceAll("([a-z]|[A-Z]|=|_|-)", " ").trim())) {
									flag = true;
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
			ex.printStackTrace();
			System.exit(0);
		}
		catch (IOException ex) {
			System.out.println("Cannot open the file appliances_db.txt");
			ex.printStackTrace();
			System.exit(0);
		}


		return appliance;
	}
	
	// you may add your own code here
	private Appliance createAppleance(String line, String criteria) {
		Appliance appliance = null;
		if (criteria.equals("Oven")) {
			appliance = Oven.create(line);
		}
		if (criteria.equals("Laptop")) {
			appliance = Laptop.create(line);
		}
		if (criteria.equals("Refrigerator")) {
			appliance = Refrigerator.create(line);
		}
		if (criteria.equals("Speakers")) {
			appliance = Speakers.create(line);
		}
		if (criteria.equals("TabletPC")) {
			appliance = TabletPC.create(line);
		}
		if (criteria.equals("VacuumCleaner")) {
			appliance = VacuumCleaner.create(line);
		}

		return appliance;
	}
}


//you may add your own new classes