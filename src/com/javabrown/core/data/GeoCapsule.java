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
	
	public List<Map<String,String>> getStates(){
		try {
			BrownGeoCapsuleI us = this.geo.getGeoCapsule("US");
			return us.getCapsuleData().getAllStates();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
