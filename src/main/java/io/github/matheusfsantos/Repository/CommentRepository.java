package io.github.matheusfsantos.Repository;

import io.github.matheusfsantos.Entity.Comment;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer>{
}