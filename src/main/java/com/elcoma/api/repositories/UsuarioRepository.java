package com.elcoma.api.repositories;

import com.elcoma.api.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

// Anotação usada para especificar que essa interface é um repository
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {


}
