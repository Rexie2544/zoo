package org.itsci.zoo.model;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
@Entity
@Table(name="animaltypes")
public class AnimalType {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @GenericGenerator(name = "increment", strategy = "increment")
    int id;

    @Column(name = "typeID",length = 5)
    private String typeID;

    @Column(name = "nameType",length = 60)
    private String nameType;

    @Column(name = "qty",length = 3)
    private int qty;

    public void fill(AnimalType animaltypes) {
        this.typeID = animaltypes.getTypeID();
        this.nameType = animaltypes.getNameType();
        this.qty = animaltypes.getQty();
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypeID() {
        return typeID;
    }

    public void setTypeID(String typeID) {
        this.typeID = typeID;
    }

    public String getNameType() {
        return nameType;
    }

    public void setNameType(String nameType) {
        this.nameType = nameType;
    }

    public int getQty() {
        return qty;
    }
    public void setQty(int qty) {
        this.qty = qty;
    }
}
