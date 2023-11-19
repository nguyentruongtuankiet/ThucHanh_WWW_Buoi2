package vn.edu.iuh.fit.thuchanhwww_buoi2.backend.resources;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import vn.edu.iuh.fit.thuchanhwww_buoi2.backend.models.ProductPrice;
import vn.edu.iuh.fit.thuchanhwww_buoi2.backend.services.ProductPriceServices;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Path("/productPrice")
public class ProductPriceResource {

    private ProductPriceServices service;

    public ProductPriceResource() {
       service = new ProductPriceServices();
    }

    @POST
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Response addProductPrice(ProductPrice productPrice){
        service.addProductPrice(productPrice);
        return Response.ok(productPrice).build();
    }
    @DELETE
    @Path("/{id}")
    public Response deleteProductPrice(@PathParam("id") long productId, LocalDateTime priceDateTime){
        if(service.deleteProductPrice(productId, priceDateTime)){
            return  Response.ok().build();
        }
        return  Response.status(Response.Status.NOT_FOUND).build();
    }

    @GET
    @Produces({"application/json"})
    public Response getAll(){
        List<ProductPrice> priceList = service.getAll();
        return Response.ok(priceList).build();
    }

    @GET
    @Produces({"application/json"})
    @Path("/{id}")
    public Response getProductPriceById(@PathParam("id") long productId, LocalDateTime priceDateTime){
        Optional<ProductPrice> t = service.getProductPriceById(productId, priceDateTime);
        if(t.isPresent()){
            return Response.ok(t.get()).build();
        }
        else{
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }
    @GET
    @Produces({"application/json"})
    @Path("/newPrice/{product_id}")
    public Response getNewPriceByIdProduct(@PathParam("product_id") String productId){
        Double newPrice = service.getNewPriceByIdProduct(productId);
        if(newPrice != null){
            return Response.ok(newPrice).build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }
}
