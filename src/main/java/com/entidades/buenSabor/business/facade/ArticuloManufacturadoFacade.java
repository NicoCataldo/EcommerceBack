package com.entidades.buenSabor.business.facade;

import com.entidades.buenSabor.business.facade.Base.BaseFacade;
import com.entidades.buenSabor.domain.dto.ArticuloManufacturado.ArticuloManufacturadoDto;
import com.entidades.buenSabor.domain.dto.ArticuloManufacturadoDetalle.ArticuloManufacturadoDetalleDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

public interface ArticuloManufacturadoFacade extends BaseFacade<ArticuloManufacturadoDto,  Long> {
    List<ArticuloManufacturadoDetalleDto> findAllDetalles(Long id);
    public List<ArticuloManufacturadoDto> getAllHabilitado();
    List<ArticuloManufacturadoDto> findBySucursalId(Long sucursalId);
}
