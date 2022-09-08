package com.rodolfo.dsmeta.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rodolfo.dsmeta.entities.Sale;
import com.rodolfo.dsmeta.repositories.SaleRepository;
import com.rodolfo.dsmeta.services.SaleService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class SaleServiceImpl implements SaleService {

	private final SaleRepository saleRepository;

	@Override
	public List<Sale> findSales() {
		return saleRepository.findAll();
	}
}