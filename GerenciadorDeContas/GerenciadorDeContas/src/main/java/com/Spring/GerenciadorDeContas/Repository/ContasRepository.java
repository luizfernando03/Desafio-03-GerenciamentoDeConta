package com.Spring.GerenciadorDeContas.repository;

import com.Spring.GerenciadorDeContas.model.ContasAPagar;
import com.Spring.GerenciadorDeContas.model.Status;
import com.Spring.GerenciadorDeContas.model.Tipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ContasRepository extends JpaRepository<ContasAPagar, Long> {
    List<ContasAPagar> findByStatus(Status status);
    List<ContasAPagar> findByTipo(Tipo tipo);

}
