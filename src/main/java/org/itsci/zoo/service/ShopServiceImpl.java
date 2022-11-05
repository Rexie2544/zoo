package org.itsci.zoo.service;

import org.itsci.shop.dao.ProductDao;
import org.itsci.shop.dao.ShopDao;
import org.itsci.shop.model.Product;
import org.itsci.shop.model.Shop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ShopServiceImpl implements ShopService{
    @Autowired
    private ShopDao shopDao;

    @Override
    @Transactional
    public List<Shop> getShops() {
        return shopDao.getShop();
    }

    @Override
    @Transactional
    public void saveShop(Shop shop) {
        shopDao.saveShop(shop);
    }
    @Override
    @Transactional
    public Shop getShop(int shopId) {
        return shopDao.getShop(shopId);
    }
    @Override
    @Transactional
    public void deleteShop(int shopId) {
        shopDao.deleteShop(shopId);
    }

    @Override
    @Transactional
    public void updateShop(Shop shopEntity, Shop shop) {
        shopEntity.fill(shop);
        shopDao.saveShop(shopEntity);
    }

    @Override
    @Transactional
    public List<Product> getProductDoesNotHaveShop(int id) {
        return shopDao.getProductDoesNotHaveShop(id);
    }
}
