package com.merhene.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.merhene.blog.model.Tag;

public interface TagRepository extends JpaRepository<Tag, Long> {
}