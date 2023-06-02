package com.br.var.solutions.application.services.useCase;

import com.br.var.solutions.adapters.input.entities.PessoaRequest;

public interface MontarRespostaFrontUseCase {
    Object montarRespostaFrontend(PessoaRequest pessoa, String imc, String classificacao, int anoNascimento, String impostoRenda, String aliquota, String validaMundial, String saldoEmDolar);
}
