package br.gov.sp.fatec.domain.mapper;

import br.gov.sp.fatec.domain.entity.Carro;
import br.gov.sp.fatec.domain.request.CarroRequest;
import br.gov.sp.fatec.domain.request.CarroUpdateRequest;
import br.gov.sp.fatec.domain.response.CarroResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CarroMapper {

    CarroMapper INSTANCE = Mappers.getMapper(CarroMapper.class);

    @Mapping(target = "id", ignore = true) // Para ignorar o mapeamento do ID ao criar uma nova entidade
    Carro toCarroEntity(CarroRequest carroRequest);

    CarroResponse toCarroResponse(Carro carro);

    void updateCarroFromRequest(CarroUpdateRequest carroUpdateRequest, @MappingTarget Carro carro);
}
