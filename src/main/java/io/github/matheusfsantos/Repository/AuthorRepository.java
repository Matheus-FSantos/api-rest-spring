package io.github.matheusfsantos.Repository;

import io.github.matheusfsantos.Entity.Author;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer>{
}