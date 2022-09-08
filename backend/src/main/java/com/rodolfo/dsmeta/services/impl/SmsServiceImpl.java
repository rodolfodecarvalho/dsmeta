package com.rodolfo.dsmeta.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.rodolfo.dsmeta.entities.Sale;
import com.rodolfo.dsmeta.repositories.SaleRepository;
import com.rodolfo.dsmeta.services.SmsService;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SmsServiceImpl implements SmsService {

	private final SaleRepository saleRepository;

	@Value("${twilio.sid}")
	private String twilioSid;

	@Value("${twilio.key}")
	private String twilioKey;

	@Value("${twilio.phone.from}")
	private String twilioPhoneFrom;

	@Value("${twilio.phone.to}")
	private String twilioPhoneTo;

	@Override
	public Message sendSms(Long id) throws Exception {

		Optional<Sale> saleOptional = saleRepository.findById(id);

		if (saleOptional.isPresent()) {
			Sale sale = saleOptional.get();
			StringBuilder msg = new StringBuilder();

			msg.append("O vendedor: ");
			msg.append(sale.getSellerName());
			msg.append(" foi destaque em ");
			msg.append(sale.getDate().getMonthValue()).append("/").append(sale.getDate().getYear());
			msg.append(" com um total de R$ ");
			msg.append(String.format("%.2f", sale.getAmount()));

			Twilio.init(twilioSid, twilioKey);

			PhoneNumber to = new PhoneNumber(twilioPhoneTo);
			PhoneNumber from = new PhoneNumber(twilioPhoneFrom);

			return Message.creator(to, from, msg.toString()).create();
		}

		throw new Exception("Sale not found");
	}
}