package com.eduardosm.libraryApi.repository;

import com.eduardosm.libraryApi.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AutorRepository extends JpaRepository<Autor, UUID> {
}
