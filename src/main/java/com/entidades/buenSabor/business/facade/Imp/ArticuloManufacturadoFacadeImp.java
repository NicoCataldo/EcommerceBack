package com.entidades.buenSabor.business.facade.Imp;

import com.entidades.buenSabor.business.facade.ArticuloManufacturadoFacade;
import com.entidades.buenSabor.business.facade.Base.BaseFacadeImp;
import com.entidades.buenSabor.business.mapper.ArticuloManufacturadoDetalleMapper;
import com.entidades.buenSabor.business.mapper.BaseMapper;
import com.entidades.buenSabor.business.service.ArticuloManufacturadoService;
import com.entidades.buenSabor.business.service.Base.BaseService;
import com.entidades.buenSabor.domain.dto.ArticuloManufacturado.ArticuloManufacturadoDto;
import com.entidades.buenSabor.domain.dto.ArticuloManufacturadoDetalle.ArticuloManufacturadoDetalleDto;
import com.entidades.buenSabor.domain.entities.ArticuloManufacturado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@Service
public class ArticuloManufacturadoFacadeImp extends BaseFacadeImp<ArticuloManufacturado, ArticuloManufacturadoDto, Long> implements ArticuloManufacturadoFacade {


    @Autowired
    ArticuloManufacturadoService articuloManufacturadoService;

    @Autowired
    ArticuloManufacturadoDetalleMapper articuloManufacturadoDetalleMapper;

    public ArticuloManufacturadoFacadeImp(BaseService<ArticuloManufacturado, Long> baseService, BaseMapper<ArticuloManufacturado, ArticuloManufacturadoDto> baseMapper) {
        super(baseService, baseMapper);
    }

    @Override
    public List<ArticuloManufacturadoDetalleDto> findAllDetalles(Long id) {
        return articuloManufacturadoDetalleMapper.toDTOsList(articuloManufacturadoService.findAllDetalles(id));
    }


    @Override
    public List<ArticuloManufacturadoDto> getAllHabilitado() {
        return baseMapper.toDTOsList(articuloManufacturadoService.getAllHabilitados());
    }


    @Override
    public List<ArticuloManufacturadoDto> findBySucursalId(Long sucursalId) {
        return baseMapper.toDTOsList(articuloManufacturadoService.findBySucursalId(sucursalId));
    }
}
