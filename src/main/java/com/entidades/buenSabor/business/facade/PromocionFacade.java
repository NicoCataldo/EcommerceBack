package com.entidades.buenSabor.business.facade;

import com.entidades.buenSabor.business.facade.Base.BaseFacade;
import com.entidades.buenSabor.domain.dto.Promocion.PromocionDto;
import com.entidades.buenSabor.domain.dto.PromocionDetalle.PromocionDetalleDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface PromocionFacade extends BaseFacade<PromocionDto, Long> {


    public List<PromocionDetalleDto> findPromocionWithDetalles(Long promocionId);

    public List<PromocionDto> getAllActiveNow();

    public List<PromocionDto> getHabilitadas();

    //Imagenes
    // Método para obtener todas las imágenes almacenadas
    ResponseEntity<List<Map<String, Object>>> getAllImagesByPromocionId(Long id);
}
