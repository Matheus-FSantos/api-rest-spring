package io.github.matheusfsantos.Repository;

import io.github.matheusfsantos.Entity.Post;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer>{
}