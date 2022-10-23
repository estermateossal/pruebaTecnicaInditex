package com.prueba.tecnica.inditex.service;

import com.prueba.tecnica.inditex.model.PriceByDate;
import java.util.Date;

public interface IPriceByDateService {

  PriceByDate getPriceByDateProductAndBrand(Date date, Long productId, Integer brand);

}
