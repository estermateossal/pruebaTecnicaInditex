package com.prueba.tecnica.inditex.service.impl;

import com.prueba.tecnica.inditex.model.PriceByDateModel;
import com.prueba.tecnica.inditex.repository.PriceByDateRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PriceByDateServiceTest {

    @Autowired
    private PriceByDateService service;

    @MockBean
    private PriceByDateRepository repository;

    @Before
    public void setUp() throws ParseException {
        List<PriceByDateModel> list = FactoryTest.createList();
        Mockito.when(repository.findAll()).thenReturn(list);

        Optional<PriceByDateModel> price2 = FactoryTest.createElement2();
        Mockito.when(repository.findById(2L)).thenReturn(price2);
    }

    @Test
    public void validGetAllOk() {
        List<PriceByDateModel> found = service.getAllPriceByDateRecord();

        assertThat(found.size()).isEqualTo(4);
    }

    @Test
    public void validGetOneOk() {
        Optional<PriceByDateModel> found = service.getPriceByDateRecord(2L);

        assertThat(found.isPresent()).isEqualTo(true);
        // "2020-06-14-13.00.00"
        assertThat(found.get().getStartDate().toString())
                .isEqualTo("Sun Jun 14 13:00:00 CEST 2020");
    }

    @Test
    public void validPriceByDateProductAndBrand() throws ParseException {
       //TODO
    }

}
