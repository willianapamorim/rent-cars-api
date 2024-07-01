package br.gov.sp.fatec.service.impl;

import br.gov.sp.fatec.domain.entity.Cliente;
import br.gov.sp.fatec.domain.mapper.ClienteMapper;
import br.gov.sp.fatec.domain.request.ClienteRequest;
import br.gov.sp.fatec.domain.request.ClienteUpdateRequest;
import br.gov.sp.fatec.domain.response.ClienteResponse;
import br.gov.sp.fatec.repository.ClienteRepository;
import br.gov.sp.fatec.service.ClienteService;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;
    private final ClienteMapper clienteMapper;

    @Override
    @Transactional
    public ClienteResponse save(ClienteRequest clienteRequest) {
        Cliente clienteEntity = clienteMapper.toClienteEntity(clienteRequest);
        Cliente savedCliente = clienteRepository.save(clienteEntity);
        return clienteMapper.toClienteResponse(savedCliente);
    }

    @Override
    @Transactional(readOnly = true)
    public ClienteResponse findById(Long id) {
        return clienteRepository
                .findById(id)
                .map(clienteMapper::toClienteResponse)
                .orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ClienteResponse> findAll() {
        List<Cliente> clientes = clienteRepository.findAll();
        return clientes.stream().map(clienteMapper::toClienteResponse).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public boolean updateById(Long id, ClienteUpdateRequest clienteUpdateRequest) {
        Cliente clienteToUpdate = clienteRepository.findById(id).orElse(null);

        if (clienteToUpdate != null) {
            clienteMapper.updateClienteFromRequest(clienteUpdateRequest, clienteToUpdate);
            clienteRepository.save(clienteToUpdate);
            return true;
        }
        return false;
    }

    @Override
    @Transactional
    public boolean deleteById(Long id) {
        clienteRepository.deleteById(id);
        return false;
    }
}
