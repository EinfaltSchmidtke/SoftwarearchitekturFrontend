package de.hsw.shop.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="T_ORDER_ITEM")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @JoinColumn(name="ORDER_ID", nullable=false)
    @ManyToOne
    private Order order;

    @JoinColumn(name="PRODUCT_ID", nullable=false)
    @ManyToOne
    private Product product;

    @Column
    private int amount;

    @Column
    private double price;

    @Column
    private int vat;

    public OrderItem() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getVat() {
        return vat;
    }

    public void setVat(int vat) {
        this.vat = vat;
    }

    @Override
    public String toString() {
        return "OrderItem [amount=" + amount + ", id=" + id + ", order=" + order == null ? "" : order.getId() + ", price=" + price + ", product="
                + product == null ? "" : product.getId() + ", vat=" + vat + "]";
    }

    
}
