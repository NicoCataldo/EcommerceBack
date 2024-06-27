package com.entidades.buenSabor.business.mapper;

import com.entidades.buenSabor.business.service.CategoriaService;
import com.entidades.buenSabor.business.service.SucursalService;
import com.entidades.buenSabor.business.service.UnidadMedidaService;
import com.entidades.buenSabor.domain.dto.ArticuloManufacturado.ArticuloManufacturadoCategoriaDto;
import com.entidades.buenSabor.domain.dto.ArticuloManufacturado.ArticuloManufacturadoDto;
import com.entidades.buenSabor.domain.entities.ArticuloManufacturado;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

// En este caso, se utiliza el componente "spring" para la inyección de dependencias y se especifican
// las clases de servicio y mappers que utiliza

@Mapper(componentModel = "spring", uses = {SucursalService.class,ArticuloManufacturadoDetalleMapper.class, UnidadMedidaService.class, ImagenArticuloMapper.class, CategoriaService.class})

public interface ArticuloManufacturadoMapper extends BaseMapper<ArticuloManufacturado, ArticuloManufacturadoDto> {

    // Esta es una instancia estática de la interfaz, que se utiliza para obtener una instancia del Mapper.
    ArticuloManufacturadoMapper INSTANCE = Mappers.getMapper(ArticuloManufacturadoMapper.class);

    @Named("toDTO")
    ArticuloManufacturadoDto toDTO(ArticuloManufacturado source);

    @Named("toDTOCategoria")
    @Mapping(source = "categoria.denominacion", target = "categoriaNombre")
    ArticuloManufacturadoCategoriaDto toDTOCategoria(ArticuloManufacturado source);
}
