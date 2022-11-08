package org.itsci.zoo.model;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

@Entity
@Table(name = "trams")
public class Tram {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "increment", strategy = "increment")
    private int id;

    @NotNull
    @Pattern(regexp = "^T[0-9]{4}")
    @Column(name = "tramID", length = 5, nullable = false, unique = true)
    private String tramID;

    @NotNull
    @Column(name = "route",length = 60)
    private String route;

    @NotNull
    @Column(name = "timef",length = 10)
    private String timef;
    @NotNull
    @Column(name = "timel",length = 10)
    private String timel;

    @NotNull
    @Column(name = "parking",length = 2)
    private String parking;


    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "trams")
    private List<Animal> animals;

    public void fill(Tram trams) {
        this.tramID = trams.getTramID();
        this.route = trams.getRoute();
        this.timef = trams.getTimef();
        this.timel = trams.getTimel();
        this.parking = trams.getParking();
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTramID() {
        return tramID;
    }

    public void setTramID(String tramID) {
        this.tramID = tramID;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public String getTimef() {
        return timef;
    }

    public void setTimef(String timef) {
        this.timef = timef;
    }

    public String getTimel() {
        return timel;
    }

    public void setTimel(String timel) {
        this.timel = timel;
    }

    public String getParking() {
        return parking;
    }

    public void setParking(String parking) {
        this.parking = parking;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }
}
