package br.gov.sp.fatec.domain.mapper;

import br.gov.sp.fatec.domain.entity.Aluguel;
import br.gov.sp.fatec.domain.request.AluguelRequest;
import br.gov.sp.fatec.domain.request.AluguelUpdateRequest;
import br.gov.sp.fatec.domain.response.AluguelResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AluguelMapper {

    AluguelMapper INSTANCE = Mappers.getMapper(AluguelMapper.class);

    @Mapping(target = "id", ignore = true)
    Aluguel map(AluguelRequest source);

    AluguelResponse map(Aluguel source);

    void updateAluguelFromRequest(AluguelUpdateRequest aluguelUpdateRequest, @MappingTarget Aluguel aluguel);
}
