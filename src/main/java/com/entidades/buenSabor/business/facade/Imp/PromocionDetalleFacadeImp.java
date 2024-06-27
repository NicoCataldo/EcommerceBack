package com.entidades.buenSabor.business.facade.Imp;

import com.entidades.buenSabor.business.facade.Base.BaseFacadeImp;
import com.entidades.buenSabor.business.mapper.BaseMapper;
import com.entidades.buenSabor.business.service.Base.BaseService;
import com.entidades.buenSabor.domain.dto.PromocionDetalle.PromocionDetalleDto;
import com.entidades.buenSabor.domain.entities.PromocionDetalle;
import org.springframework.stereotype.Service;

@Service
public class PromocionDetalleFacadeImp extends BaseFacadeImp <PromocionDetalle, PromocionDetalleDto,Long> {
    public PromocionDetalleFacadeImp(BaseService<PromocionDetalle, Long> baseService, BaseMapper<PromocionDetalle, PromocionDetalleDto> baseMapper) {
        super(baseService, baseMapper);
    }
}
