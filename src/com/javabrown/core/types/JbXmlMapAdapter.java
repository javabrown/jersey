package com.javabrown.core.types;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.xml.bind.annotation.adapters.XmlAdapter;
 
public class JbXmlMapAdapter extends XmlAdapter<JbXmlMap, Map<String, String>> {
	@Override
	public JbXmlMap marshal(Map<String, String> arg0) throws Exception {
		JbXmlMap myMapType = new JbXmlMap();
		for (Entry<String, String> entry : arg0.entrySet()) {
			JbXmlMapEntry myMapEntryType = new JbXmlMapEntry();
			myMapEntryType.key = entry.getKey();
			myMapEntryType.value = entry.getValue();
			myMapType.entry.add(myMapEntryType);
		}
		return myMapType;
	}

	@Override
	public Map<String, String> unmarshal(JbXmlMap arg0) throws Exception {
		Map<String, String> hashMap = new HashMap<String, String>();
		for (JbXmlMapEntry myEntryType : arg0.entry) {
			hashMap.put(myEntryType.key, myEntryType.value);
		}
		return hashMap;
	}
}