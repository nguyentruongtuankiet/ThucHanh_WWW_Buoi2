package vn.edu.iuh.fit.thuchanhwww_buoi2.backend.resources;


import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import vn.edu.iuh.fit.thuchanhwww_buoi2.backend.models.Customer;
import vn.edu.iuh.fit.thuchanhwww_buoi2.backend.services.CustomerServices;

import java.util.List;
import java.util.Optional;

@Path("/customer")
public class CustomerResources {

    @Inject
    private CustomerServices service;


    @POST
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Response add(Customer customer){
        service.add(customer);
        return Response.ok(customer).build();
    }
    @GET
    @Produces({"application/json"})
    @Path("/{id}")
    public Response getProductById(@PathParam("id") long id){
        Optional<Customer> t = service.getCustomerById(id);
        if(t.isPresent()){
            return Response.ok(id).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
    @GET
    @Produces({"application/json"})
    public Response getAll(){
        List<Customer> customerList = service.getAll();
        return Response.ok(customerList).build();
    }


}
