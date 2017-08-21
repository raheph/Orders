package com.services;

import com.DB.DataBaseConnection;
import com.model.Items;
import com.model.OrderItems;
import com.model.Orders;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.logging.Logger;


@Path("/Order")
public class OrdersApi
{
    private static final Logger LOGGER = Logger.getLogger(OrdersApi.class.getName());
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{orderId}")
    public List<OrderItems> getMsg(@PathParam("orderId") String orderId)
    {
        return DataBaseConnection.getOrders(orderId);
    }

    @POST
    @Path("/Orders")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String getOrders(Orders orders){
        String result = "Saved Orders : " + orders;
        LOGGER.info("Orders id : " + orders.getOrderId());
        return orders.getOrderId() + " " + orders.getCustomerName() + " " + orders.getPlacementDate();
    }
}
