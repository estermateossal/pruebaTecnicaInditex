package com.prueba.tecnica.inditex.repository;

import com.prueba.tecnica.inditex.model.PriceByDateModel;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceByDateRepository extends JpaRepository<PriceByDateModel, Long> {

  @Query(value = "SELECT * "
      + "FROM prices "
      + "WHERE product_id = :productId AND brand_id = :brandId AND start_date < :date AND :date < end_date",
      nativeQuery = true)
  List<PriceByDateModel> findPrice(@Param("productId") Integer productId, @Param("brandId") Integer brand, @Param("date") Date date);

}
