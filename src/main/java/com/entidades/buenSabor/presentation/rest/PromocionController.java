package com.entidades.buenSabor.presentation.rest;

import com.entidades.buenSabor.business.facade.Imp.PromocionFacadeImp;
import com.entidades.buenSabor.domain.dto.Promocion.PromocionDto;
import com.entidades.buenSabor.domain.entities.Promocion;
import com.entidades.buenSabor.presentation.rest.Base.BaseControllerImp;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Set;

@CrossOrigin("*")
@RequestMapping("/promocion")
@RestController
public class PromocionController extends BaseControllerImp<Promocion, PromocionDto, Long, PromocionFacadeImp> {
    public PromocionController(PromocionFacadeImp facade) {
        super(facade);
    }


    @GetMapping("/getAllActiveNow")
    public ResponseEntity<?> getAllActiveNow(){
        return ResponseEntity.ok(facade.getAllActiveNow());
    }

    @GetMapping("/getHabilitadas")
    public ResponseEntity<?> getHabilitados(){
        return ResponseEntity.ok(facade.getHabilitadas());
    }


    // Método GET para obtener todas las imágenes almacenadas
    @GetMapping("/getImagesByArticuloId/{id}")
    public ResponseEntity<?> getAll(@PathVariable Long id) {
        try {
            return facade.getAllImagesByPromocionId(id); // Llama al método del servicio para obtener todas las imágenes
        } catch (Exception e) {
            e.printStackTrace();
            return null; // Manejo básico de errores, se puede mejorar para devolver una respuesta más específica
        }
    }


    @GetMapping("/getDetallesByid/{id}")
    public ResponseEntity<?> getAllDetalles(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(facade.findPromocionWithDetalles(id)); // Llama al método del servicio para obtener todas las imágenes
        } catch (Exception e) {
            e.printStackTrace();
            return null; // Manejo básico de errores, se puede mejorar para devolver una respuesta más específica
        }
    }
}
