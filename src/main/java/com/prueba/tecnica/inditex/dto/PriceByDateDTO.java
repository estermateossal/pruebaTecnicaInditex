package com.prueba.tecnica.inditex.dto;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class PriceByDateDTO {

  private Long id;
  private Integer brandId;
  private Date startDate;
  private Date endDate;
  private Integer priceList;
  private Integer productId;
  private Integer priority;
  private Double price;
  private String curr;

}
