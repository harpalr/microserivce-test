package com.tenx.ms.retail.order;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@Entity
public class Orders implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="order_id")
    private int order_id;

    private int store_id;
    private int customer_id;
    private String status;

    @NotNull
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name="order_id")
    private List<OrderDetails> order_detail = new ArrayList<OrderDetails>();

    public Orders() {
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getStore_id() {
        return store_id;
    }

    public void setStore_id(int store_id) {
        this.store_id = store_id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<OrderDetails> getOrder_detail() {
        return order_detail;
    }

    public void setOrder_detail(List<OrderDetails> orderDetails) {
        this.order_detail = orderDetails;
    }

    public void addOrder_detail(OrderDetails orderDetails){
        this.order_detail.add(orderDetails);
    }

}
