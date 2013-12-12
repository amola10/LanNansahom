package eg.net.lanNansahom.client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class VictimNavigation {

	private final List<Integer> ids = new ArrayList<Integer>();
	private final HashMap<Integer, Integer> idsIndex = new HashMap<Integer, Integer>();

	public void add(Integer pId) {
		ids.add(pId);
		idsIndex.put(pId, ids.size() - 1);
	}

	public Integer getNextId(Integer pId) {
		Integer result = null;
		Integer index = idsIndex.get(pId);
		if (index != null && index < ids.size() - 1) {
			result = ids.get(index + 1);
		}
		return result;
	}

	public Integer getPreviousId(Integer pId) {
		Integer result = null;
		Integer index = idsIndex.get(pId);
		if (index != null && index > 0) {
			result = ids.get(index - 1);
		}
		return result;
	}

	public Integer getFirstId() {
		Integer result = null;
		if (ids.size() > 0) {
			result = ids.get(0);
		}
		return result;
	}

	public Integer getLastId() {
		Integer result = null;
		if (ids.size() > 0) {
			result = ids.get(ids.size() - 1);
		}
		return result;
	}

}
