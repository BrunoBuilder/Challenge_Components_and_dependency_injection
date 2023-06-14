package com.brunobuilder.challenge;

import com.brunobuilder.entities.Order;
import com.brunobuilder.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.Locale;
import java.util.Scanner;

@SpringBootApplication
@ComponentScan({"com.brunobuilder"})
public class ChallengeApplication implements CommandLineRunner {
	@Autowired
	private OrderService orderService;

	public static void main(String[] args) {
		SpringApplication.run(ChallengeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		System.out.print("Code: ");
		int code = sc.nextInt();
		System.out.print("Basic: $ ");
		double basic = sc.nextDouble();
		System.out.print("Discount: % ");
		double discount = sc.nextDouble();
		Order order = new Order(code,basic,discount);
		System.out.printf("Order code %d%nTotal value: $%.2f%n", order.getCode(), orderService.total(order));
		sc.close();
	}
}
