package com.prueba.tecnica.inditex.service;

import com.prueba.tecnica.inditex.dto.PriceByDateDTO;
import com.prueba.tecnica.inditex.model.PriceByDateModel;
import com.prueba.tecnica.inditex.model.mapper.PriceByDateModelMapper;
import com.prueba.tecnica.inditex.repository.PriceByDateRepository;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class PriceByDateService implements IPriceByDateService {

  private final PriceByDateModelMapper mapper;
  private final PriceByDateRepository repository;

  public PriceByDateService(final PriceByDateRepository repository, final PriceByDateModelMapper mapper) {
    this.repository = repository;
    this.mapper = mapper;
  }

  @Override
  public List<PriceByDateModel> getAllPriceByDateRecord() {
    return repository.findAll();
  }

  @Override
  public Optional<PriceByDateModel> getPriceByDateRecord(Long id) {
    return repository.findById(id);
  }

  @Override
  public PriceByDateModel createPriceByDateRecord(PriceByDateDTO dto) {
    return repository.save(mapper.mapDTOToModel(dto));
  }

  @Override
  public Optional<PriceByDateModel> getPriceByDateProductAndBrand(String date, Integer productId, Integer brand) throws ParseException {
    List<PriceByDateModel> priceByDateModelList = repository
        .findPrice(productId, brand, new SimpleDateFormat("yyyy-MM-dd-hh.mm.ss").parse(date));

    return priceByDateModelList.stream()
        .reduce((price1, price2) ->
            price1.getPriority() > price2.getPriority() ? price1 : price2);
  }

  @Override
  public void deletePriceByDate(Long id) {
    repository.deleteById(id);
  }

  @Override
  public PriceByDateModel replacePriceByDate(PriceByDateDTO dto, Long id) {
    return this.getPriceByDateRecord(id)
        .map(priceByDate -> {
          priceByDate.setBrandId(dto.getBrandId());
          priceByDate.setStartDate(dto.getStartDate());
          priceByDate.setEndDate(dto.getEndDate());
          priceByDate.setPriceList(dto.getPriceList());
          priceByDate.setProductId(dto.getProductId());
          priceByDate.setPriority(dto.getPriority());
          priceByDate.setPrice(dto.getPrice());
          priceByDate.setCurr(dto.getCurr());
          return repository.save(priceByDate);
        })
        .orElseGet(() -> {
          dto.setId(id);
          return repository.save(mapper.mapDTOToModel(dto));
        });
  }

}
