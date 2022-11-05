package org.itsci.zoo.dao;


import org.itsci.shop.model.Product;
import org.itsci.shop.model.Shop;

import java.util.List;

public interface ShopDao {
    List<Shop> getShop();
    void saveShop(Shop shops);
    Shop getShop(int id);
    void deleteShop(int id);
    List<Product> getProductDoesNotHaveShop(int id);
}
