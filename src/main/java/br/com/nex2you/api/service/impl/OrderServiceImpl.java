package br.com.nex2you.api.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.nex2you.api.entity.Order;
import br.com.nex2you.api.producer.RegisterPaymentOrderProducer;
import br.com.nex2you.api.repository.OrderRepository;
import br.com.nex2you.api.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private RegisterPaymentOrderProducer registerPaymentOrderProducer;

	@Override
	public List<Order> findAll() {
		return (List<Order>) orderRepository.findAll();
	}

	@Override
	public Optional<Order> findById(int id) {
		return orderRepository.findById(id);
	}

	@Override
	public Order createUpdate(Order order) {
		Order createdOrder = orderRepository.save(order);

		registerPaymentOrderProducer.registerPayment(createdOrder);

		return createdOrder;
	}

	@Override
	public void registerPayment(Order order) {
		order.setPaymentCode(UUID.randomUUID());

		orderRepository.save(order);
	}
}
