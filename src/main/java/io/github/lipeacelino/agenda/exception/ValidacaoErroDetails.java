package io.github.lipeacelino.agenda.exception;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@SuperBuilder
public class ValidacaoErroDetails extends ErroDetails{
    private List<String> messageList;
}
