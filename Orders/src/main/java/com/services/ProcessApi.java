package com.services;

import com.model.Items;
import com.model.OrderItems;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.GenericType;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.math.BigDecimal;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by Rahel Ephrem on 8/17/2017.
 */
@Path("/Process")
public class ProcessApi {
    private static final Logger LOGGER = Logger.getLogger(ProcessApi.class.getName());
    @GET
    @Path("/{orderId}")
    @Produces (MediaType.TEXT_PLAIN)
    public String getTotalCost(@PathParam("orderId") String orderId){
        BigDecimal total = new BigDecimal(0);
        List<OrderItems> items = getItems(orderId);
        for (OrderItems i : items){
            BigDecimal tempTotal = total.add(i.getItems().getItemCost().multiply(new BigDecimal(i.getItemCount())));
            total = tempTotal;
        }
        return total.toString();
    }

    private List<OrderItems> getItems(String orderId){
        Client client = Client.create();
        String uri = "http://localhost:8080/Orders/rest/Order/" + orderId;
        return  client.resource(uri).get(new GenericType<List<OrderItems>>(){});
    }

}
