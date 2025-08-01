package com.blusoft.blog.Repositories;


import com.blusoft.blog.Entities.Postagem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostagemRepository extends JpaRepository<Postagem, Integer> {
}