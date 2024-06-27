package com.entidades.buenSabor.business.service.Imp;

import com.entidades.buenSabor.business.mapper.ImagenArticuloMapper;
import com.entidades.buenSabor.business.service.ArticuloInsumoService;
import com.entidades.buenSabor.business.service.Base.BaseServiceImp;
import com.entidades.buenSabor.business.service.CloudinaryService;
import com.entidades.buenSabor.domain.dto.Articulo.ArticuloDto;
import com.entidades.buenSabor.domain.dto.Articulo.CardArticulo;
import com.entidades.buenSabor.domain.entities.*;
import com.entidades.buenSabor.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

import java.util.*;

@Service
public class ArticuloInsumoServiceImp extends BaseServiceImp<ArticuloInsumo, Long> implements ArticuloInsumoService {

    @Autowired
    private ArticuloManufacturadoDetalleRepository articuloManufacturadoDetalleRepository;

    @Autowired
    private PromocionDetalleRepository promocionDetalleRepository;

    @Autowired
    ImagenArticuloRepository imagenArticuloRepository;

    @Autowired
    private CloudinaryService cloudinaryService; // Servicio para interactuar con Cloudinary

    @Autowired
    ArticuloInsumoRepository articuloInsumoRepository;

    @Autowired
    ArticuloManufacturadoRepository articuloManufacturadoRepository;

    @Autowired
    ImagenArticuloMapper imagenArticuloMapper;

    @Override
    public List<ArticuloInsumo> getAllHabilitados() {
        return articuloInsumoRepository.findByEliminadoFalseAndHabilitadoTrue();
    }

    // Método para obtener todas las imágenes almacenadas
    @Override
    //pedimos el id para retornar solo las imagenes de un articulo
    public ResponseEntity<List<Map<String, Object>>> getAllImagesByArticuloId(Long id) {
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
    public void decrementStock(Long articuloInsumoId, Integer cantidad) {
        ArticuloInsumo articuloInsumo = articuloInsumoRepository.findById(articuloInsumoId)
                .orElseThrow(() -> new RuntimeException("Artículo insumo no encontrado"));
        if (articuloInsumo.getStockActual() < cantidad) {
            throw new RuntimeException("Stock insuficiente para el artículo: " + articuloInsumo.getDenominacion());
        }
        articuloInsumo.setStockActual(articuloInsumo.getStockActual() - cantidad);
        articuloInsumoRepository.save(articuloInsumo);
    }

    @Override
    public List<ArticuloInsumo> findBySucursalId(Long sucursalId) {
        return articuloInsumoRepository.findBySucursalId(sucursalId);
    }
}


