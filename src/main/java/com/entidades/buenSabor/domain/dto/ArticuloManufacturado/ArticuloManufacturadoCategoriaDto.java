package com.entidades.buenSabor.domain.dto.ArticuloManufacturado;

import com.entidades.buenSabor.domain.dto.ArticuloManufacturadoDetalle.ArticuloManufacturadoDetalleDto;
import com.entidades.buenSabor.domain.dto.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ArticuloManufacturadoCategoriaDto extends BaseDto {
    private String denominacion;
    private String descripcion;
    private Integer tiempoEstimadoMinutos;
    private Double precioVenta;
    private String preparacion;
    private Set<ArticuloManufacturadoDetalleDto> articuloManufacturadoDetalles;
    private Boolean habilitado;
    private String categoriaNombre;
}
