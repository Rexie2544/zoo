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

    @Column(name = "typeID",length = 50)
    private String typeID;

    @Column(name = "nameType",length = 60)
    private String nameType;

    @Column(name = "exStatus",length = 60)
    private String exStatus;

    @Column(name = "reserStatus",length = 100)
    private String reserStatus;

    public void fill(AnimalType animaltypes) {
        this.typeID = animaltypes.getTypeID();
        this.nameType = animaltypes.getNameType();
        this.exStatus = animaltypes.getExStatus();
        this.reserStatus = animaltypes.getReserStatus();
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

    public String getExStatus() {
        return exStatus;
    }

    public void setExStatus(String exStatus) {
        this.exStatus = exStatus;
    }

    public String getReserStatus() {
        return reserStatus;
    }

    public void setReserStatus(String reserStatus) {
        this.reserStatus = reserStatus;
    }
}
