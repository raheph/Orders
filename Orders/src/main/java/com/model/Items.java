package com.model;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Currency;

/**
 * Created by ephrar1 on 8/16/2017.
 */
@Entity
@Table(name = "Items")
public class Items {
    @Id
    @Column(name = "itemId")

    private String itemId;

    @Column(name = "itemName")
    private String itemName;

    @Column(name = "itemCost")
    private BigDecimal itemCost;

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public BigDecimal getItemCost() {
        return itemCost;
    }

    public void setItemCost(BigDecimal itemCost) {
        this.itemCost = itemCost;
    }

    public Items(){}

    public Items(String itemId, String itemName, BigDecimal itemCost){
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemCost = itemCost;
    }
}
