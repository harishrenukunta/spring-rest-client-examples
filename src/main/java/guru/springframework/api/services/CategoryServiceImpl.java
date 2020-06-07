package guru.springframework.api.services;

import guru.springframework.api.domain.Category;
import guru.springframework.api.domain.CategoryResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private static String ROOT_URL = "https://api.predic8.de:443/shop";
    private final RestTemplate restTemplate;

    public CategoryServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<Category> getAllCategories() {
        final String categoryURI = UriComponentsBuilder.fromUriString(ROOT_URL).path("/categories/").build().toUriString();
        final CategoryResponse categoryServiceResponse = restTemplate.getForObject(categoryURI, CategoryResponse.class);
        return categoryServiceResponse.getCategories();
    }
}
