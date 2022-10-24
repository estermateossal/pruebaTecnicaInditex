package com.prueba.tecnica.inditex.service;

import com.prueba.tecnica.inditex.dto.PriceByDateDTO;
import com.prueba.tecnica.inditex.model.PriceByDateModel;
import java.text.ParseException;
import java.util.List;
import java.util.Optional;

public interface IPriceByDateService {

  List<PriceByDateModel> getAllPriceByDateRecord();

  Optional<PriceByDateModel> getPriceByDateRecord(Long id);

  PriceByDateModel createPriceByDateRecord(PriceByDateDTO priceByDateDTO);

  Optional<PriceByDateModel> getPriceByDateProductAndBrand(String date, Integer productId, Integer brand) throws ParseException;

  void deletePriceByDate(Long id);

  PriceByDateModel replacePriceByDate(PriceByDateDTO priceByDateDTO, Long id);

}
