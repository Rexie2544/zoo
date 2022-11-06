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
public class TramDaolmal implements TramDao{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Tram> getTram() {
        Session session = sessionFactory.getCurrentSession();
        Query<Tram> query = session.createQuery("from Tram", Tram.class);
        List<Tram> trams = query.getResultList();
        return trams;
    }

    @Override
    public void saveTram(Tram trams) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(trams);
    }
    @Override
    public Tram getTram(int tramID) {
        Session session = sessionFactory.getCurrentSession();
        Tram tram = session.get(Tram.class, tramID);
        return tram;
    }
    @Override
    public void deleteTram(int tramID) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("delete from Tram where id=:tramID");
        query.setParameter("tramID", tramID);
        query.executeUpdate();
    }

    @Override
    public List<Animal> getAnimalDoesNotHaveTram(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query<Animal> query = session.createQuery("select s.animals from Tram s where s.id=:id");
        query.setParameter("id", id);
        List<Animal> animaltram = query.getResultList();
        query = session.createQuery("from Animal");
        List<Animal> allanimals = query.getResultList();
        allanimals.removeAll(animaltram);
        return allanimals;
    }
}
