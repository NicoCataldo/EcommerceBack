package com.entidades.buenSabor.business.mapper;

import com.entidades.buenSabor.domain.dto.BaseDto;
import com.entidades.buenSabor.domain.entities.Base;
import org.mapstruct.MappingTarget;

import java.util.List;

public interface BaseMapper<E extends Base,D extends BaseDto>{
    public D toDTO(E source);
    public List<D> toDTOsList(List<E> source);
}
