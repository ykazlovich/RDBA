package com.rdba.model.jpa.item;

import javax.persistence.*;

@MappedSuperclass
public class AbstractItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "item_id")
    @Column(name = "id")
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
