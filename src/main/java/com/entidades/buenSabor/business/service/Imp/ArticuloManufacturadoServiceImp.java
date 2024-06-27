package com.entidades.buenSabor.business.service.Imp;

import com.entidades.buenSabor.business.service.ArticuloManufacturadoService;
import com.entidades.buenSabor.business.service.Base.BaseServiceImp;
import com.entidades.buenSabor.business.service.CloudinaryService;
import com.entidades.buenSabor.domain.entities.ArticuloManufacturado;
import com.entidades.buenSabor.domain.entities.ArticuloManufacturadoDetalle;
import com.entidades.buenSabor.domain.entities.ImagenArticulo;
import com.entidades.buenSabor.repositories.ArticuloManufacturadoRepository;
import com.entidades.buenSabor.repositories.ImagenArticuloRepository;
import com.entidades.buenSabor.repositories.PromocionDetalleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ArticuloManufacturadoServiceImp extends BaseServiceImp<ArticuloManufacturado, Long> implements ArticuloManufacturadoService{

    @Autowired
    ArticuloManufacturadoRepository articuloManufacturadoRepository;

    @Autowired
    ImagenArticuloRepository imagenArticuloRepository;

    @Autowired
    CloudinaryService cloudinaryService;

    @Autowired
    PromocionDetalleRepository promocionDetalleRepository;

    @Override
    public List<ArticuloManufacturadoDetalle> findAllDetalles(Long id) {
        return getById(id).getArticuloManufacturadoDetalles().stream().toList();
    }


    @Override
    public List<ArticuloManufacturado> getAllHabilitados() {
        return articuloManufacturadoRepository.findByEliminadoFalseAndHabilitadoTrue();
    }

    @Override
    public List<ArticuloManufacturado> findBySucursalId(Long sucursalId) {
        return articuloManufacturadoRepository.findBySucursalId(sucursalId);
    }
}
