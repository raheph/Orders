package com.model;
import com.fasterxml.jackson.annotation.JsonFormat;
import javax.persistence.*;
import javax.ws.rs.Consumes;

import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by ephrar1 on 8/14/2017.
 */
@Entity
@Table(name = "Orders")
public class Orders {
    @Id
    @Column(name = "OrderId")
    private String OrderId;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    @Column(name = "placementDate")
    private Date placementDate;

    @Column(name = "customerName")
    private String customerName;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<OrderItems> orderItems;

    public List<OrderItems> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItems> orderItems) {
        this.orderItems = orderItems;
    }

    public String getOrderId() {
        return OrderId;
    }

    public void setOrderId(String orderId) {
        OrderId = orderId;
    }

    public Date getPlacementDate() {
        return placementDate;
    }

    public void setPlacementDate(Date placementDate) {
        this.placementDate = placementDate;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Orders(){}
    public Orders(String OrderId, Date placementDate, String customerName, List<OrderItems> orderItems){
        this.OrderId = OrderId;
        this.placementDate = placementDate;
        this.customerName = customerName;
        this.orderItems = orderItems;
    }
}
