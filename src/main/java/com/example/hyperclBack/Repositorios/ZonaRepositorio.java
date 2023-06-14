package com.example.hyperclBack.Repositorios;

import com.example.hyperclBack.entidades.Zona;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZonaRepositorio extends JpaRepository<Zona, Integer> {
}
