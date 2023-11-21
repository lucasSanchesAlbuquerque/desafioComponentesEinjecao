package com.lucassa.desafio.services;

import org.springframework.stereotype.Service;

import com.lucassa.desafio.entity.Order;

@Service
public class ShippingService {
	
	
	public double shipment(Order order) {
	
		if(order.getBasic() >= 100 && order.getBasic() <= 200) {
			return 12;
		}
		if(order.getBasic() > 200) {
			return 0;
		}
		
		return 20;
	}

}
