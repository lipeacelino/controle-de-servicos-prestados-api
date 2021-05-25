package io.github.lipeacelino.agenda.domain.entities;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ServicoPrestado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 255)
    @NotBlank @Length(min = 1, max = 50, message = "A descrição deve conter entre 1 e 50 caracteres")
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    @NotNull
    private Cliente cliente;
    
    @NotNull
    private BigDecimal valor;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @NotNull
    private LocalDate data;

}
