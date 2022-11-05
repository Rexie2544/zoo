package org.itsci.zoo.service;

import org.itsci.shop.model.Product;
import org.itsci.shop.model.Shop;

import java.util.List;

public interface ShopService {
    List<Shop> getShops();
    public void saveShop(Shop shop);
    Shop getShop(int shopId);
    void deleteShop(int shopId);
    void updateShop(Shop shopEntity, Shop shop);

    List<Product> getProductDoesNotHaveShop(int id);
}
