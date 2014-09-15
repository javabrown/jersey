package com.javabrown.core.data;

import java.util.List;
import java.util.Map;

import com.jbrown.ext.capsule.BrownCapsule;
import com.jbrown.ext.capsule.impl.BrownGeoCapsuleI;

public class GeoCapsule {
	private BrownCapsule geo;

	public GeoCapsule() {
		geo = new BrownCapsule();
	}
	
	public List<Map<String,String>> getStates(String countryCode){
		try {
			if(countryCode == null || countryCode.trim().equalsIgnoreCase("")){
				countryCode = "US";
			}
			
			BrownGeoCapsuleI state = this.geo.getGeoCapsule(countryCode.toUpperCase());
			if(state == null || state.getCapsuleData() == null){
				state = this.geo.getGeoCapsule(countryCode);
			}
			return state.getCapsuleData().getAllStates();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
