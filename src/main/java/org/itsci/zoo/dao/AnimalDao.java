package org.itsci.zoo.dao;

import org.itsci.zoo.model.Animal;
import org.itsci.zoo.model.Tram;
import java.util.List;

public interface AnimalDao{

    List<Animal> getAnimals();

    void saveAnimal(Animal animal);

    Animal getAnimal(int id);
    void deleteAnimal(int id);

    List<Tram> getTramDoesNotHaveAnimal(int id);

    List<Animal> getAnimalDoesNotHaveTram(int id);
}
