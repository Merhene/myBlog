package com.merhene.blog.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.util.List;

public class CategoryDTO {
    @NotNull(message = "ID cannot be null")
    @Positive(message = "ID has to be positive number")
    private Long id;

    @NotBlank(message = "Name cannot be empty")
    private String name;

    private List<ArticleDTO> articles;

    // Getters et setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ArticleDTO> getArticles() {
        return articles;
    }

    public void setArticles(List<ArticleDTO> articles) {
        this.articles = articles;
    }
}

