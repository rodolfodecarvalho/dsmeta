package com.rodolfo.dsmeta.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rodolfo.dsmeta.services.SaleService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/sales")
@RequiredArgsConstructor
public class SaleController {

	private final SaleService saleService;

	@GetMapping
	public ResponseEntity<?> saleList() {
		return ResponseEntity.status(HttpStatus.OK).body(saleService.findSales());
	}
}