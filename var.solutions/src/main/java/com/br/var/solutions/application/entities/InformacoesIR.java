package com.br.var.solutions.application.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class InformacoesIR {
    private String SalarioLiquido;
    private String aliquota;
}
