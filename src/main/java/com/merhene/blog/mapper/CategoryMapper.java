package com.merhene.blog.mapper;

import com.merhene.blog.dto.CategoryDTO;
import com.merhene.blog.model.Category;
import com.merhene.blog.repository.CategoryRepository;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {

    public CategoryDTO convertToDTO(Category category) {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(category.getId());
        categoryDTO.setName(category.getName());
        return categoryDTO;
    }

    public Category convertToEntity(CategoryDTO categoryDTO) {
        Category category = new Category();
        category.setId(categoryDTO.getId());
        category.setName(categoryDTO.getName());
        return category;
    }
}
