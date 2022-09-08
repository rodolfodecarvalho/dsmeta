package com.rodolfo.dsmeta.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.rodolfo.dsmeta.entities.Sale;

public interface SaleService {

	Page<Sale> findSales(String minDate, String maxDate, Pageable pageable);
}