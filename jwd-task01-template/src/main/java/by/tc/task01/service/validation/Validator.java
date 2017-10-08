package by.tc.task01.service.validation;

import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.entity.criteria.SearchCriteria;

import java.util.Map;


public class Validator {
	public static <E> boolean criteriaValidator(Criteria<E> criteria) {
		// you may add your own code here

		validateCriteria(criteria);
		return true;
	}

	private static <E> boolean validateCriteria(Criteria<E> criteria) {

		if (criteria.getApplianceType() == "Oven") {
			return validateCriteriaOven(criteria);
		}
		if (criteria.getApplianceType() == "Laptop") {
			return validateCriteriaLaptop(criteria);
		}
		if (criteria.getApplianceType() == "Refrigerator") {
			return validateCriteriaRefrigerator(criteria);
		}
		if (criteria.getApplianceType() == "Speakers") {
			return validateCriteriaSpeakers(criteria);
		}
		if (criteria.getApplianceType() == "TabletPC") {
			return validateCriteriaTabletPC(criteria);
		} else {
			return validateCriteriaVacuumCleaner(criteria);
		}
	}

	private static <E> boolean validateCriteriaLaptop(Criteria<E> criteria) {
		Map.Entry[] entries = criteria.getEntry();
		for (int i = 0; i < entries.length; i++) {
			if (SearchCriteria.Laptop.BATTERY_CAPACITY == entries[i].getKey()) {
				if (((Number)entries[i].getValue()).doubleValue() < 0) {
					return false;
				}
			}

			if (SearchCriteria.Laptop.OS == entries[i].getKey()) {
				if (!(entries[i].getValue() instanceof String)) {
					return false;
				}
			}

			if (SearchCriteria.Laptop.CPU == entries[i].getKey()) {
				if (((Number)entries[i].getValue()).doubleValue() < 0) {
					return false;
				}
			}

			if (SearchCriteria.Laptop.DISPLAY_INCHS == entries[i].getKey()) {
				if (((Number)entries[i].getValue()).doubleValue() < 0) {
					return false;
				}
			}

			if (SearchCriteria.Laptop.MEMORY_ROM == entries[i].getKey()) {
				if (((Number)entries[i].getValue()).doubleValue() < 0) {
					return false;
				}
			}

			if (SearchCriteria.Laptop.SYSTEM_MEMORY == entries[i].getKey()) {
				if (((Number)entries[i].getValue()).doubleValue() < 0) {
					return false;
				}
			}
		}

		return true;
	}


	private static <E> boolean validateCriteriaOven(Criteria<E> criteria) {
		Map.Entry[] entries = criteria.getEntry();
		for (int i = 0; i < entries.length; i++) {
			if (SearchCriteria.Oven.POWER_CONSUMPTION == entries[i].getKey()) {
				if (((Number) entries[i].getValue()).doubleValue() < 0) {
					return false;
				}
			}

			if (SearchCriteria.Oven.CAPACITY == entries[i].getKey()) {
				if (((Number) entries[i].getValue()).doubleValue() < 0) {
					return false;
				}
			}

			if (SearchCriteria.Oven.DEPTH == entries[i].getKey()) {
				if (((Number) entries[i].getValue()).doubleValue() < 0) {
					return false;
				}
			}

			if (SearchCriteria.Oven.HEIGHT == entries[i].getKey()) {
				if (((Number) entries[i].getValue()).doubleValue() < 0) {
					return false;
				}
			}

			if (SearchCriteria.Oven.WEIGHT == entries[i].getKey()) {
				if (((Number) entries[i].getValue()).doubleValue() < 0) {
					return false;
				}
			}

			if (SearchCriteria.Oven.WIDTH == entries[i].getKey()) {
				if (((Number) entries[i].getValue()).doubleValue() < 0) {
					return false;
				}
			}
		}

		return true;
	}


	private static <E> boolean validateCriteriaRefrigerator(Criteria<E> criteria) {
		Map.Entry[] entries = criteria.getEntry();
		for (int i = 0; i < entries.length; i++) {
			if (SearchCriteria.Refrigerator.POWER_CONSUMPTION == entries[i].getKey()) {
				if (((Number)entries[i].getValue()).doubleValue() < 0) {
					return false;
				}
			}

			if (SearchCriteria.Refrigerator.FREEZER_CAPACITY == entries[i].getKey()) {
				if (((Number)entries[i].getValue()).doubleValue() < 0) {
					return false;
				}
			}

			if (SearchCriteria.Refrigerator.OVERALL_CAPACITY == entries[i].getKey()) {
				if (((Number)entries[i].getValue()).doubleValue() < 0) {
					return false;
				}
			}

			if (SearchCriteria.Refrigerator.HEIGHT == entries[i].getKey()) {
				if (((Number)entries[i].getValue()).doubleValue() < 0) {
					return false;
				}
			}

			if (SearchCriteria.Refrigerator.WEIGHT == entries[i].getKey()) {
				if (((Number)entries[i].getValue()).doubleValue() < 0) {
					return false;
				}
			}

			if (SearchCriteria.Refrigerator.WIDTH == entries[i].getKey()) {
				if (((Number)entries[i].getValue()).doubleValue() < 0) {
					return false;
				}
			}
		}

		return true;
	}



	private static <E> boolean validateCriteriaSpeakers(Criteria<E> criteria) {
		Map.Entry[] entries = criteria.getEntry();
		for (int i = 0; i < entries.length; i++) {
			if (SearchCriteria.Speakers.POWER_CONSUMPTION == entries[i].getKey()) {
				if (((Number)entries[i].getValue()).doubleValue() < 0) {
					return false;
				}
			}

			if (SearchCriteria.Speakers.CORD_LENGTH == entries[i].getKey()) {
				if (((Number)entries[i].getValue()).doubleValue() < 0) {
					return false;
				}
			}

			if (SearchCriteria.Speakers.FREQUENCY_RANGE == entries[i].getKey()) {
				if (((Number)entries[i].getValue()).doubleValue() < 0) {
					return false;
				}
			}

			if (SearchCriteria.Speakers.NUMBER_OF_SPEAKERS == entries[i].getKey()) {
				if (((Number)entries[i].getValue()).doubleValue() < 0) {
					return false;
				}
			}
		}

		return true;
	}


	private static <E> boolean validateCriteriaTabletPC(Criteria<E> criteria) {
		Map.Entry[] entries = criteria.getEntry();
		for (int i = 0; i < entries.length; i++) {
			if (SearchCriteria.TabletPC.COLOR == entries[i].getKey()) {
				if (!(entries[i].getValue() instanceof String)) {
					return false;
				}
			}

			if (SearchCriteria.TabletPC.DISPLAY_INCHES == entries[i].getKey()) {
				if (((Number)entries[i].getValue()).doubleValue() < 0) {
					return false;
				}
			}

			if (SearchCriteria.TabletPC.MEMORY_ROM == entries[i].getKey()) {
				if (((Number)entries[i].getValue()).doubleValue() < 0) {
					return false;
				}
			}

			if (SearchCriteria.TabletPC.BATTERY_CAPACITY == entries[i].getKey()) {
				if (((Number)entries[i].getValue()).doubleValue() < 0) {
					return false;
				}
			}

			if (SearchCriteria.TabletPC.FLASH_MEMORY_CAPACITY == entries[i].getKey()) {
				if (((Number)entries[i].getValue()).doubleValue() < 0) {
					return false;
				}
			}
		}

		return true;
	}


	private static <E> boolean validateCriteriaVacuumCleaner(Criteria<E> criteria) {
		Map.Entry[] entries = criteria.getEntry();
		for (int i = 0; i < entries.length; i++) {
			if (SearchCriteria.VacuumCleaner.POWER_CONSUMPTION == entries[i].getKey()) {
				if (((Number)entries[i].getValue()).doubleValue() < 0) {
					return false;
				}
			}

			if (SearchCriteria.VacuumCleaner.BAG_TYPE == entries[i].getKey()) {
				if (!(entries[i].getValue() instanceof String)) {
					return false;
				}
			}

			if (SearchCriteria.VacuumCleaner.CLEANING_WIDTH == entries[i].getKey()) {
				if (((Number)entries[i].getValue()).doubleValue() < 0) {
					return false;
				}
			}

			if (SearchCriteria.VacuumCleaner.FILTER_TYPE == entries[i].getKey()) {
				if (!(entries[i].getValue() instanceof String)) {
					return false;
				}
			}

			if (SearchCriteria.VacuumCleaner.MOTOR_SPEED_REGULATION == entries[i].getKey()) {
				if (((Number)entries[i].getValue()).doubleValue() < 0) {
					return false;
				}
			}

			if (SearchCriteria.VacuumCleaner.WAND_TYPE == entries[i].getKey()) {
				if (!(entries[i].getValue() instanceof String)) {
					return false;
				}
			}
		}

		return true;
	}
}

//you may add your own new classes