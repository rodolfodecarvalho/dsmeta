package com.rodolfo.dsmeta.services;

import com.twilio.rest.api.v2010.account.Message;

public interface SmsService {

	public Message sendSms(Long id) throws Exception;
}