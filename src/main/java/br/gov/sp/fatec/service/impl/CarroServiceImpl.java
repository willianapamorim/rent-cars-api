package br.gov.sp.fatec.service.impl;

import br.gov.sp.fatec.domain.entity.Carro;
import br.gov.sp.fatec.domain.mapper.CarroMapper;
import br.gov.sp.fatec.domain.request.CarroRequest;
import br.gov.sp.fatec.domain.request.CarroUpdateRequest;
import br.gov.sp.fatec.domain.response.CarroResponse;
import br.gov.sp.fatec.repository.CarroRepository;
import br.gov.sp.fatec.service.CarroService;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CarroServiceImpl implements CarroService {

    private final CarroRepository carroRepository;
    private final CarroMapper carroMapper;

    @Override
    @Transactional
    public CarroResponse save(CarroRequest carroRequest) {
        Carro carroEntity = carroMapper.toCarroEntity(carroRequest);
        Carro savedCarro = carroRepository.save(carroEntity);
        return carroMapper.toCarroResponse(savedCarro);
    }

    @Override
    @Transactional(readOnly = true)
    public CarroResponse findById(Long id) {
        return carroRepository.findById(id).map(carroMapper::toCarroResponse).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CarroResponse> findAll() {
        List<Carro> carros = carroRepository.findAll();
        return carros.stream().map(carroMapper::toCarroResponse).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public boolean updateById(Long id, CarroUpdateRequest carroUpdateRequest) {
        Carro carroToUpdate = carroRepository.findById(id).orElse(null);

        if (carroToUpdate != null) {
            carroMapper.updateCarroFromRequest(carroUpdateRequest, carroToUpdate);
            carroRepository.save(carroToUpdate);
            return true;
        }
        return false;
    }

    @Override
    @Transactional
    public boolean deleteById(Long id) {
        carroRepository.deleteById(id);
        return true;
    }
}
