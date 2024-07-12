package com.merhene.blog.mapper;

import com.merhene.blog.dto.ArticleAuthorDTO;
import com.merhene.blog.dto.AuthorDTO;
import com.merhene.blog.model.Author;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class AuthorMapper {

    public AuthorDTO convertToDTO(Author author) {
        AuthorDTO authorDTO = new AuthorDTO();
        authorDTO.setId(author.getId());
        authorDTO.setFirstname(author.getFirstname());
        authorDTO.setLastname(author.getLastname());
        authorDTO.setArticleAuthors(author.getArticleAuthors().stream()
                .map(articleAuthor -> {
                    ArticleAuthorDTO articleAuthorDTO = new ArticleAuthorDTO();
                    articleAuthorDTO.setArticleId(articleAuthor.getArticle().getId());
                    articleAuthorDTO.setAuthorId(articleAuthor.getAuthor().getId());
                    articleAuthorDTO.setContribution(articleAuthor.getContribution());
                    return articleAuthorDTO;
                }).collect(Collectors.toList()));
        return authorDTO;
    }

    public Author convertToEntity(AuthorDTO authorDTO) {
        Author author = new Author();
        author.setId(authorDTO.getId());
        author.setFirstname(authorDTO.getFirstname());
        author.setLastname(authorDTO.getLastname());
        return author;
    }
}
