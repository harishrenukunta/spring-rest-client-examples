package guru.springframework.api.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Category {
    private String name;
    @JsonProperty("category_url")
    private String categoryUrl;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategoryUrl() {
        return categoryUrl;
    }

    public void setCategoryUrl(String categoryUrl) {
        this.categoryUrl = categoryUrl;
    }
}
