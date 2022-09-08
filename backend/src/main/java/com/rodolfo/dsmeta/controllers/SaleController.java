package com.rodolfo.dsmeta.controllers;

import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rodolfo.dsmeta.services.SaleService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/sales")
@RequiredArgsConstructor
public class SaleController {

	private final SaleService saleService;

	@GetMapping
	public ResponseEntity<?> saleList(@RequestParam(value = "minDate", defaultValue = "") String minDate,
			@RequestParam(value = "maxDate", defaultValue = "") String maxDate, Pageable pageable) {
		return ResponseEntity.status(HttpStatus.OK).body(saleService.findSales(minDate, maxDate, pageable));
	}
}