package com.merhene.blog.service;

import com.merhene.blog.dto.ArticleDTO;
import com.merhene.blog.mapper.ArticleMapper;
import com.merhene.blog.model.Article;
import com.merhene.blog.repository.ArticleRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ArticleService {

    private final ArticleRepository articleRepository;
    private final ArticleMapper articleMapper;

    public ArticleService(ArticleRepository articleRepository, ArticleMapper articleMapper) {
        this.articleRepository = articleRepository;
        this.articleMapper = articleMapper;
    }

    public List<ArticleDTO> getAllArticles() {
        List<Article> articles = articleRepository.findAll();
        return articles.stream().map(articleMapper::convertToDTO).collect(Collectors.toList());
    }

    public Optional<ArticleDTO> getArticleById(Long id) {
        Optional<Article> optionalArticle = articleRepository.findById(id);
        if (!optionalArticle.isPresent()) {
            return Optional.empty();
        }
        return Optional.of(articleMapper.convertToDTO(optionalArticle.get()));
    }

    public ArticleDTO createArticle(ArticleDTO articleDTO) {
        Article article = articleMapper.convertToEntity(articleDTO);
        article.setCreatedAt(LocalDateTime.now());
        article.setUpdatedAt(LocalDateTime.now());

        Article savedArticle = articleRepository.save(article);
        return articleMapper.convertToDTO(savedArticle);
    }

    public Optional<ArticleDTO> updateArticle(Long id, ArticleDTO articleDTO) {
        Optional<Article> optionalArticle = articleRepository.findById(id);
        if (!optionalArticle.isPresent()) {
            return Optional.empty();
        }
        Article article = optionalArticle.get();
        article.setTitle(articleDTO.getTitle());
        article.setContent(articleDTO.getContent());
        article.setUpdatedAt(LocalDateTime.now());

        if (articleDTO.getCategoryId() != null) {
            articleMapper.convertToEntity(articleDTO).getCategory();
        }

        Article updatedArticle = articleRepository.save(article);
        return Optional.of(articleMapper.convertToDTO(updatedArticle));
    }

    public boolean deleteArticle(Long id) {
        Optional<Article> optionalArticle = articleRepository.findById(id);
        if (!optionalArticle.isPresent()) {
            return false;
        }
        articleRepository.delete(optionalArticle.get());
        return true;
    }
}
