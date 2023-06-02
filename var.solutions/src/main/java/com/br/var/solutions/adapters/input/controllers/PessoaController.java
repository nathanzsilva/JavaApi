package com.br.var.solutions.adapters.input.controllers;

//import io.swagger.v3.oas.annotations.parameters.RequestBody;
import com.br.var.solutions.adapters.input.entities.PessoaRequest;
import com.br.var.solutions.application.entities.InformacoesIMC;
import com.br.var.solutions.application.entities.InformacoesIR;
import com.br.var.solutions.application.services.impl.MontarRespostaFrontUseCaseImpl;
import com.br.var.solutions.application.services.useCase.*;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/Pessoa")
@CrossOrigin(origins = "*")
@Slf4j
public class PessoaController {
    @Autowired
    MundialUseCase mundialUseCase;

    @Autowired
    ImcUseCase imcUseCase;

    @Autowired
    AnoNascimentoUseCase anoNascimentoUseCase;

    @Autowired
    ImpostoRendaUseCase impostoRendaUseCase;
    @Autowired
    SaldoEmDolarUseCase saldoEmDolarUseCase;

    @Autowired
    MontarRespostaFrontUseCaseImpl montarRespostaFrontEnd;

    @GetMapping
    public ResponseEntity<Object> get() {
        PessoaRequest pessoaRequest1 = new PessoaRequest();
        pessoaRequest1.setNome("Nathan");
        pessoaRequest1.setSobrenome("Silva");
        pessoaRequest1.setEndereco("Rua Alcides Caldeira, 29");
        pessoaRequest1.setIdade(16);

        return ResponseEntity.ok(pessoaRequest1);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/resumo")
    public ResponseEntity<Object> getPessoa(@RequestBody PessoaRequest pessoinha, @RequestParam(value = "valida_mundial") Boolean DesejaValidarMundial) {
        if (!pessoinha.getNome().isEmpty()) {
            InformacoesIMC imc = InformacoesIMC.builder().build();
            int AnoNascimento = 0;
            InformacoesIR ImpostoRenda = InformacoesIR.builder().build();
            String validaMundial = null;
            String saldoEmDolar = null;

            log.info("Iniciando processo de resumo da pessoa", pessoinha);

            if (Objects.nonNull(pessoinha.getPeso()) && Objects.nonNull(pessoinha.getAltura())) {
                log.info("Iniciando o calcula IMC");
                imc = imcUseCase.calculaImc(pessoinha.getPeso(), pessoinha.getAltura());
            }

            if (Objects.nonNull(pessoinha.getIdade())) {
                log.info("Iniciando o calcula ano de nascimento");
                AnoNascimento = anoNascimentoUseCase.calculaAnoNasc(pessoinha.getIdade());
            }

            if (Objects.nonNull(pessoinha.getSalario())) {
                log.info("Iniciando o calcula imposto de renda");
                ImpostoRenda = impostoRendaUseCase.calculaImpostoRend(pessoinha.getSalario());
            }

            if (Boolean.TRUE.equals(DesejaValidarMundial)) {
                if (Objects.nonNull(pessoinha.getTime())) {
                    log.info("Iniciando o valida Mundial");
                    validaMundial = mundialUseCase.calculaMundia(pessoinha.getTime());
                }
            }

            if (Objects.nonNull(pessoinha.getSaldo())) {
                log.info("Convertendo Real em dolar");
                saldoEmDolar = saldoEmDolarUseCase.calculaSaldoemDolar(pessoinha.getSaldo());
            }

            log.info("Montando o objeto de retorno para o FrontEnd");
            Object resumo = montarRespostaFrontEnd.montarRespostaFrontend(pessoinha, imc.getImc(), imc.getClassificacao(), AnoNascimento, ImpostoRenda.getSalarioLiquido(), ImpostoRenda.getAliquota(), validaMundial, saldoEmDolar);

            return ResponseEntity.ok(resumo);
        } else {
            return ResponseEntity.noContent().build();
        }
    }
}
