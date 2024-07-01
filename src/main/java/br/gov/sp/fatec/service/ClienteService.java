package br.gov.sp.fatec.service;

import br.gov.sp.fatec.domain.request.ClienteRequest;
import br.gov.sp.fatec.domain.request.ClienteUpdateRequest;
import br.gov.sp.fatec.domain.response.ClienteResponse;
import java.util.List;

public interface ClienteService {
    ClienteResponse save(ClienteRequest clienteRequest);

    ClienteResponse findById(Long id);

    List<ClienteResponse> findAll();

    boolean updateById(Long id, ClienteUpdateRequest clienteUpdateRequest);

    boolean deleteById(Long id);
}
