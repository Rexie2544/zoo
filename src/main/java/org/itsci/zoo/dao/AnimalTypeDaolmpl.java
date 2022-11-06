package org.itsci.zoo.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.itsci.zoo.model.AnimalType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AnimalTypeDaolmpl implements AnimalTypeDao{
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<AnimalType> getAnimalTypes() {
        Session session = sessionFactory.getCurrentSession();
        Query<AnimalType> query = session.createQuery("from AnimalType", AnimalType.class);
        List<AnimalType> animalTypes = query.getResultList();
        return animalTypes;
    }

    @Override
    public void saveAnimalType(AnimalType animalType) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(animalType);
    }

    @Override
    public AnimalType getAnimalType(int id) {
        Session session = sessionFactory.getCurrentSession();
        AnimalType animalType = session.get(AnimalType.class, id);
        return animalType;
    }

    @Override
    public void deleteAnimalType(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("delete from AnimalType where id=:id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Override
    public AnimalType getAnimalTypeByCode(String typeID) {
        Session session = sessionFactory.getCurrentSession();
        Query<AnimalType> query = session.createQuery("from AnimalType where typeID=:typeID", AnimalType.class);
        query.setParameter("typeID", typeID);
        AnimalType animalType = query.getSingleResult();
        return animalType;
    }

}
