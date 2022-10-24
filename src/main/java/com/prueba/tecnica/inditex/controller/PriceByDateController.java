package com.prueba.tecnica.inditex.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import com.prueba.tecnica.inditex.controller.request.PriceByDateRequest;
import com.prueba.tecnica.inditex.dto.PriceByDateDTO;
import com.prueba.tecnica.inditex.dto.mapper.PriceByDateDTOMapper;
import com.prueba.tecnica.inditex.model.PriceByDateModel;
import com.prueba.tecnica.inditex.model.mapper.PriceByDateModelMapper;
import com.prueba.tecnica.inditex.service.IPriceByDateService;
import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PriceByDateController {

  private final IPriceByDateService service;
  private final PriceByDateDTOAssembler assembler;
  private final PriceByDateDTOMapper requestMapper;
  private final PriceByDateModelMapper modelMapper;

  public PriceByDateController(final PriceByDateDTOAssembler assembler, final PriceByDateDTOMapper requestMapper,
      final IPriceByDateService service, final PriceByDateModelMapper modelMapper) {
    this.service = service;
    this.assembler = assembler;
    this.modelMapper = modelMapper;
    this.requestMapper = requestMapper;
  }

  @GetMapping("/pricesByDate")
  CollectionModel<EntityModel<PriceByDateDTO>> all() {
    List<EntityModel<PriceByDateDTO>> pricesByDate = service.getAllPriceByDateRecord()
        .stream()
        .map(x -> assembler.toModel(modelMapper.mapModelToDTO(x)))
        .collect(Collectors.toList());

    return CollectionModel.of(
        pricesByDate, linkTo(methodOn(PriceByDateController.class).all()).withSelfRel());
  }

  @PostMapping("/pricesByDate")
  ResponseEntity<EntityModel<PriceByDateDTO>> postPriceByDate(@RequestBody PriceByDateRequest request) {
    PriceByDateModel price = service.createPriceByDateRecord(requestMapper.mapRequestToDTO(request));
    EntityModel<PriceByDateDTO> entityModel = assembler.toModel(modelMapper.mapModelToDTO(price));

    return ResponseEntity
        .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
        .body(entityModel);
  }

  @GetMapping("/pricesByDate/{id}")
  EntityModel<PriceByDateDTO> one(@PathVariable Long id) {
    PriceByDateModel priceByDateModel = service.getPriceByDateRecord(id)
        .orElseThrow(() -> new PriceByDateNotFoundException(id));

    return assembler.toModel(modelMapper.mapModelToDTO(priceByDateModel));
  }

  @GetMapping(value="/priceByDateProductAndBrand")
  EntityModel<PriceByDateDTO> getPriceByDateProductAndBrand(@RequestParam String date, @RequestParam Integer productId, @RequestParam Integer brandId) {
    PriceByDateModel priceByDate = null;
    try {
      priceByDate = service.getPriceByDateProductAndBrand(date, productId, brandId)
          .orElseThrow(() -> new PriceByDateNotFoundException(date, productId, brandId));

      return assembler.toModel(modelMapper.mapModelToDTO(priceByDate));
    } catch (ParseException e) {
      return assembler.toModel(null); //TODO change response exception
    }
  }

  @PutMapping("/pricesByDate/{id}")
  ResponseEntity<EntityModel<PriceByDateDTO>> replacePriceByDate(@RequestBody PriceByDateRequest request, @PathVariable Long id) {
    PriceByDateModel updatedPriceByDateModel = service.replacePriceByDate(requestMapper.mapRequestToDTO(request), id);
    
    EntityModel<PriceByDateDTO> entityModel = assembler
        .toModel(modelMapper.mapModelToDTO(updatedPriceByDateModel));

    return ResponseEntity
        .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
        .body(entityModel);
  }

  @DeleteMapping("/pricesByDate/{id}")
  ResponseEntity<EntityModel<PriceByDateDTO>> deletePriceByDate(@PathVariable Long id) {
    service.deletePriceByDate(id);
    return ResponseEntity.noContent().build();
  }

}
