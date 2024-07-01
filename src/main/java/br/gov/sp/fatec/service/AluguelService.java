package br.gov.sp.fatec.service;

import br.gov.sp.fatec.domain.request.AluguelRequest;
import br.gov.sp.fatec.domain.request.AluguelUpdateRequest;
import br.gov.sp.fatec.domain.response.AluguelResponse;
import java.util.List;

public interface AluguelService {

    AluguelResponse save(AluguelRequest aluguelRequest);

    AluguelResponse findById(Long id);

    List<AluguelResponse> findAll();

    boolean updateById(Long id, AluguelUpdateRequest aluguelUpdateRequest);

    boolean deleteById(Long id);
}
