package com.blusoft.blog.Controllers;


import com.blusoft.blog.Entities.Autor;
import com.blusoft.blog.Repositories.AutorRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autores")
public class AutorController {
    private final AutorRepository autorRepository;

    public AutorController(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    @GetMapping
    public List<Autor> listar(){
        return this.autorRepository.findAll();
    }

    @GetMapping("/{idAutor}")
    public Autor buscarAutor(@PathVariable Integer idAutor){
        return this.autorRepository.findById(idAutor).get();
    }

    @PostMapping
    public Autor criarAutor(@RequestBody Autor autor) {
        this.autorRepository.save(autor);
        return autor;
    }

    @PutMapping("/{idAutor}")
    public Autor alterarAutor(
            @PathVariable Integer idAutor,
            @RequestBody Autor autor
    ) {
        Autor alterar = this.autorRepository.findById(idAutor).get();

        alterar.setNome(autor.getNome());
        alterar.setEmail(autor.getEmail());
        alterar.setDataNascimento(autor.getDataNascimento());

        this.autorRepository.save(alterar);

        return alterar;
    }

    @DeleteMapping("/{idAutor}")
    public Autor removerAutor(@PathVariable Integer idAutor) {
        Autor autor = this.autorRepository.findById(idAutor).get();

        this.autorRepository.deleteById(idAutor);

        return autor;
    }
}