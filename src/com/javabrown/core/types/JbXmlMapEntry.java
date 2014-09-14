package com.javabrown.core.types;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;

public class JbXmlMapEntry {
	@XmlAttribute
	public String key;

	@XmlValue
	public String value;
}
