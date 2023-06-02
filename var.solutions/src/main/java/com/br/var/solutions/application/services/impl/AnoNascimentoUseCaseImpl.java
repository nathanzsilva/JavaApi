package com.br.var.solutions.application.services.impl;

import com.br.var.solutions.application.services.useCase.AnoNascimentoUseCase;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class AnoNascimentoUseCaseImpl implements AnoNascimentoUseCase {
    public int calculaAnoNasc(int idade){
        return calculaAnoNascimento(idade);
    }
    private int calculaAnoNascimento(int idade) {
        LocalDate DataLocal = LocalDate.now();
        return DataLocal.getYear() - idade;
    }
}
