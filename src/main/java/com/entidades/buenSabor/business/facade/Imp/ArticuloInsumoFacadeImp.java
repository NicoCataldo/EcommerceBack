package com.entidades.buenSabor.business.facade.Imp;

import com.entidades.buenSabor.business.facade.ArticuloInsumoFacade;
import com.entidades.buenSabor.business.facade.Base.BaseFacadeImp;
import com.entidades.buenSabor.business.mapper.BaseMapper;
import com.entidades.buenSabor.business.service.ArticuloInsumoService;
import com.entidades.buenSabor.business.service.Base.BaseService;
import com.entidades.buenSabor.domain.dto.Insumo.ArticuloInsumoDto;
import com.entidades.buenSabor.domain.entities.ArticuloInsumo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@Service
public class ArticuloInsumoFacadeImp extends BaseFacadeImp<ArticuloInsumo, ArticuloInsumoDto, Long> implements ArticuloInsumoFacade {

    @Autowired
    ArticuloInsumoService articuloInsumoService;

    public ArticuloInsumoFacadeImp(BaseService<ArticuloInsumo, Long> baseService, BaseMapper<ArticuloInsumo, ArticuloInsumoDto> baseMapper) {
        super(baseService, baseMapper);
    }

    @Override
    public List<ArticuloInsumoDto> getAllHabilitados() {
        return baseMapper.toDTOsList(articuloInsumoService.getAllHabilitados());
    }

    @Override
    public ResponseEntity<List<Map<String, Object>>> getAllImagesByArticuloId(Long id) {
        return articuloInsumoService.getAllImagesByArticuloId(id);
    }

    @Override
    public List<ArticuloInsumoDto> findBySucursalId(Long sucursalId) {
        return baseMapper.toDTOsList(articuloInsumoService.findBySucursalId(sucursalId));
    }
}
