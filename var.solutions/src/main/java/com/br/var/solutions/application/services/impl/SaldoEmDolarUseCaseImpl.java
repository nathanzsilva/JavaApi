package com.br.var.solutions.application.services.impl;

import com.br.var.solutions.application.services.useCase.SaldoEmDolarUseCase;
import org.springframework.stereotype.Service;

@Service
public class SaldoEmDolarUseCaseImpl implements SaldoEmDolarUseCase {
    public String calculaSaldoemDolar(double saldo){
        return calculaSaldoEmDolar(saldo);
    }
    private String calculaSaldoEmDolar(double saldo) {
        return String.valueOf(saldo / 5.11);
    }
}
