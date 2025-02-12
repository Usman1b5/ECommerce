package org.example.service;

import org.example.dao.CategoryDAO;
import org.example.models.Category;

import java.util.List;

public class CategoryService {

    private CategoryDAO categoryDAO = new CategoryDAO();

    public List<Category> getCategory() {
        return categoryDAO.getCategory();
    }

    public void addCategory(String name, String description){
        categoryDAO.addCategory(name, description);
    }
}

