package br.gov.sp.fatec.controller.impl;

import br.gov.sp.fatec.controller.AluguelController;
import br.gov.sp.fatec.domain.request.AluguelRequest;
import br.gov.sp.fatec.domain.request.AluguelUpdateRequest;
import br.gov.sp.fatec.domain.response.AluguelResponse;
import br.gov.sp.fatec.service.AluguelService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AluguelControllerImpl implements AluguelController {

    private final AluguelService aluguelService;

    @Override
    public ResponseEntity<AluguelResponse> save(AluguelRequest aluguel) {
        AluguelResponse savedAluguel = aluguelService.save(aluguel);
        return ResponseEntity.status(201).body(savedAluguel);
    }

    @Override
    public ResponseEntity<AluguelResponse> findById(Long id) {
        AluguelResponse aluguel = aluguelService.findById(id);
        if (aluguel != null) {
            return ResponseEntity.ok(aluguel);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<List<AluguelResponse>> findAll() {
        List<AluguelResponse> alugueis = aluguelService.findAll();
        return ResponseEntity.ok(alugueis);
    }

    @Override
    public ResponseEntity<Void> updateById(Long id, AluguelUpdateRequest request) {
        boolean updated = aluguelService.updateById(id, request);
        if (updated) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<Void> deleteById(Long id) {
        boolean deleted = aluguelService.deleteById(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
