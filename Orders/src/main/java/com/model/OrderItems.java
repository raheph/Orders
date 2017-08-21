package com.model;
import javax.persistence.*;
import java.util.List;
import java.util.Set;

/**
 * Created by ephrar1 on 8/16/2017.
 */
@Entity
@Table(name = "OrderItems")
public class OrderItems {
    @Id
    @Column(name = "orderItemId")
    private String orderItemId;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Orders orders;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "itemId")
    private Items items;

    @Column(name = "itemCount")
    private long itemCount;

    public void setItemCount(long itemCount) {
        this.itemCount = itemCount;
    }

    public Items getItems() {
        return items;
    }

    public void setItems(Items items) {
        this.items = items;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    public String getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(String orderItemId) {
        this.orderItemId = orderItemId;
    }

    public long getItemCount() {
        return itemCount;
    }

    public OrderItems(){}

    public OrderItems(String orderItemId, Items items, long itemCount){
        this.orderItemId = orderItemId;
        this.items = items;
        this.itemCount = itemCount;
    }
}
