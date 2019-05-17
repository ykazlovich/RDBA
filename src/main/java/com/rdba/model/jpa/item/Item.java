package com.rdba.model.jpa.item;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "item", schema = "public")
@Entity
public class Item extends AbstractItem {

    @Column(name = "iname")
    private String iname;

    @JsonProperty(value = "serialnumber")
    @Column(name = "serialno")
    private String serialNumber;

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getIname() {
        return iname;
    }

    public void setIname(String iname) {
        this.iname = iname;
    }

    public Item() {
    }

    public Item(String iname, String serialNumber) {
        this.iname = iname;
        this.serialNumber = serialNumber;
    }
}
