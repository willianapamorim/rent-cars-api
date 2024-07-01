package br.gov.sp.fatec.domain.mapper;

import br.gov.sp.fatec.domain.entity.Cliente;
import br.gov.sp.fatec.domain.request.ClienteRequest;
import br.gov.sp.fatec.domain.request.ClienteUpdateRequest;
import br.gov.sp.fatec.domain.response.ClienteResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClienteMapper {

    ClienteMapper INSTANCE = Mappers.getMapper(ClienteMapper.class);

    @Mapping(target = "id", ignore = true)
    Cliente toClienteEntity(ClienteRequest clienteRequest);

    ClienteResponse toClienteResponse(Cliente cliente);

    void updateClienteFromRequest(ClienteUpdateRequest clienteUpdateRequest, @MappingTarget Cliente cliente);
}
