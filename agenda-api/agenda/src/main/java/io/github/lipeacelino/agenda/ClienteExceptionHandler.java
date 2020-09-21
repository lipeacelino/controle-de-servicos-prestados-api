package io.github.lipeacelino.agenda;

import io.github.lipeacelino.agenda.exception.ClienteNotFoundDetails;
import io.github.lipeacelino.agenda.exception.ClienteNotFoundException;
import io.github.lipeacelino.agenda.exception.ValidacaoErroDetails;
import io.github.lipeacelino.agenda.exception.ValidacaoErroException;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ClienteExceptionHandler {

    @ExceptionHandler(ClienteNotFoundException.class)
    public ResponseEntity clienteNaoEncontrado(ClienteNotFoundException ex) {
        ClienteNotFoundDetails clienteNF = ClienteNotFoundDetails.builder()
                .timestamp(this.getDataFormatada())
                .status(HttpStatus.NOT_FOUND.value())
                .error(HttpStatus.NOT_FOUND.name())
                .message(ex.getMessage()).build();

        return new ResponseEntity(clienteNF, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity handleValidacaoDeCampos(MethodArgumentNotValidException ex) {
        //pegando mensagens de erros da validação dos campos da entidade Cliente
        List<String> mensagensDeErroDeValidacao = ex.getBindingResult()
                            .getAllErrors()
                            .stream()
                            .map(objectError -> objectError.getDefaultMessage())
                            .collect(Collectors.toList());

        ValidacaoErroDetails ved = ValidacaoErroDetails.builder()
                .timestamp(this.getDataFormatada())
                .status(HttpStatus.NOT_FOUND.value())
                .error(HttpStatus.NOT_FOUND.name())
                .messageList(mensagensDeErroDeValidacao).build();
        return new ResponseEntity(ved, HttpStatus.BAD_REQUEST);
    }

    private String getDataFormatada() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy - kk:mm:ss");
        String date = sdf.format(new Date().getTime());
        return date;
    }
}
