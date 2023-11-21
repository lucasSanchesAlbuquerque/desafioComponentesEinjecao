package com.lucassa.desafio;

import java.util.Locale;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cglib.core.Local;

import com.lucassa.desafio.entity.Order;
import com.lucassa.desafio.services.OrderService;

@SpringBootApplication
public class DesafioApplication implements CommandLineRunner {
	
	@Autowired
	OrderService orderService;
	
	public static void main(String[] args) {
		SpringApplication.run(DesafioApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Code: ");
		Integer code = sc.nextInt();
		
		System.out.print("Basic: ");
		Double basic = sc.nextDouble();
		
		System.out.print("Discount: ");
		Double discount = sc.nextDouble();
		
		Double total = orderService.total(new Order(code, basic, discount));
		
		System.out.println("Pedido código: " + code);
		System.out.printf("Valor total: R$ %.2f%n", total);
		
		sc.close();
	}

}
