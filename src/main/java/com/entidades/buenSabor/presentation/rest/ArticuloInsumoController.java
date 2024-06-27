package com.entidades.buenSabor.presentation.rest;

import com.entidades.buenSabor.business.facade.Imp.ArticuloInsumoFacadeImp;
import com.entidades.buenSabor.domain.dto.Insumo.ArticuloInsumoDto;
import com.entidades.buenSabor.domain.entities.ArticuloInsumo;
import com.entidades.buenSabor.presentation.rest.Base.BaseControllerImp;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin("*")
@RequestMapping("/ArticuloInsumo")
public class ArticuloInsumoController  extends BaseControllerImp<ArticuloInsumo, ArticuloInsumoDto, Long, ArticuloInsumoFacadeImp> {
    public ArticuloInsumoController(ArticuloInsumoFacadeImp facade) {
        super(facade);
    }


    @GetMapping("/bySucursalId/{idSucursal}")
    public ResponseEntity<?>getAllById(@PathVariable Long idSucursal) {
        return ResponseEntity.ok(facade.findBySucursalId(idSucursal));
    }

    @GetMapping("/getHabilitados")
    public ResponseEntity<?> getHabilitados(){
        return ResponseEntity.ok(facade.getAllHabilitados());
    }


    // Método GET para obtener todas las imágenes almacenadas
    @GetMapping("/getImagesByArticuloId/{id}")
    public ResponseEntity<?> getAll(@PathVariable Long id) {
        try {
            return facade.getAllImagesByArticuloId(id); // Llama al método del servicio para obtener todas las imágenes
        } catch (Exception e) {
            e.printStackTrace();
            return null; // Manejo básico de errores, se puede mejorar para devolver una respuesta más específica
        }
    }
}
