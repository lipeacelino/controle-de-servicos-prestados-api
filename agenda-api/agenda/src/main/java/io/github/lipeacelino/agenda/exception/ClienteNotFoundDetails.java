package io.github.lipeacelino.agenda.exception;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class ClienteNotFoundDetails extends ErroDetails{
    private String message;
}
