package com.lucassa.desafio.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucassa.desafio.entity.Order;

@Service
public class OrderService {
	
	@Autowired
	ShippingService shippingService;
	
	public double total(Order order) {
		Double total = order.getBasic() - (order.getBasic() * (order.getDiscount()/100));
		total = total + shippingService.shipment(order);
		return total;
	}

}
