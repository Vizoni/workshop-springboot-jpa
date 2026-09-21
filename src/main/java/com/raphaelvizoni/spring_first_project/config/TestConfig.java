package com.raphaelvizoni.spring_first_project.config;

import com.raphaelvizoni.spring_first_project.entities.Order;
import com.raphaelvizoni.spring_first_project.entities.User;
import com.raphaelvizoni.spring_first_project.entities.enums.OrderStatus;
import com.raphaelvizoni.spring_first_project.repositories.OrderRepository;
import com.raphaelvizoni.spring_first_project.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test") // o mesmo definido em spring.profiles.active do application.properties
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;


    // metodo do commandLineRunner, vai executar quando a aplicacao for iniciada
    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
        userRepository.saveAll(Arrays.asList(u1,u2));

        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
        Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2);
        Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, u1);
        orderRepository.saveAll(Arrays.asList(o1,o2,o3));
    }
}
