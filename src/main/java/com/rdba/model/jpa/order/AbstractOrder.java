package com.rdba.model.jpa.order;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AbstractOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "order_id")
    private Integer id;

    public AbstractOrder() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
