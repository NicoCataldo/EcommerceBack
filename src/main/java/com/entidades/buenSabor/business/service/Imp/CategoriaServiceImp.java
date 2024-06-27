package com.entidades.buenSabor.business.service.Imp;

import com.entidades.buenSabor.business.service.Base.BaseServiceImp;
import com.entidades.buenSabor.business.service.CategoriaService;
import com.entidades.buenSabor.business.service.SucursalService;
import com.entidades.buenSabor.domain.entities.Categoria;
import com.entidades.buenSabor.domain.entities.Sucursal;
import com.entidades.buenSabor.repositories.ArticuloRepository;
import com.entidades.buenSabor.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class CategoriaServiceImp extends BaseServiceImp<Categoria, Long> implements CategoriaService {

    @Autowired
    ArticuloRepository articuloRepository;

    @Autowired
    SucursalService sucursalService;

    @Autowired
    CategoriaRepository categoriaRepository;

    @Override
    public List<Categoria> listCategoriaInsumos() {
        return categoriaRepository.findByEsInsumoTrue();
    }

    @Override
    public List<Categoria> listCategoriaArticulos() {
        return categoriaRepository.findByEsInsumoFalse();
    }


}
