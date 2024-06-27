package com.entidades.buenSabor.business.mapper;

import com.entidades.buenSabor.business.service.ArticuloInsumoService;
import com.entidades.buenSabor.domain.dto.ArticuloManufacturadoDetalle.ArticuloManufacturadoDetalleDto;
import com.entidades.buenSabor.domain.entities.ArticuloManufacturadoDetalle;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.Set;

// En este caso, se utiliza el componente "spring" para la inyección de dependencias y se especifica
// la clase de servicio que utiliza.
@Mapper(componentModel = "spring", uses = {ArticuloInsumoService.class})
public interface ArticuloManufacturadoDetalleMapper extends BaseMapper<ArticuloManufacturadoDetalle, ArticuloManufacturadoDetalleDto>{

    ArticuloManufacturadoDetalleMapper INSTANCE = Mappers.getMapper(ArticuloManufacturadoDetalleMapper.class);

    @Named("toDTO")
    ArticuloManufacturadoDetalleDto toDTO(ArticuloManufacturadoDetalle source);


}
