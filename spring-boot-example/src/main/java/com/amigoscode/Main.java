package com.amigoscode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

///@org.springframework.boot.autoconfigure.EnableAutoConfiguration - Tomcat configs
//@org.springframework.context.annotation.ComponentScan - scanning the components from base pkgs
//@org.springframework.context.annotation.Configuration - to cater for beans

/* All above annotations are contained in @SpringBootApplication
Seen in all Main Classes in Spring*/
@SpringBootApplication
@RestController
@RequestMapping("api/v1/customers")
/* to allow REST endpoints CRUD operations. all the methods in the marked
class with return a JSON . Spring MVC(Model Viewer Controller abstracts the servlets proceses
to handle HTTP requests)*/

public class Main {


    private final CustomerRepository customerRepository;

    public Main(com.amigoscode.CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
@GetMapping
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }
}

/*
    @GetMapping("/greet")   //* The root "/" is the localhost:port configured in application.yml
    public GreetResponse greet() {
        GreetResponse response = new GreetResponse("Hello",
                List.of("Golang", "Javascript", "Java", "Kotlin"),
                new Person("Alex",28,30_000));
        return response;
    }

    record Person(String name, int age,double savings) {
    }

    record GreetResponse(String greet,
                         List<String> favProgrammingLanguages,
                         Person person) {
    }   //  Is the same as crating a class below

}
//    class GreetResponse{
//        private final String greet;
//
//    GreetResponse(String greet) {
//        this.greet = greet;
//    }
//
//    public String getGreet() {
//        return greet;
//    }
//
//    @Override
//    public String toString() {
//        return "GreetResponse{" +
//                "greet='" + greet + '\'' +
//                '}';
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        com.amigoscode.Main.GreetResponse that = (com.amigoscode.Main.GreetResponse) o;
//        return java.util.Objects.equals(greet, that.greet);
//    }
//
//    @Override
//    public int hashCode() {
//        return java.util.Objects.hash(greet);
//    }
*/

