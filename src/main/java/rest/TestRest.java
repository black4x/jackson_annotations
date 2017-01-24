package rest;

import dto.jsonanygetter.ExtendableBean;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("test")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TestRest {

    @GET
    public ExtendableBean test() {
        ExtendableBean bean =  new ExtendableBean("hi");
        bean.add("key1", "value1");
        return bean;
    }

    @POST
    public ExtendableBean testPOst(ExtendableBean bean) {
        return bean;
    }
}
