package org.itsci.zoo.service;

import org.itsci.zoo.dao.AnimalTypeDao;
import org.itsci.zoo.dao.AnimalDao;
import org.itsci.zoo.dao.TramDao;
import org.itsci.zoo.model.AnimalType;
import org.itsci.zoo.model.Animal;
import org.itsci.zoo.model.Tram;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class TramServiceImpl implements TramService{
    @Autowired
    private TramDao tramDao;

    @Autowired
    private AnimalDao animalDao;
    @Autowired
    private AnimalTypeDao animalTypeDao;

    @Override
    @Transactional
    public List<Tram> getTrams() {
        return tramDao.getTram();
    }

    @Override
    @Transactional
    public void saveTram(Tram tram) {
        tramDao.saveTram(tram);
    }

    @Override
    @Transactional
    public Tram getTram(int TramId) {
        return tramDao.getTram(TramId);
    }

    @Override
    @Transactional
    public void deleteTram(int TramId) {
        tramDao.deleteTram(TramId);
    }

    @Override
    @Transactional
    public void updateTram(Tram tramEntity, Tram tram) {
        tramEntity.fill(tram);
        tramDao.saveTram(tramEntity);
    }


    @Override
    @Transactional
    public List<Animal> getAnimalDoesNotHaveTram(int id) {
        return tramDao.getAnimalDoesNotHaveTram(id);
    }

    @Override
    @Transactional
    public void addAnimalToTram(int tramId , int animalId) {
        Tram tram = tramDao.getTram(tramId);
        Animal animal = animalDao.getAnimal(animalId);
        animal.getTrams().add(tram);
        animalDao.saveAnimal(animal);
    }

    @Override
    @Transactional
    public void removeAnimalFromTram(int tramId, int animalId) {
        Tram tram = tramDao.getTram(tramId);
        Animal animal = animalDao.getAnimal(animalId);
        animal.getTrams().remove(tram);
        animalDao.saveAnimal(animal);
    }
}
