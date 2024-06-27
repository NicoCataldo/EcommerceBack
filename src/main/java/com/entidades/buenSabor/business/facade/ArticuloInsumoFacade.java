package com.entidades.buenSabor.business.facade;

import com.entidades.buenSabor.business.facade.Base.BaseFacade;
import com.entidades.buenSabor.domain.dto.Insumo.ArticuloInsumoDto;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface ArticuloInsumoFacade extends BaseFacade<ArticuloInsumoDto, Long> {
    public List<ArticuloInsumoDto> getAllHabilitados();

    //Imagenes
    // Método para obtener todas las imágenes almacenadas
    ResponseEntity<List<Map<String, Object>>> getAllImagesByArticuloId(Long id);

    List<ArticuloInsumoDto> findBySucursalId(Long sucursalId);
}
