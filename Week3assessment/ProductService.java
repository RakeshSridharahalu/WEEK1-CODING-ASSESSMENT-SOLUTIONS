package com.ig.CodingAssessments.Week3assessment;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ProductService {
	public static void main(String args[]) throws Exception{
		List<Product> l1=Arrays.asList(new Product(1, "Milk", "Dairy", 10.0, 50.0, LocalDate.of(2023, 7, 1), new Supplier(1, "Supplier A")),
	            new Product(2, "Lentils", "Pulses", 20.0, 60.0, LocalDate.of(2025, 3, 13), new Supplier(2, "Supplier B")),
	            new Product(3, "Black Pepper", "Spices", 5.0, 100.0, LocalDate.of(2025, 3, 30), new Supplier(3, "Supplier C")),
	            new Product(4, "Olive Oil", "Oils", 15.0, 200.0, LocalDate.of(2024, 5, 20), new Supplier(4, "Supplier D")),
	            new Product(5, "Potato Chips", "Snacks", 30.0, 30.0, LocalDate.of(2024, 8, 10), new Supplier(5, "Supplier E")));
		//Comparator<Product> comp;
//		for (Object product : l1) {
//            System.out.println(product.getClass());
//        }
		l1.stream().sorted(Comparator.comparing(Product::getPrice).reversed()).limit(1).forEach(x->System.out.println("Max price is:"+x.getPrice()));
		l1.stream().sorted(Comparator.comparing(Product::getPrice)).limit(1).forEach(x->System.out.println("Min price is:"+x.getPrice()));
		ChronoLocalDate currentDate=LocalDate.of(2025, 3, 4);
		ChronoLocalDate futureDate = currentDate.plus(10, ChronoUnit.DAYS);
		//ChronoLocalDate currentDate1=LocalDate.of(2025, 3, 14);
		l1.stream().filter(x->x.getExpiryDate().isBefore(currentDate)).forEach(x->System.out.println(x));
		l1.stream()
        .filter(x -> x.getExpiryDate().isAfter(currentDate) && x.getExpiryDate().isBefore(futureDate))
        .forEach(x -> System.out.println("Product expiring within the next 10 days: " + x.getName()));
		Map<String, Long> productCountByType = l1.stream()
	            .collect(Collectors.groupingBy(Product::getType, Collectors.counting()));
		productCountByType.forEach((type, count) -> System.out.println("Type: " + type + ", Count: " + count));
		Map<Object, Long> productCountBySupplier = l1.stream()
	            .collect(Collectors.groupingBy(product -> product.getSupplier().getSname(), Collectors.counting()));

	        productCountBySupplier.forEach((supplier, count) -> System.out.println("Supplier: " + supplier + ", Count: " +count));
	}
}
