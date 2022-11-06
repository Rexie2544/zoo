package org.itsci.zoo.service;

import org.itsci.zoo.model.Animal;
import org.itsci.zoo.model.Tram;

import java.util.List;
public interface AnimalService {
    List<Animal> getAnimals();
    public void saveAnimal(Animal animal);
    Animal getAnimal(int animalId);
    void deleteAnimal(int animalId);

    void updateAnimal(Animal animalEntity, Animal animal);

    List<Tram> getTramDoesNotHaveAnimal(int id);

    void addTramToAnimal(int animalId, int tramId);

    void removeTramFromAnimal(int animalId, int tramId);

    List<Animal> getAnimalDoesNotHaveTram(int id);
}
