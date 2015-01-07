package com.javabrown.core.ws;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;

import com.javabrown.core.data.cache.JBrownCache;

@Component
@Path("/hello")
public class PingService {
	@GET
	@Path("/{param}")
	public Response getMsg(@PathParam("param") String msg){
		String output = "Jersey say : " + msg;
		JBrownCache.getInstance().put("test", "RAJA KHAN");
		return Response.status(200).entity(output).build();
	}
}