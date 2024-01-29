package com.doitnow.doitnow.mappers;

import com.doitnow.doitnow.dto.EventoDto;
import com.doitnow.doitnow.entities.Evento;
import lombok.Data;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

/*
* @Mapper: Indica que a classe é um mapper, assim o MapStruct irá gerar a implementação da interface;
* componentModel = "spring": Indica que a classe será um bean gerenciado pelo Spring;
* */
@Mapper(componentModel = "spring")
public interface EventoMapper {
    public Evento toEvento(EventoDto eventoDto);
    public EventoDto toEventoDto(Evento evento);
}