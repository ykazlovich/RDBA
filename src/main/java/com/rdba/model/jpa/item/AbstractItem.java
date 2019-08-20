package com.rdba.model.jpa.item;

import javax.persistence.*;

@MappedSuperclass
public class AbstractItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "item_id")
    @Column(name = "id")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
