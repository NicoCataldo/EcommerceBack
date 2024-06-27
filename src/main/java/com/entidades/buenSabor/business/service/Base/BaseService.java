package com.entidades.buenSabor.business.service.Base;

import com.entidades.buenSabor.domain.entities.Base;
import org.mapstruct.Named;

import java.io.Serializable;
import java.util.List;

public interface BaseService <E extends Base, ID extends Serializable>{
    public List<E> getAll();
    @Named("getById")// Esta notacion califica al metodo para luego se utilizado en clase mappper
    public E getById(ID id);
}
