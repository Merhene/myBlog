package com.merhene.blog.dto;

import jakarta.validation.constraints.*;

import java.time.LocalDateTime;
import java.util.List;

public class ArticleDTO {
    @NotNull(message = "ID cannot be null")
    @Positive(message = "ID has to be positive number")
    private Long id;

    @NotBlank(message = "Title cannot be empty")
    @Size(min = 2, max = 50, message = "Title must contain between 2 and 50 characters")
    private String title;

    @NotBlank(message = "Content cannot be empty")
    @Size(min = 10, message = "content must contain at least 10 characters")
    private String content;

    @NotNull(message = "Creation date cannot be null")
    @PastOrPresent(message = "Creation date cannot be in the futur")
    private LocalDateTime createdAt;

    @PastOrPresent(message = "Update date cannot be in the futur")
    private LocalDateTime updatedAt;

    @NotNull(message = "ID cannot be null")
    @Positive(message = "ID has to be positive number")
    private Long categoryId;

    private List<Long> tagIds;
    private List<ArticleAuthorDTO> authors;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public List<Long> getTagIds() {
        return tagIds;
    }

    public void setTagIds(List<Long> tagIds) {
        this.tagIds = tagIds;
    }
}
