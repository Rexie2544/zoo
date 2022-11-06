package org.itsci.zoo.dao;

import org.itsci.zoo.model.AnimalType;

import java.util.List;

public interface AnimalTypeDao {

    List<AnimalType> getAnimalTypes();

    void saveAnimalType(AnimalType animalType);

    AnimalType getAnimalType(int id);

    void deleteAnimalType(int id);

    AnimalType getAnimalTypeByCode(String typeID);

}
