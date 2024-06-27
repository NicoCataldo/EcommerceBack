package com.entidades.buenSabor.business.service.Imp;

import com.entidades.buenSabor.business.service.Base.BaseServiceImp;
import com.entidades.buenSabor.business.service.CloudinaryService;
import com.entidades.buenSabor.business.service.PromocionService;
import com.entidades.buenSabor.business.service.SucursalService;
import com.entidades.buenSabor.domain.entities.ImagenArticulo;
import com.entidades.buenSabor.domain.entities.Promocion;
import com.entidades.buenSabor.domain.entities.PromocionDetalle;
import com.entidades.buenSabor.repositories.ImagenArticuloRepository;
import com.entidades.buenSabor.repositories.PromocionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

@Service
public class PromocionServiceImp extends BaseServiceImp<Promocion, Long> implements PromocionService {

    private static final Logger logger = LoggerFactory.getLogger(PromocionServiceImp.class);

    @Autowired
    private PromocionRepository promocionRepository ;

    @Autowired
    SucursalService sucursalService;

    @Autowired
    CloudinaryService cloudinaryService;

    @Autowired
    ImagenArticuloRepository imagenArticuloRepository;


    // Método para obtener todas las imágenes almacenadas
    @Override
    //pedimos el id para retornar solo las imagenes de un articulo
    public ResponseEntity<List<Map<String, Object>>> getAllImagesByPromocionId(Long id) {
        try {
            // Consultar todas las imágenes desde la base de datos
            List<ImagenArticulo> images = baseRepository.getById(id).getImagenes().stream().toList();
            List<Map<String, Object>> imageList = new ArrayList<>();

            // Convertir cada imagen en un mapa de atributos para devolver como JSON
            for (ImagenArticulo image : images) {
                Map<String, Object> imageMap = new HashMap<>();
                imageMap.put("id", image.getId());
                imageMap.put("name", image.getName());
                imageMap.put("url", image.getUrl());
                imageList.add(imageMap);
            }

            // Devolver la lista de imágenes como ResponseEntity con estado OK (200)
            return ResponseEntity.ok(imageList);
        } catch (Exception e) {
            e.printStackTrace();
            // Devolver un error interno del servidor (500) si ocurre alguna excepción
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @Override
    public List<PromocionDetalle> getPromocionWithDetalles(Long promocionId) {
        return promocionRepository.getById(promocionId).getDetalles().stream().toList();
    }

    @Override
    public List<Promocion> getAllActiveNow() {
        //enviamos como parametros el dia actual y la hora actual para saber la lista de promociones activas en el momento
        return promocionRepository.findActivePromociones(LocalDate.now(), LocalTime.now());
    }

    @Override
    public List<Promocion> getAllHabilitados() {
        return promocionRepository.findByEliminadoFalseAndHabilitadoTrue();
    }


}
