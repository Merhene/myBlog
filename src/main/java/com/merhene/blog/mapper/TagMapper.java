package com.merhene.blog.mapper;

import com.merhene.blog.dto.TagDTO;
import com.merhene.blog.model.Article;
import com.merhene.blog.model.Tag;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TagMapper {

    public TagDTO convertToDTO(Tag tag) {
        TagDTO tagDTO = new TagDTO();
        tagDTO.setId(tag.getId());
        tagDTO.setName(tag.getName());
        tagDTO.setArticleIds(tag.getArticles().stream()
                .map(Article::getId)
                .collect(Collectors.toList()));
        return tagDTO;
    }

    public Tag convertToEntity(TagDTO tagDTO, List<Article> articles) {
        Tag tag = new Tag();
        tag.setId(tagDTO.getId());
        tag.setName(tagDTO.getName());
        tag.setArticles(articles);
        return tag;
    }
}
