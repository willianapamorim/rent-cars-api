package br.gov.sp.fatec.controller.impl;

import br.gov.sp.fatec.controller.CarroController;
import br.gov.sp.fatec.domain.request.CarroRequest;
import br.gov.sp.fatec.domain.request.CarroUpdateRequest;
import br.gov.sp.fatec.domain.response.CarroResponse;
import br.gov.sp.fatec.service.CarroService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CarroControllerImpl implements CarroController {

    private final CarroService carroService;

    @Override
    public ResponseEntity<CarroResponse> save(CarroRequest carro) {
        CarroResponse savedCarro = carroService.save(carro);
        return ResponseEntity.status(201).body(savedCarro);
    }

    @Override
    public ResponseEntity<CarroResponse> findById(Long id) {
        CarroResponse carro = carroService.findById(id);
        if (carro != null) {
            return ResponseEntity.ok(carro);
        } else {
            return ResponseEntity.status(404).body(null);
        }
    }

    @Override
    public ResponseEntity<List<CarroResponse>> findAll() {
        List<CarroResponse> carros = carroService.findAll();
        return ResponseEntity.ok(carros);
    }

    @Override
    public ResponseEntity<Void> updateById(Long id, CarroUpdateRequest request) {
        boolean updated = carroService.updateById(id, request);
        if (updated) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(404).build();
        }
    }

    @Override
    public ResponseEntity<Void> deleteById(Long id) {
        boolean deleted = carroService.deleteById(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(404).build();
        }
    }
}
