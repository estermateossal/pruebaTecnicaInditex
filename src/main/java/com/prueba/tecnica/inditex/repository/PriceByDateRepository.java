package com.prueba.tecnica.inditex.repository;

import com.prueba.tecnica.inditex.model.PriceByDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriceByDateRepository extends JpaRepository<PriceByDate, Long> {

  List<PriceByDate> findByProductIdAndBrandId(Long productId, Integer brand);

}
