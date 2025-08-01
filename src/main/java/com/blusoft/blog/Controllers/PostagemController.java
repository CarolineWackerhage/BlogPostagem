package com.blusoft.blog.Controllers;


import com.blusoft.blog.Entities.Postagem;
import com.blusoft.blog.Repositories.AutorRepository;
import com.blusoft.blog.Repositories.PostagemRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/postagens")
public class PostagemController {
    private final AutorRepository autorRepository;
    private final PostagemRepository postagemRepository;

    public PostagemController(AutorRepository autorRepository, PostagemRepository postagemRepository) {
        this.autorRepository = autorRepository;
        this.postagemRepository = postagemRepository;
    }

    @GetMapping
    public List<Postagem> listar() {
        return this.postagemRepository.findAll();
    }

    @GetMapping("/{idPostagem}")
    public Postagem buscarPostagem(@PathVariable Integer idPostagem) {
        return this.postagemRepository.findById(idPostagem).get();
    }

    @PostMapping("/{idAutor}")
    public Postagem criarPostagem(@PathVariable Integer idAutor,
                                  @RequestBody Postagem postagem) {

        postagem.setAutor(this.autorRepository.findById(idAutor).get());

        this.postagemRepository.save(postagem);
        return postagem;
    }

    @PutMapping("/{idAutor}/{idPostagem}")
    public Postagem editarPostagem(@PathVariable Integer idAutor,
                                   @PathVariable Integer idPostagem,
                                   @RequestBody Postagem postagem) {

        Postagem alterar = this.postagemRepository.findById(idPostagem).get();

        alterar.setAutor(this.autorRepository.findById(idAutor).get());
        alterar.setTitulo(postagem.getTitulo());
        alterar.setConteudo(postagem.getConteudo());

        this.postagemRepository.save(alterar);

        return alterar;
    }

    @DeleteMapping("/{idPostagem}")
    public Postagem removerPostagem(@PathVariable Integer idPostagem) {
        Postagem postagem = this.postagemRepository.findById(idPostagem).get();

        postagemRepository.delete(postagem);

        return postagem;
    }
}