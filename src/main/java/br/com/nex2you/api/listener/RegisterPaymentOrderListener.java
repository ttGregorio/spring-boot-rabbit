package br.com.nex2you.api.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import br.com.nex2you.api.entity.Order;
import br.com.nex2you.api.service.OrderService;

@Component
public class RegisterPaymentOrderListener {

	@Autowired
	private OrderService orderService;
	
	@RabbitListener(queues = {"${queue.register.order.name}"})
    public void receive(@Payload Order order) {
       orderService.registerPayment(order);
    }
}
