package com.rdba.model.jpa.item;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;


import javax.persistence.*;
import java.util.Objects;

@Table(name = "item", schema = "public")
@Entity
@NamedQueries({
        @NamedQuery(
                name = "Item.findByModelOrSerialNumber",
                query = "from Item where lower(serialno) like lower(:text) or lower(iname) like lower(:text)")
})
public class Item extends AbstractItem {

    public static final String FIND_BY_MODEL_OR_SN = "Item.findByModelOrSerialNumber";

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item)) return false;
        Item item = (Item) o;
        return Objects.equals(iname, item.iname) &&
                Objects.equals(serialNumber, item.serialNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(iname, serialNumber);
    }
}
