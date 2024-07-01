package br.gov.sp.fatec.domain.request;

import br.gov.sp.fatec.domain.enums.CarroStatus;

public record CarroRequest(Long id, String modelo, String marca, int ano, CarroStatus status) {}
