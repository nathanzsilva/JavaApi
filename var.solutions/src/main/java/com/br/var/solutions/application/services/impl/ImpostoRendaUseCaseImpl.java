package com.br.var.solutions.application.services.impl;

import com.br.var.solutions.application.entities.InformacoesIR;
import com.br.var.solutions.application.services.useCase.ImpostoRendaUseCase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ImpostoRendaUseCaseImpl implements ImpostoRendaUseCase {

    public InformacoesIR calculaImpostoRend(double salario){
        return calculaImpostoRenda(salario);
    }
    private InformacoesIR calculaImpostoRenda(double salario) {
        log.info("Iniciando cálculo de imposto de renda: " + salario);
        InformacoesIR informacoesIR = InformacoesIR.builder().build();
        informacoesIR.setSalarioLiquido(String.valueOf(salario));

        if (salario < 1903.98) {
            informacoesIR.setAliquota("isento");
        } else if (salario > 1903.98 && salario < 2826.65) {
            double calculoIRF = 142.86 - ((salario * 0.075) / 100);
            double novoSalario = salario - calculoIRF;
            informacoesIR.setAliquota(String.valueOf(calculoIRF));
            informacoesIR.setSalarioLiquido(String.valueOf(novoSalario));
        } else if (salario > 2826.65 && salario < 3751.05) {
            double calculoIRF = 354.80 - ((salario * 0.15) / 100);
            double novoSalario = salario - calculoIRF;
            informacoesIR.setAliquota(String.valueOf(calculoIRF));
            informacoesIR.setSalarioLiquido(String.valueOf(novoSalario));
        } else if (salario > 3751.05 && salario < 4664.68) {
            double calculoIRF = 636.13 - ((salario * 0.225) / 100);
            double novoSalario = salario - calculoIRF;
            informacoesIR.setAliquota(String.valueOf(calculoIRF));
            informacoesIR.setSalarioLiquido(String.valueOf(novoSalario));
        } else {
            double calculoIRF = 869.36 - ((salario * 0.275) / 100);
            double novoSalario = salario - calculoIRF;
            informacoesIR.setAliquota(String.valueOf(calculoIRF));
            informacoesIR.setSalarioLiquido(String.valueOf(novoSalario));
        }
        return informacoesIR;
    }
}
