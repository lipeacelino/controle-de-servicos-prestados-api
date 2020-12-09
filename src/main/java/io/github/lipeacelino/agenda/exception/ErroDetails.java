package io.github.lipeacelino.agenda.exception;

import lombok.Builder;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public abstract class ErroDetails {
    private String timestamp;
    private int status;
    private String error;
}
