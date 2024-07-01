package br.gov.sp.fatec.domain.response;

import br.gov.sp.fatec.domain.enums.CarroStatus;

public record CarroResponse(String modelo, String marca, int ano, CarroStatus status) {}
