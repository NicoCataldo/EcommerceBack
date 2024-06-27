package com.entidades.buenSabor.business.mapper;

import com.entidades.buenSabor.business.service.CategoriaService;
import com.entidades.buenSabor.business.service.SucursalService;
import com.entidades.buenSabor.business.service.UnidadMedidaService;
import com.entidades.buenSabor.domain.dto.Insumo.ArticuloInsumoCategoriaDto;
import com.entidades.buenSabor.domain.dto.Insumo.ArticuloInsumoDto;
import com.entidades.buenSabor.domain.entities.ArticuloInsumo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
// En este caso, se utiliza el componente "spring" para la inyección de dependencias y se especifican
// las clases de servicio y mappers que utiliza.
@Mapper(componentModel = "spring", uses = {UnidadMedidaService.class, ImagenArticuloMapper.class, CategoriaService.class, SucursalService.class})
public interface ArticuloInsumoMapper extends BaseMapper<ArticuloInsumo, ArticuloInsumoDto> {
    // Esta es una instancia estática de la interfaz, que se utiliza para obtener una instancia del Mapper.
    ArticuloInsumoMapper INSTANCE = Mappers.getMapper(ArticuloInsumoMapper.class);

    @Named("toDTO")
    ArticuloInsumoDto toDTO(ArticuloInsumo source);


    @Named("toDTOCategoria")
    @Mapping(source = "categoria.denominacion",target = "categoriaNombre")
    ArticuloInsumoCategoriaDto toDTOCategoria(ArticuloInsumo articulo);
}
