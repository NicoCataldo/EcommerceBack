package com.entidades.buenSabor.business.service;

import com.entidades.buenSabor.business.service.Base.BaseService;
import com.entidades.buenSabor.domain.entities.Promocion;
import com.entidades.buenSabor.domain.entities.PromocionDetalle;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;
import java.util.Set;


public interface PromocionService extends BaseService<Promocion, Long> {


    List<PromocionDetalle> getPromocionWithDetalles(Long promocionId);

    List<Promocion> getAllActiveNow();

    public List<Promocion> getAllHabilitados();

    //Imagenes
    // Método para obtener todas las imágenes almacenadas
    ResponseEntity<List<Map<String, Object>>> getAllImagesByPromocionId(Long id);
}
