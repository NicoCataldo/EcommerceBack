package com.entidades.buenSabor.business.service.Base;


import com.entidades.buenSabor.domain.entities.Base;
import com.entidades.buenSabor.repositories.BaseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.Serializable;
import java.util.List;

@Service
public abstract class BaseServiceImp<E extends Base,ID extends Serializable> implements BaseService<E, ID> {

    private static final Logger logger = LoggerFactory.getLogger(BaseServiceImp.class);

    @Autowired
    protected BaseRepository<E,ID> baseRepository;

    @Override
    public E getById(ID id){
        var entity = baseRepository.getById(id);
        logger.info("Obtenida entidad {}",entity);
        return entity;
    }

    @Override
    public List<E> getAll(){
        var entities = baseRepository.getAll();
        logger.info("Obtenidas entidades {}",entities);
        return entities;
    }

}
