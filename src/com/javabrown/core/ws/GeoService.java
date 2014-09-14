package com.javabrown.core.ws;

import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.javabrown.core.data.GeoCapsule;
import com.javabrown.core.types.JbXmlMapAdapter;

@Component
@Path("/geo")
public class GeoService {
	@Autowired
	GeoCapsule capsuleInjection;
	
	@GET
	@Path("/{country-name}")
	@Produces(MediaType.APPLICATION_XML)
	public StateResponse getStates(@PathParam("country-name") String countryName) {
		List<Map<String, String>> states = capsuleInjection.getStates(countryName);
		return new StateResponse(states);
	}
}

@XmlRootElement
class StateResponse{
	@XmlJavaTypeAdapter(JbXmlMapAdapter.class)
	List<Map<String, String>> map;
	
	public StateResponse(){
		map = null;
	}
	
	public StateResponse(List<Map<String, String>> map){
		this.map = map;
	}
}
//
// @XmlRootElement
// class XmlResponse {
//     public int id;
//     public String name;
//     public double radius;
//     
//     public XmlResponse(){
//       	 this.id = -1;
//    	 this.name = "Unknown";
//    	 this.radius = -0000.00; 
//     }
//     
//     public XmlResponse(int id, String name, double radius){
//    	 this.id = id;
//    	 this.name = name;
//    	 this.radius = radius;
//     }
// }
