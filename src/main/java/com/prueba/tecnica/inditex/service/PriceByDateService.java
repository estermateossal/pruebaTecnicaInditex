package com.prueba.tecnica.inditex.service;

import com.prueba.tecnica.inditex.model.PriceByDate;
import com.prueba.tecnica.inditex.repository.PriceByDateRepository;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class PriceByDateService implements IPriceByDateService {

  private final PriceByDateRepository repository;

  public PriceByDateService(PriceByDateRepository repository) {
    this.repository = repository;
  }

  @Override
  public PriceByDate getPriceByDateProductAndBrand(Date date, Long productId, Integer brand) {
    List<PriceByDate> pricesByProductAndBrand = repository.findByProductIdAndBrandId(productId, brand);
    List<PriceByDate> priceByDateList = pricesByProductAndBrand.stream()
        .filter(p -> isOnDateRange(date, p.getStartDate(), p.getEndDate()))
        .collect(Collectors.toList());
    if (!priceByDateList.isEmpty()) {
      if (priceByDateList.size() == 1) {
        return priceByDateList.get(0);
      } else {
        return priceByDateList.stream()
            .filter(p -> p.getPriority().equals(true))
            .collect(Collectors.toList()).get(0);
      }
    }
    return null;
  }

  private boolean isOnDateRange(Date date, Date startDate, Date endDate) {
    return date.after(startDate) && date.before(endDate);
  }

}
