package com.merhene.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.merhene.blog.model.Article;

public interface ArticleRepository extends JpaRepository<Article, Long> {

}