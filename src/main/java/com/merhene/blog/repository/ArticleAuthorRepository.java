package com.merhene.blog.repository;

import com.merhene.blog.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleAuthorRepository extends JpaRepository<Category, Long> {

}