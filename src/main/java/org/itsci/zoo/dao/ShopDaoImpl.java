package org.itsci.zoo.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.itsci.shop.model.Product;
import org.itsci.shop.model.Shop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class ShopDaoImpl implements ShopDao{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Shop> getShop() {
        Session session = sessionFactory.getCurrentSession();
        Query<Shop> query = session.createQuery("from Shop",
                Shop.class);
        List<Shop> shops = query.getResultList();
        return shops;
    }

    @Override
    public void saveShop(Shop shop) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(shop);
    }
    @Override
    public Shop getShop(int shopId) {
        Session session = sessionFactory.getCurrentSession();
        Shop shop = session.get(Shop.class, shopId);
        return shop;
    }
    @Override
    public void deleteShop(int shopId) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("delete from Shop where id=:shopId");
        query.setParameter("shopId", shopId);
        query.executeUpdate();
    }

    @Override
    public List<Product> getProductDoesNotHaveShop(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query<Product> query = session.createQuery("select s.products from Shop s where s.id=:id");
        query.setParameter("id", id);
        List<Product> productshop = query.getResultList();
        query = session.createQuery("from Shop");
        List<Product> allshops = query.getResultList();
        allshops.removeAll(productshop);
        return allshops;
    }
}
