package org.itsci.zoo.service;

//import org.itsci.shop.dao.CategoryDao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.itsci.shop.dao.CategoryDao;
import org.itsci.shop.dao.ProductDao;
import org.itsci.shop.dao.ShopDao;
import org.itsci.shop.model.Category;
import org.itsci.shop.model.Product;
import org.itsci.shop.model.Shop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;
    @Autowired
    private ShopDao shopDao;
    @Autowired
    private CategoryDao categoryDao;

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    @Transactional
    public List<Product> getProducts() {
        return productDao.getProducts();
    }

    @Override
    @Transactional
    public void saveProduct(Product product) {
        Category category =
                categoryDao.getCategoryByCode(product.getCategory().getCode());
        product.setCategory(category);
        productDao.saveProduct(product);
    }

    @Override
    @Transactional
    public Product getProduct(int productId) {
        return productDao.getProduct(productId);
    }

    @Override
    @Transactional
    public void deleteProduct(int productId) {
        productDao.deleteProduct(productId);
    }

    @Override
    @Transactional
    public void updateProduct(Product productEntity, Product product) {
        productEntity.fill(product);
        saveProduct(productEntity);
    }

    @Override
    @Transactional
    public List<Shop> getShopDoesNotHaveProduct(int id) {
        return productDao.getShopDoesNotHaveProduct(id);
    }

    @Override
    @Transactional
    public void addShopToProduct(int productId, int shopId) {
        Shop shop = shopDao.getShop(shopId);
        Product product = productDao.getProduct(productId);
        product.getShops().add(shop);
        productDao.saveProduct(product);
    }

    @Override
    @Transactional
    public void removeShopFromProduct(int productId, int shopId) {
        Shop shop = shopDao.getShop(shopId);
        Product product = productDao.getProduct(productId);
        product.getShops().remove(shop);
        productDao.saveProduct(product);
    }

        @Override
        public List<Product> getProductDoesNotHaveShop(int id) {
            Session session = sessionFactory.getCurrentSession();
            Query<Product> query =
                    session.createQuery("select s.products from Shop s where s.id=:id");
            query.setParameter("id", id);
            List<Product> products1 = query.getResultList();
            query = session.createQuery("from Product");
            List<Product> products2 = query.getResultList();
            products2.removeAll(products1);
            return products2;
        }


    }


