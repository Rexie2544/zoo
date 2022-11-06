package org.itsci.zoo.service;

import org.itsci.zoo.model.AnimalType;

import java.util.List;

public interface AnimalTypeService {

    List<AnimalType> getAnimalTypes();

    void saveAnimalType(AnimalType animal);

    AnimalType getAnimalType(int id);

    void deleteAnimalType(int id);

    AnimalType getAnimalTypeByCode(String code);

    void updateAnimalType(AnimalType dbAnimalType, AnimalType animalType);
}
