package com.Spring.GerenciadorDeContas.service;

import com.Spring.GerenciadorDeContas.model.ContasAPagar;
import com.Spring.GerenciadorDeContas.model.Status;
import com.Spring.GerenciadorDeContas.model.Tipo;
import com.Spring.GerenciadorDeContas.repository.ContasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import java.util.List;
import java.util.Optional;

@Service
public class ContasAPagarService {

    @Autowired
    private ContasRepository contasRepository;

    public List<ContasAPagar> buscarTodas() {
        return contasRepository.findAll ();
    }

    public Optional<ContasAPagar> buscarId(Long id) {
        return contasRepository.findById (id);
    }

    public ContasAPagar buscarStatusConta(ContasAPagar contaAPagarModel) {
        return contasRepository.save (contaAPagarModel);
    }

    public List<ContasAPagar> buscarPorTipo(Tipo tipo) {
        return contasRepository.findByTipo (tipo);
    }

    public ContasAPagar registrarConta(ContasAPagar contasAPagar) {

        if (contasAPagar.estaVencida ()) {
            contasAPagar.setStatus (Status.VENCIDA);
        } else {
            contasAPagar.setStatus (Status.AGUARDANDO);
        }
        return contasRepository.save (contasAPagar);
    }

    public ContasAPagar atualizar(ContasAPagar contasAPagarModel) {
        if (contasAPagarModel.getStatus().equals(Status.PAGO)) {
            LocalDateTime dataAtual = LocalDateTime.now ();
            contasAPagarModel.setDataDePagamento (dataAtual);
        }
        return contasRepository.save(contasAPagarModel);
    }

    public void deletar(Long id) {
        contasRepository.deleteById (id);
    }
}