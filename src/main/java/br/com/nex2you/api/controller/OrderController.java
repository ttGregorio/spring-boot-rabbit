package br.com.nex2you.api.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.nex2you.api.entity.Order;
import br.com.nex2you.api.service.OrderService;

@RestController
public class OrderController {

	@Autowired
	private OrderService orderService;

	@GetMapping
	public ResponseEntity<List<Order>> findAll() {
		return ResponseEntity.ok(orderService.findAll());
	}

	@GetMapping(value = "{id}")
	public ResponseEntity<Order> findById(@PathVariable int id) {
		Optional<Order> optional = orderService.findById(id);

		if (optional.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		} else {
			return ResponseEntity.ok(optional.get());
		}
	}

	@PostMapping
	public ResponseEntity<Order> create(@RequestBody Order order) {
		order.setDate(new Date());
		return ResponseEntity.ok(orderService.createUpdate(order));
	}
}
