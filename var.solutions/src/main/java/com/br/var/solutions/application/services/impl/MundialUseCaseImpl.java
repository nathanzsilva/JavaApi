package com.br.var.solutions.application.services.impl;

import org.springframework.stereotype.Service;
import com.br.var.solutions.application.services.useCase.MundialUseCase;

@Service
public class MundialUseCaseImpl implements MundialUseCase {

    public String calculaMundia (String time){
        return calculaMundial(time);
    }

    private String calculaMundial(String time) {
        if (time.equalsIgnoreCase("Corinthians")) {
            return "Parabens, o seu time possui 2 mundiais de clubes conforme a FIFA";
        } else if (time.equalsIgnoreCase("São Paulo")) {
            return "Parabens, o seu time possui 3 mundiais de clubes conforme a FIFA";
        } else if (time.equalsIgnoreCase("Santos")) {
            return "Parabens, o seu time possui 2 mundiais de clubes conforme a FIFA";
        } else {
            return "Poxa, que pena. Continue torcendo para seu Clube ganhar um Mundial";
        }
    }
}
