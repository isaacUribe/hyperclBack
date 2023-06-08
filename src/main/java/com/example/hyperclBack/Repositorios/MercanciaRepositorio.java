package com.example.hyperclBack.Repositorios;

import com.example.hyperclBack.entidades.Mercancia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MercanciaRepositorio extends JpaRepository<Mercancia, Long>{
}
