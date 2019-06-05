package com.rdba.model.jpa.order;


import org.hibernate.annotations.CreationTimestamp;
import com.rdba.model.jpa.client.Client;
import com.rdba.model.jpa.item.Item;


import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@NamedQueries({
        @NamedQuery(
                name = "Order.getAll",
                query = "Select o from Order o left join fetch o.item e left join fetch o.client e"
        )})

@Entity
@Table(name = "order", schema = "public")
public class Order extends AbstractOrder implements Serializable {
    public static final String getAllOrder = "Order.getAll";

    @Column(name = "date")
    @CreationTimestamp
    private LocalDateTime date;


    @JoinColumn(name = "client_id")
    @ManyToOne(targetEntity = Client.class, fetch = FetchType.EAGER)
    private Client client;

    @JoinColumn(name = "item_id")
    @ManyToOne(targetEntity = Item.class, fetch = FetchType.EAGER)
    private Item item;

    @Column(name = "description")
    private String description;


    public Order() {
    }

    public Order(Integer id, String description, Item item) {
        this.description = description;
        this.item = item;
        super.setId(id);
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {

        this.description = description;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Order ID: ").append(getId()).append(".")
                .append(" Description: ").append(description).append(".");
        return stringBuilder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        Order order = (Order) o;
        return Objects.equals(date, order.date) &&
                Objects.equals(client, order.client) &&
                Objects.equals(item, order.item) &&
                Objects.equals(description, order.description);
    }

    public boolean isNew(){
        return this.getId() == null;
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, client, item, description);
    }
}
