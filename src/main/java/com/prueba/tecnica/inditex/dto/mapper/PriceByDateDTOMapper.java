package com.prueba.tecnica.inditex.dto.mapper;

import com.prueba.tecnica.inditex.controller.request.PriceByDateRequest;
import com.prueba.tecnica.inditex.dto.PriceByDateDTO;
import org.springframework.stereotype.Component;

@Component
public class PriceByDateDTOMapper {

  public PriceByDateDTO mapRequestToDTO(PriceByDateRequest request) {
    return PriceByDateDTO.builder()
        .id(request.getId())
        .brandId(request.getBrandId())
        .startDate(request.getStartDate())
        .endDate(request.getEndDate())
        .priceList(request.getPriceList())
        .productId(request.getProductId())
        .priority(request.getPriority())
        .price(request.getPrice())
        .curr(request.getCurr())
        .build();
  }

}
