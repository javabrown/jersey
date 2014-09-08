package com.javabrown.core.ws;

import java.util.List;
import java.util.Map;

import javax.activation.MimetypesFileTypeMap;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.javabrown.core.data.GeoCapsule;

@Component
@Path("/geo")
public class GeoService {
	@Autowired
	GeoCapsule capsuleInjection;
	
	@GET
	@Path("/{param}")
	@Produces(MediaType.APPLICATION_XML)
	public State getStates(@PathParam("param") String name) {
		//List<Map<String, String>> x = capsuleInjection.getStates();
		//return Response.ok(x).build();
		return new State(name);
	}
}

@XmlRootElement
class State {
    @XmlTransient
    public String cities;

	public State(String cities) {
		this.cities = cities;
	}
 }