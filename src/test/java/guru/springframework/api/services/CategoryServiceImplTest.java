package guru.springframework.api.services;

import guru.springframework.api.TestConfig.TestConfig;
import guru.springframework.api.domain.Category;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes={TestConfig.class})
class CategoryServiceImplTest {

    @Autowired
    private CategoryService categoryService;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getAllCategories() {
        final List<Category> categories = categoryService.getAllCategories();
        assertThat(categories)
                .as("Check categories are retrieved successfully")
                .isNotNull()
                .hasSizeGreaterThan(1);
    }
}