package org.example.service;

import org.example.dao.ProductDAO;
import org.example.models.Product;

import java.util.List;
import java.util.Map;

public class ProductService {

    private ProductDAO productDAO = new ProductDAO();

    public List<Product> getProduct(){
        return productDAO.getProduct();
    }

    public void addProduct(String name, String description, float price, int quantity, int categoryId){
        productDAO.addProduct(name, description, price, quantity, categoryId);
    }

    public List<Product> getProductByNameOrCategory(String name, int categoryId){
        return productDAO.getProductByNameOrCategory(name, categoryId);
    }

    public void updateProduct(float price, int quantity, String description, int prodId){
        productDAO.updateProduct(price, quantity, description, prodId);
    }

    public void deleteProduct(int prodId){
        productDAO.deleteProduct(prodId);
    }

    public List<Map<String,Object>> getProductsByCategory(String categoryName) {
        return productDAO.getProductsByCategory(categoryName);
    }

    public List<Map<String,Object>> getTopSellingProducts() {
        return productDAO.getTopSellingProducts();
    }
}
