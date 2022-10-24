package com.prueba.tecnica.inditex.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
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
@Table(name = "Prices")
public class PriceByDateModel {

  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
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
