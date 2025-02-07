package com.eduardosm.libraryApi.repository;

import com.eduardosm.libraryApi.model.Autor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.eduardosm.libraryApi.repository.AutorRepository;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

@SpringBootTest
public class AutorRepositoryTest {

    @Autowired
    AutorRepository repository;

    @Test
    public void salvarTest(){
        Autor autor = new Autor();
        autor.setNome("josefa");
        autor.setNacionalidade("russa");
        autor.setData(LocalDate.of(1959, 1,31));

        var autorSalvo = repository.save(autor);
        System.out.println("autor salvo: "+autorSalvo);
    }

    @Test
    public void atualizarTest(){
        var id = UUID.fromString("6de7c2cc-eb50-4459-9427-571fc7dc5368");

        Optional<Autor> possivelAutor = repository.findById(id);

        if (possivelAutor.isPresent()) {
            Autor autorEncontrado = possivelAutor.get();

            System.out.println("Dados do autor: ");
            System.out.println(autorEncontrado);

            autorEncontrado.setNacionalidade("mexicano");

            repository.save(autorEncontrado);
        }
    }
}
