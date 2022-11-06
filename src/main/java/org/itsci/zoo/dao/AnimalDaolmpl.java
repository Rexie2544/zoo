package org.itsci.zoo.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.itsci.zoo.model.Animal;
import org.itsci.zoo.model.Tram;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class AnimalDaolmpl implements AnimalDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Animal> getAnimals() {
        Session session = sessionFactory.getCurrentSession();
        Query<Animal> query = session.createQuery("from Animal",Animal.class);
        List<Animal> animals = query.getResultList();
        return animals;
    }

    @Override
    public void saveAnimal(Animal animal) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(animal);
    }
    @Override
    public Animal getAnimal(int animalId) {
        Session session = sessionFactory.getCurrentSession();
        Animal animals = session.get(Animal.class, animalId);
        return animals;
    }
    @Override
    public void deleteAnimal(int animalId) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("delete from Animal where id=:animalId");
        query.setParameter("animalId", animalId);
        query.executeUpdate();
    }

    @Override
    public List<Tram> getTramDoesNotHaveAnimal(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query<Tram> query = session.createQuery("select d.trams from Animal d where d.id=:id");
        query.setParameter("id", id);
        List<Tram> animaltram = query.getResultList();
        query = session.createQuery("from Tram");
        List<Tram> alltrams = query.getResultList();
        alltrams.removeAll(animaltram);
        return alltrams;
    }

    @Override
    public List<Animal> getAnimalDoesNotHaveTram(int id) {
        return null;
    }

}
