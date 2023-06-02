package com.br.var.solutions.application.services.impl;

import com.br.var.solutions.adapters.input.entities.PessoaRequest;
import com.br.var.solutions.adapters.input.entities.PessoaResponse;
import com.br.var.solutions.application.services.useCase.MontarRespostaFrontUseCase;
import org.springframework.stereotype.Service;

@Service
public class MontarRespostaFrontUseCaseImpl implements MontarRespostaFrontUseCase {
    public Object montarRespostaFrontend(PessoaRequest pessoa, String imc, String classificacao, int anoNascimento, String impostoRenda, String aliquota, String validaMundial, String saldoEmDolar){
        return montarRespostaFrontEnd(pessoa, imc, classificacao, anoNascimento,impostoRenda, aliquota, validaMundial, saldoEmDolar);
    }
    private Object montarRespostaFrontEnd(PessoaRequest pessoa, String imc, String classificacao, int anoNascimento, String impostoRenda, String aliquota, String validaMundial, String saldoEmDolar) {

        PessoaResponse response = new PessoaResponse();

        response.setNome(pessoa.nome);
        response.setIdade(anoNascimento);
        response.setImc(imc);
        response.setClassificacao(classificacao);
        response.setiR(impostoRenda);
        response.setAliquota(aliquota);
        response.setTime(validaMundial);
        response.setSaldoEmDolar(saldoEmDolar);
        response.setEndereco(pessoa.getEndereco());
        response.setPeso(pessoa.getPeso());
        response.setSalario(pessoa.getSalario());
        response.setAltura(pessoa.getAltura());

        return response;
    }
}
