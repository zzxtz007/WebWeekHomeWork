package top.haha233.service.util;

import java.util.List;
import java.util.Map;

public class SuperInfo {
	public int ret = 0;
	public Map retMap;
	public int retMapSize;
	public List retList;
	public int retListSize;

	public int getRetMapSize() {
		if (retMap == null) {
			retMapSize = -1;
			return retMapSize;
		}
		retMapSize = retMap.size();
		return retMapSize;
	}


	public int getRetListSize() {
		if (retList == null) {
			retListSize = -1;
			return retListSize;
		}
		retListSize = retList.size();
		return retListSize;
	}

	public Map getRetMap() {
		return retMap;
	}

	public List getRetList() {
		return retList;
	}
}
