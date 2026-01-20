package com.calculator.demo_bc_calculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


// ! Step 1: Java Compile (with Maven Dependency) -> jar file
// ! Step 2: Look up all annotations, which creates Bean (@Controller, @Service, @Repository, @Component, @Configuration)
// ! Step 3: Check the dependency betwwen Beans, identiy the sequence of creating beans;
// ! Step 4: In case any dependency (beans) not foud, server fail to start.
@SpringBootApplication
public class DemoBcCalculatorApplication {

	// ! 7 x 24
	public static void main(String[] args) {
		SpringApplication.run(DemoBcCalculatorApplication.class, args); // never end
	}

}
