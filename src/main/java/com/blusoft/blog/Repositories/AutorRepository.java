package com.blusoft.blog.Repositories;


import com.blusoft.blog.Entities.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, Integer> {
}