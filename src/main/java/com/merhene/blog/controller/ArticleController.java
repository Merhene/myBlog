package com.merhene.blog.controller;

import com.merhene.blog.dto.ArticleDTO;
import com.merhene.blog.exception.ResourceNotFoundException;
import com.merhene.blog.service.ArticleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/articles")
public class ArticleController {

    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping
    public ResponseEntity<List<ArticleDTO>> getAllArticles() {
        List<ArticleDTO> articles = articleService.getAllArticles();
        if (articles.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(articles);
    }

    @GetMapping("/Articles/{id}")
    public ResponseEntity<ArticleDTO> getArticleById(@PathVariable Long id) {
        ArticleDTO articleDTO = articleService.getArticleById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Article with id : " + id + "isn't found"));
        return ResponseEntity.ok(articleDTO);
    }

    @PostMapping
    public ResponseEntity<ArticleDTO> createArticle(@RequestBody ArticleDTO articleDTO) {
        ArticleDTO savedArticleDTO = articleService.createArticle(articleDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedArticleDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ArticleDTO> updateArticle(@PathVariable Long id, @RequestBody ArticleDTO articleDTO) {
        Optional<ArticleDTO> updatedArticleDTO = articleService.updateArticle(id, articleDTO);
        if (!updatedArticleDTO.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedArticleDTO.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable Long id) {
        if (articleService.deleteArticle(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}