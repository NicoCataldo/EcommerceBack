package com.entidades.buenSabor.presentation.rest;

import com.entidades.buenSabor.business.facade.Imp.ArticuloManufacturadoFacadeImp;
import com.entidades.buenSabor.domain.dto.ArticuloManufacturado.ArticuloManufacturadoDto;
import com.entidades.buenSabor.domain.entities.ArticuloManufacturado;
import com.entidades.buenSabor.presentation.rest.Base.BaseControllerImp;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin("*")
@RequestMapping("/ArticuloManufacturado")
public class ArticuloManufacturadoController extends BaseControllerImp<ArticuloManufacturado, ArticuloManufacturadoDto, Long, ArticuloManufacturadoFacadeImp> {
    public ArticuloManufacturadoController(ArticuloManufacturadoFacadeImp facade) {
        super(facade);
    }

    @GetMapping("/allDetalles/{id}")
    public ResponseEntity<?> findAllDetalle(@PathVariable Long id){
        return ResponseEntity.ok(facade.findAllDetalles(id));
    }


    @GetMapping("/getHabilitados")
    public ResponseEntity<?> getHabilitados(){
        return ResponseEntity.ok(facade.getAllHabilitado());
    }

    @GetMapping("/bySucursalId/{idSucursal}")
    public ResponseEntity<?>getAllById(@PathVariable Long idSucursal) {
        return ResponseEntity.ok(facade.findBySucursalId(idSucursal));
    }


}
