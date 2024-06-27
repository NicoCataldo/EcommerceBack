package com.entidades.buenSabor.business.mapper;

import com.entidades.buenSabor.business.service.ArticuloService;
import com.entidades.buenSabor.domain.dto.ArticuloManufacturado.ArticuloManufacturadoCategoriaDto;
import com.entidades.buenSabor.domain.dto.Insumo.ArticuloInsumoCategoriaDto;
import com.entidades.buenSabor.domain.dto.PromocionDetalle.PromocionDetalleDto;
import com.entidades.buenSabor.domain.entities.ArticuloInsumo;
import com.entidades.buenSabor.domain.entities.ArticuloManufacturado;
import com.entidades.buenSabor.domain.entities.PromocionDetalle;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.Set;


@Mapper(componentModel = "spring", uses = {ArticuloService.class,ArticuloInsumoMapper.class, ArticuloManufacturadoMapper.class})
public interface PromocionDetalleMapper extends BaseMapper<PromocionDetalle, PromocionDetalleDto>{

    PromocionDetalleMapper INSTANCE = Mappers.getMapper(PromocionDetalleMapper.class);



    //usamos el parametro expression para indicar que vamos a usar un metodo para definir el mapeo
    @Mapping(target = "insumo", expression = "java(filterArticuloInsumo(source))")
    @Mapping(target = "manufacturado", expression = "java(filterArticuloManufacturado(source))")
    public PromocionDetalleDto toDTO(PromocionDetalle source);

    // Este método consulta si el articulo es insumo
    default ArticuloInsumoCategoriaDto filterArticuloInsumo(PromocionDetalle source) {
        return (source.getArticulo() instanceof ArticuloInsumo) ? ArticuloInsumoMapper.INSTANCE.toDTOCategoria((ArticuloInsumo) source.getArticulo()) : null;
    }

    // Este método consulta si el articulo es insumo
    default ArticuloManufacturadoCategoriaDto filterArticuloManufacturado(PromocionDetalle source) {
        return (source.getArticulo() instanceof ArticuloManufacturado) ? ArticuloManufacturadoMapper.INSTANCE.toDTOCategoria((ArticuloManufacturado) source.getArticulo()) : null;
    }
}
