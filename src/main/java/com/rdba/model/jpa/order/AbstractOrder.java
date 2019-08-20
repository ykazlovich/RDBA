package com.rdba.model.jpa.order;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AbstractOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "order_id")
    private Long id;

    public AbstractOrder() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
