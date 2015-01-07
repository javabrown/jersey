package com.javabrown.core.data;

import java.util.List;
import java.util.Map;

import com.javabrown.core.data.cache.JBrownCache;
import com.jbrown.ext.capsule.BrownCapsule;
import com.jbrown.ext.capsule.impl.BrownGeoCapsuleI;

public class GeoCapsule {
	private BrownCapsule geo;

	public GeoCapsule() {
		geo = new BrownCapsule();
	}
	
	public List<Map<String,String>> getStates(String countryCode){
		Object stateObj = JBrownCache.getInstance().get("states");
		
		List<Map<String,String>> states = null;
		
		if(stateObj != null && stateObj instanceof List) {
			states = (List<Map<String,String>>) stateObj;
		}
		
		if(states != null && states.size() > 0){//cache read
			return states;
		}
		
		try {
			if(countryCode == null || countryCode.trim().equalsIgnoreCase("")){
				countryCode = "US";
			}
			
			BrownGeoCapsuleI state = this.geo.getGeoCapsule(countryCode.toUpperCase());
			if(state == null || state.getCapsuleData() == null){
				state = this.geo.getGeoCapsule(countryCode);
			}
			
			states = state.getCapsuleData().getAllStates();
			JBrownCache.getInstance().put("states", states);
			return states;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
