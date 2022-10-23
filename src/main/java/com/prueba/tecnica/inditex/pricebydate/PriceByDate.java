package com.prueba.tecnica.inditex.pricebydate;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Entity
public class PriceByDate {

  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private Integer brandId;
  private Date startDate;
  private Date endDate;
  private Integer priceList;
  private Long productId;
  private Boolean priority;
  private Double price;
  private String curr;

  PriceByDate(Integer brandId, Date startDate, Date endDate, Integer priceList, Long productId, Boolean priority, Double price, String curr) {
    this.brandId = brandId;
    this.startDate = startDate;
    this.endDate = endDate;
    this.priceList = priceList;
    this.productId = productId;
    this.priority = priority;
    this.price = price;
    this.curr = curr;
  }

}
