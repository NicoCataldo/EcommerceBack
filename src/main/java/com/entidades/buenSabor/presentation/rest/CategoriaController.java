package com.entidades.buenSabor.presentation.rest;

import com.entidades.buenSabor.business.facade.Imp.CategoriaFacadeImp;
import com.entidades.buenSabor.domain.dto.Categoria.CategoriaCreateDto;
import com.entidades.buenSabor.domain.dto.Categoria.CategoriaDto;
import com.entidades.buenSabor.domain.dto.Categoria.CategoriaEditDto;
import com.entidades.buenSabor.domain.entities.Categoria;
import com.entidades.buenSabor.presentation.rest.Base.BaseControllerImp;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/categoria")
public class CategoriaController extends BaseControllerImp<Categoria, CategoriaDto, Long, CategoriaFacadeImp> {


    public CategoriaController(CategoriaFacadeImp facade) {
        super(facade);
    }

    @GetMapping("/getCategoriasInsumos")
    public ResponseEntity<?> listCategoriasInsumos(){
        return ResponseEntity.ok(facade.listCategoriaInsumos());
    }

    @GetMapping("/getCategoriasArticulos")
    public ResponseEntity<?> listCategoriasArticulo(){
        return ResponseEntity.ok(facade.listCategoriaArticulos());
    }
}