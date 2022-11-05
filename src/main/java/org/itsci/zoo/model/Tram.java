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

    @Column(name = "timel",length = 10)
    private String timel;

    @Column(name = "parking",length = 2)
    private String parking;


    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "trams")
    private List<Animal> animals;
}
