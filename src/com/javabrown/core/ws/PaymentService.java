package com.javabrown.core.ws;
 
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.javabrown.core.ws.TransactionBo;
 
@Component
@Path("/payment")
public class PaymentService {
 
	@Autowired
	TransactionBo transactionBo;
 
	@GET
	@Path("/{param}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response savePayment(@PathParam("param") String name) {
 
		String result = transactionBo.save(name);
 
		return Response.status(200).entity(result).build();
 
	}
 
}