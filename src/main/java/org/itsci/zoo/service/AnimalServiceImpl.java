package org.itsci.zoo.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
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
public class AnimalServiceImpl implements AnimalService{

    @Autowired
    private AnimalDao animalDao;
    @Autowired
    private TramDao tramDao;
    @Autowired
    private AnimalTypeDao animalTypeDao;

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    @Transactional
    public List<Animal> getAnimals() {
        return animalDao.getAnimals();
    }

    @Override
    @Transactional
    public void saveAnimal(Animal animal) {
        AnimalType animalType =
                animalTypeDao.getAnimalTypeByCode(animal.getAnimalType().getTypeID());
        animal.setAnimalType(animalType);
        animalDao.saveAnimal(animal);
    }

    @Override
    @Transactional
    public Animal getAnimal(int animalId) {
        return animalDao.getAnimal(animalId);
    }

    @Override
    @Transactional
    public void deleteAnimal(int animalId) {
        animalDao.deleteAnimal(animalId);
    }

    @Override
    @Transactional
    public void updateAnimal(Animal animalEntity, Animal animal) {
        animalEntity.fill(animal);
        saveAnimal(animalEntity);
    }

    @Override
    @Transactional
    public List<Tram> getTramDoesNotHaveAnimal(int id) {
        return animalDao.getTramDoesNotHaveAnimal(id);
    }

    @Override
    @Transactional
    public void addTramToAnimal(int animalId, int tramId) {
        Tram tram = tramDao.getTram(tramId);
        Animal animal = animalDao.getAnimal(animalId);
        animal.getTrams().add(tram);
        animalDao.saveAnimal(animal);
    }

    @Override
    @Transactional
    public void removeTramFromAnimal(int animalId, int tramId) {
        Tram tram = tramDao.getTram(tramId);
        Animal animal = animalDao.getAnimal(animalId);
        animal.getTrams().remove(tram);
        animalDao.saveAnimal(animal);
    }

    @Override
    public List<Animal> getAnimalDoesNotHaveTram(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query<Animal> query =
                session.createQuery("select t.animals from Tram t where t.id=:id");
        query.setParameter("id", id);
        List<Animal> animals1 = query.getResultList();
        query = session.createQuery("from Animal");
        List<Animal> animals2 = query.getResultList();
        animals2.removeAll(animals1);
        return animals2;
    }
}
