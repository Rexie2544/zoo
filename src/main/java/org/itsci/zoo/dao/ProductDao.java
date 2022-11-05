package org.itsci.zoo.dao;

import org.itsci.shop.model.Product;
import org.itsci.shop.model.Shop;

import java.util.List;

public interface ProductDao {
   List<Product> getProducts();
   void saveProduct(Product product);
   Product getProduct(int id);
   void deleteProduct(int id);
   List<Shop> getShopDoesNotHaveProduct(int id);

   List<Product> getProductDoesNotHaveShop(int id);
}
