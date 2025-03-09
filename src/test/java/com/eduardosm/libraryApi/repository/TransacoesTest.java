package com.eduardosm.libraryApi.repository;

import com.eduardosm.libraryApi.service.TransacaoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class TransacoesTest {

    @Autowired
    AutorRepository autorRepository;

    @Autowired
    TransacaoService transacaoService;

    @Test
    void transacaoSimples(){
        transacaoService.executar();
    }

}
