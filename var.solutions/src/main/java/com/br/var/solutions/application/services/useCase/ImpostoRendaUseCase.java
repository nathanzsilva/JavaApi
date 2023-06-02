package com.br.var.solutions.application.services.useCase;

import com.br.var.solutions.application.entities.InformacoesIR;

public interface ImpostoRendaUseCase {
    InformacoesIR calculaImpostoRend(double salario);
}
