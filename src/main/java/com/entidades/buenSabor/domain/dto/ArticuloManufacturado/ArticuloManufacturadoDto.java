package com.entidades.buenSabor.domain.dto.ArticuloManufacturado;

import com.entidades.buenSabor.domain.dto.ArticuloManufacturadoDetalle.ArticuloManufacturadoDetalleDto;
import com.entidades.buenSabor.domain.dto.BaseDto;
import com.entidades.buenSabor.domain.dto.Imagen.ImagenDto;
import lombok.*;

import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ArticuloManufacturadoDto extends BaseDto {
    private String denominacion;
    private Double precioVenta;
    private String descripcion;
    private Integer tiempoEstimadoMinutos;
    private String preparacion;
    private Set<ArticuloManufacturadoDetalleDto> articuloManufacturadoDetalles;
    private Boolean habilitado;
    private Set<ImagenDto> imagenes;
}
