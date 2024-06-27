package com.entidades.buenSabor.business.facade.Base;

import com.entidades.buenSabor.domain.dto.BaseDto;

import java.io.Serializable;
import java.util.List;

public interface BaseFacade <D extends BaseDto, ID extends Serializable>{
    public D getById(Long id);
    public List<D> getAll();

}
