package br.com.nex2you.api.producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import br.com.nex2you.api.entity.Order;

@Component
public class RegisterPaymentOrderProducer {

	@Autowired
    private RabbitTemplate rabbitTemplate;

	@Value("${queue.register.order.name}")
	private String orderQueue;
	
	public void registerPayment(Order order) {
        rabbitTemplate.convertAndSend(orderQueue, order);
	}
}
