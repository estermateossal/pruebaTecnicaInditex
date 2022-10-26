package com.prueba.tecnica.inditex.service.impl;

import com.prueba.tecnica.inditex.model.PriceByDateModel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FactoryTest {

    public static List<PriceByDateModel> createList() throws ParseException {
        SimpleDateFormat simpleDateFormat =  new SimpleDateFormat("yyyy-MM-dd-hh.mm.ss");

        PriceByDateModel priceByDate1 = PriceByDateModel.builder()
                .id(1L).brandId(1)
                .startDate(simpleDateFormat.parse("2020-06-13-22.00.00"))
                .endDate(simpleDateFormat.parse("2020-12-31-22.59.59"))
                .priceList(1).productId(35455).priority(0).price(35.5).curr("EUR")
                .build();
        PriceByDateModel priceByDate2 = PriceByDateModel.builder()
                .id(2L).brandId(1)
                .startDate(simpleDateFormat.parse("2020-06-14-13.00.00"))
                .endDate(simpleDateFormat.parse("2020-06-14-16.30.00"))
                .priceList(2).productId(35455).priority(1).price(25.45).curr("EUR")
                .build();
        PriceByDateModel priceByDate3 = PriceByDateModel.builder()
                .id(3L).brandId(1)
                .startDate(simpleDateFormat.parse("2020-06-14-22.00.00"))
                .endDate(simpleDateFormat.parse("2020-06-15-09.00.00"))
                .priceList(3).productId(35455).priority(1).price(30.5).curr("EUR")
                .build();
        PriceByDateModel priceByDate4 = PriceByDateModel.builder()
                .id(4L).brandId(1)
                .startDate(simpleDateFormat.parse("2020-06-15-14.00.00"))
                .endDate(simpleDateFormat.parse("2020-12-31-22.59.59"))
                .priceList(4).productId(35455).priority(1).price(38.95).curr("EUR")
                .build();
        return Stream.of(priceByDate1, priceByDate2, priceByDate3, priceByDate4)
                .collect(Collectors.toList());
    }

    public static Optional<PriceByDateModel> createElement2() throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd-hh.mm.ss");

        return Optional.of(PriceByDateModel.builder()
                .id(2L).brandId(1)
                .startDate(simpleDateFormat.parse("2020-06-14-13.00.00"))
                .endDate(simpleDateFormat.parse("2020-06-14-16.30.00"))
                .priceList(2).productId(35455).priority(1).price(25.45).curr("EUR")
                .build());
    }

    public static List<PriceByDateModel> findPriceTest1() throws ParseException {
        SimpleDateFormat simpleDateFormat =  new SimpleDateFormat("yyyy-MM-dd-hh.mm.ss");
        PriceByDateModel priceByDate1 = PriceByDateModel.builder()
                .id(1L).brandId(1)
                .startDate(simpleDateFormat.parse("2020-06-14-00.00.00"))
                .endDate(simpleDateFormat.parse("2020-12-31-23.59.59"))
                .priceList(1).productId(35455).priority(0).price(35.5).curr("EUR")
                .build();
        return Stream.of(priceByDate1)
                .collect(Collectors.toList());
    }

   public static List<PriceByDateModel> findPriceTest2() throws ParseException {
        SimpleDateFormat simpleDateFormat =  new SimpleDateFormat("yyyy-MM-dd-hh.mm.ss");
        PriceByDateModel priceByDate1 = PriceByDateModel.builder()
                .id(1L).brandId(1)
                .startDate(simpleDateFormat.parse("2020-06-14-00.00.00"))
                .endDate(simpleDateFormat.parse("2020-12-31-23.59.59"))
                .priceList(1).productId(35455).priority(0).price(35.5).curr("EUR")
                .build();

       PriceByDateModel priceByDate2 = PriceByDateModel.builder()
               .id(2L).brandId(1)
               .startDate(simpleDateFormat.parse("2020-06-14-15.00.00"))
               .endDate(simpleDateFormat.parse("2020-06-14-18.30.00"))
               .priceList(2).productId(35455).priority(1).price(25.45).curr("EUR")
               .build();
        return Stream.of(priceByDate1, priceByDate2)
                .collect(Collectors.toList());
    }

    public static List<PriceByDateModel> findPriceTest3() throws ParseException {
        SimpleDateFormat simpleDateFormat =  new SimpleDateFormat("yyyy-MM-dd-hh.mm.ss");
//list [PriceByDateModel(id=1, brandId=1, startDate=2020-06-14 00:00:00.0, endDate=2020-12-31 23:59:59.0, priceList=1, productId=35455, priority=0, price=35.5, curr=EUR)]
        PriceByDateModel priceByDate1 = PriceByDateModel.builder()
                .id(1L).brandId(1)
                .startDate(simpleDateFormat.parse("2020-06-13-22.00.00"))
                .endDate(simpleDateFormat.parse("2020-12-31-22.59.59"))
                .priceList(1).productId(35455).priority(0).price(35.5).curr("EUR")
                .build();
        return Stream.of(priceByDate1)
                .collect(Collectors.toList());

    }

    public static List<PriceByDateModel> findPriceTest4() throws ParseException {
        SimpleDateFormat simpleDateFormat =  new SimpleDateFormat("yyyy-MM-dd-hh.mm.ss");
//list [PriceByDateModel(id=1, brandId=1, startDate=2020-06-14 00:00:00.0, endDate=2020-12-31 23:59:59.0, priceList=1, productId=35455, priority=0, price=35.5, curr=EUR), PriceByDateModel(id=3, brandId=1, startDate=2020-06-15 00:00:00.0, endDate=2020-06-15 11:00:00.0, priceList=3, productId=35455, priority=1, price=30.5, curr=EUR)]
        PriceByDateModel priceByDate1 = PriceByDateModel.builder()
                .id(1L).brandId(1)
                .startDate(simpleDateFormat.parse("2020-06-13-22.00.00"))
                .endDate(simpleDateFormat.parse("2020-12-31-22.59.59"))
                .priceList(1).productId(35455).priority(0).price(35.5).curr("EUR")
                .build();
        return Stream.of(priceByDate1)
                .collect(Collectors.toList());
    }

    public static List<PriceByDateModel> findPriceTest5() throws ParseException {
        SimpleDateFormat simpleDateFormat =  new SimpleDateFormat("yyyy-MM-dd-hh.mm.ss");
//list [PriceByDateModel(id=1, brandId=1, startDate=2020-06-14 00:00:00.0, endDate=2020-12-31 23:59:59.0, priceList=1, productId=35455, priority=0, price=35.5, curr=EUR), PriceByDateModel(id=4, brandId=1, startDate=2020-06-15 16:00:00.0, endDate=2020-12-31 23:59:59.0, priceList=4, productId=35455, priority=1, price=38.95, curr=EUR)]
        PriceByDateModel priceByDate1 = PriceByDateModel.builder()
                .id(1L).brandId(1)
                .startDate(simpleDateFormat.parse("2020-06-13-22.00.00"))
                .endDate(simpleDateFormat.parse("2020-12-31-22.59.59"))
                .priceList(1).productId(35455).priority(0).price(35.5).curr("EUR")
                .build();
        return Stream.of(priceByDate1)
                .collect(Collectors.toList());
    }

}
