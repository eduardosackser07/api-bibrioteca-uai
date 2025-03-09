package com.eduardosm.libraryApi.service;

import com.eduardosm.libraryApi.model.Autor;
import com.eduardosm.libraryApi.model.GeneroLivro;
import com.eduardosm.libraryApi.model.Livro;
import com.eduardosm.libraryApi.repository.AutorRepository;
import com.eduardosm.libraryApi.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
public class TransacaoService {

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private LivroRepository livroRepository;

    @Transactional
    public void executar(){
        //cria e salva o autor
        Autor autor = new Autor();
        autor.setNome("franciscao");
        autor.setNacionalidade("sim");
        autor.setData(LocalDate.of(1970, 7,31));


        //cria e salva o livro
        Livro livro = new Livro();

        livro.setTitulo("livro do franciscao");
        livro.setData_publicacao(LocalDate.of(1998, 9, 30));
        livro.setPreco(59.99);
        livro.setGenero(GeneroLivro.FANTASIA);
        livro.setIsbn("1234570");

        autorRepository.save(autor);

        livro.setAutor(autor);

        livroRepository.save(livro);

        if(autor.getNome().equals("franciscao")){
            throw new RuntimeException("rollback aha ne pai");
        }

    }
}
