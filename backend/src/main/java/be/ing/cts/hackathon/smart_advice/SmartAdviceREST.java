package be.ing.cts.hackathon.smart_advice;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/")
public class SmartAdviceREST {

  @GET
  @Path("/checkDB")
  @Produces(MediaType.APPLICATION_JSON)
  public Response checkDBConnection() {
    return Response.ok().build();
  }
}
