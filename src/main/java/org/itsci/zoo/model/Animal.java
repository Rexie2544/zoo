package org.itsci.zoo.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

@Entity
@Table(name = "animals")
public class Animal {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @GenericGenerator(name = "increment", strategy = "increment")
    int id;

    @NotNull
    @Pattern(regexp="^A[0-9]{4}")
    @Column(length = 5, nullable = false, unique = true)
    @NotNull
    private String animalID;

    @NotNull
    @Column(length = 60)
    private String nameTH;

    @NotNull
    @Column(length = 60)
    private String nameEN;

    @NotNull
    @Column(length = 100)
    private String nameSC;

    @NotNull
    @Column(columnDefinition="TEXT")
    private String details;

    @NotNull
    @Column(length = 200)
    private String residence;

    @NotNull
    @Column(length = 100)
    private String food;


    @ManyToOne
    @JoinColumn(name = "typeID")
    private AnimalType animalType;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinTable(name = "animals_tram",
            joinColumns = { @JoinColumn(name = "animals_id") },
            inverseJoinColumns = { @JoinColumn(name = "trams_id") })
    private List<Tram> trams;

    public void fill(Animal animals) {
        this.animalID = animals.getAnimalID();
        this.nameTH = animals.getNameTH();
        this.nameEN = animals.getNameEN();
        this.nameSC = animals.getNameSC();
        this.details = animals.getDetails();
        this.residence = animals.getResidence();
        this.food = animals.getFood();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAnimalID() {
        return animalID;
    }

    public void setAnimalID(String animalID) {
        this.animalID = animalID;
    }

    public String getNameTH() {
        return nameTH;
    }

    public void setNameTH(String nameTH) {
        this.nameTH = nameTH;
    }

    public String getNameEN() {
        return nameEN;
    }

    public void setNameEN(String nameEN) {
        this.nameEN = nameEN;
    }

    public String getNameSC() {
        return nameSC;
    }

    public void setNameSC(String nameSC) {
        this.nameSC = nameSC;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getResidence() {
        return residence;
    }

    public void setResidence(String residence) {
        this.residence = residence;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public AnimalType getAnimalType() {
        return animalType;
    }

    public void setAnimalType(AnimalType animalType) {
        this.animalType = animalType;
    }

    public List<Tram> getTrams() {
        return trams;
    }

    public void setTrams(List<Tram> trams) {
        this.trams = trams;
    }
}

