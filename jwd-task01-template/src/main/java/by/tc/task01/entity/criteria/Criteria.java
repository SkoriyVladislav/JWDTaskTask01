package by.tc.task01.entity.criteria;

import java.util.HashMap;
import java.util.Map;

public class Criteria<E> {

	private String applianceType;

	private Map<E, Object> criteria = new HashMap<E, Object>();

	public void add(E searchCriteria, Object value) {
		criteria.put(searchCriteria, value);
	}

	public String[] getCriterions() {
		String[] criterions = new String[criteria.size()];
		int i = 0;
		for (Map.Entry entry : criteria.entrySet()) {
			criterions[i] = entry.getKey().toString() + "=" + entry.getValue().toString();
			i++;
		}
		return criterions;
	}

	public Map.Entry[] getEntry() {
		Map.Entry[] entries = new Map.Entry[criteria.size()];
		int i = 0;
		for (Map.Entry entry : criteria.entrySet()) {
			entries[i] = entry;
			i++;
		}
		return entries;
	}

	public String getApplianceType() {
		return applianceType;
	}

	public void setApplianceType(String applianceType) {
		this.applianceType = applianceType;
	}

	// you may add your own code here

}
