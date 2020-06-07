package guru.springframework.api.services;

import guru.springframework.api.domain.Category;

import java.util.List;

public interface CategoryService {

    public List<Category> getAllCategories();
}
