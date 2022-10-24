package com.prueba.tecnica.inditex.model.mapper;

import com.prueba.tecnica.inditex.dto.PriceByDateDTO;
import com.prueba.tecnica.inditex.model.PriceByDateModel;
import org.springframework.stereotype.Component;

@Component
public class PriceByDateModelMapper {

  public PriceByDateModel mapDTOToModel(PriceByDateDTO dto) {
    return PriceByDateModel.builder()
        .id(dto.getId())
        .brandId(dto.getBrandId())
        .startDate(dto.getStartDate())
        .endDate(dto.getEndDate())
        .priceList(dto.getPriceList())
        .productId(dto.getProductId())
        .priority(dto.getPriority())
        .price(dto.getPrice())
        .curr(dto.getCurr())
        .build();
  }

  public PriceByDateDTO mapModelToDTO(PriceByDateModel model) {
    return PriceByDateDTO.builder()
        .id(model.getId())
        .brandId(model.getBrandId())
        .startDate(model.getStartDate())
        .endDate(model.getEndDate())
        .priceList(model.getPriceList())
        .productId(model.getProductId())
        .priority(model.getPriority())
        .price(model.getPrice())
        .curr(model.getCurr())
        .build();
  }

}
