package br.gov.sp.fatec.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue
    private Long id;

    private String nome;
    private String cpf;
    private String telefone;
}
