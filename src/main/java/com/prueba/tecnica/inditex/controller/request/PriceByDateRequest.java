package com.prueba.tecnica.inditex.controller.request;

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
public class PriceByDateRequest {
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
