/**
 * Copyright 2022, 2023 IBM Corp.
 *
 * Licensed under the Apache License, Version 2.0 (the 'License');
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 **/

package com.example.mq_spring.service;

import com.example.mq_spring.dto.NewMessageDto;
import org.springframework.jms.JmsException;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;

@Service
public class MQMessageService {

	private final JmsTemplate jmsTemplate;
	
	@Value("${ibm.mq.queue}")
	private String queue;

	public MQMessageService(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}

	public NewMessageDto send(NewMessageDto newMessageDto) {
		try {						
			jmsTemplate.convertAndSend(queue, newMessageDto);
			return newMessageDto;
		} catch (JmsException ex) {
			ex.fillInStackTrace();
			return null;
		}
	}
}
