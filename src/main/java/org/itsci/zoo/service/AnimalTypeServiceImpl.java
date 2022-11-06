package org.itsci.zoo.service;

import org.itsci.zoo.dao.AnimalTypeDao;
import org.itsci.zoo.model.AnimalType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AnimalTypeServiceImpl implements AnimalTypeService{
    @Autowired
    private AnimalTypeDao animalTypeDao;

    @Override
    @Transactional
    public void saveAnimalType(AnimalType animalType) {
        animalTypeDao.saveAnimalType(animalType);
    }

    @Override
    @Transactional
    public AnimalType getAnimalType(int id) {
        return animalTypeDao.getAnimalType(id);
    }

    @Override
    @Transactional
    public void deleteAnimalType(int id) {
        animalTypeDao.deleteAnimalType(id);
    }

    @Override
    @Transactional
    public AnimalType getAnimalTypeByCode(String code) {
        return animalTypeDao.getAnimalTypeByCode(code);
    }

    @Override
    @Transactional
    public void updateAnimalType(AnimalType dbAnimalType, AnimalType animalType) {
        AnimalType categoryEntity = animalTypeDao.getAnimalType(animalType.getId());
        categoryEntity.fill(animalType);
        saveAnimalType(categoryEntity);
    }

    @Override
    @Transactional
    public List<AnimalType> getAnimalTypes() {
        return animalTypeDao.getAnimalTypes();
    }
}
