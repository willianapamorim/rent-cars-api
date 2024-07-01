package br.gov.sp.fatec.service.impl;

import br.gov.sp.fatec.domain.entity.Aluguel;
import br.gov.sp.fatec.domain.mapper.AluguelMapper;
import br.gov.sp.fatec.domain.request.AluguelRequest;
import br.gov.sp.fatec.domain.request.AluguelUpdateRequest;
import br.gov.sp.fatec.domain.response.AluguelResponse;
import br.gov.sp.fatec.repository.AluguelRepository;
import br.gov.sp.fatec.service.AluguelService;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AluguelServiceImpl implements AluguelService {

    private final AluguelRepository aluguelRepository;
    private final AluguelMapper aluguelMapper;

    @Override
    public AluguelResponse save(AluguelRequest aluguelRequest) {
        Aluguel aluguelEntity = aluguelMapper.map(aluguelRequest);
        Aluguel savedAluguel = aluguelRepository.save(aluguelEntity);
        return aluguelMapper.map(savedAluguel);
    }

    @Override
    public AluguelResponse findById(Long id) {
        return aluguelRepository.findById(id).map(aluguelMapper::map).orElse(null);
    }

    @Override
    public List<AluguelResponse> findAll() {
        List<Aluguel> alugueis = aluguelRepository.findAll();
        return alugueis.stream().map(aluguelMapper::map).collect(Collectors.toList());
    }

    @Override
    public boolean updateById(Long id, AluguelUpdateRequest aluguelUpdateRequest) {
        Aluguel aluguelToUpdate = aluguelRepository.findById(id).orElse(null);

        if (aluguelToUpdate != null) {
            aluguelMapper.updateAluguelFromRequest(aluguelUpdateRequest, aluguelToUpdate);
            aluguelRepository.save(aluguelToUpdate);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteById(Long id) {
        aluguelRepository.deleteById(id);
        return false;
    }
}
