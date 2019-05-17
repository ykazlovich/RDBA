package com.rdba.repository;

import com.rdba.OrderTestData;
import com.rdba.model.jpa.order.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/spring.xml")
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class JpaOrderRepositoryTest {

    @Autowired
    OrderRepository orderRepository;

    @Test
    public void getAllOrder() {
        List<Order> orders = orderRepository.getAllOrder();
        assertThat(orders)
                .usingElementComparatorIgnoringFields("date", "client", "item")
                .isEqualTo(OrderTestData.allOrder);
    }

    @Test
    public void getOrder() {
        Order order = orderRepository.getOrder(1);
        assertThat(order)
                .isEqualToIgnoringGivenFields(OrderTestData.orderCheck1, "date", "client", "item");
    }

    @Test
    public void getNotExistingOrder() {
        Order order = orderRepository.getOrder(31);
        assertThat(order).isNull();
    }

    @Test
    public void saveOrder() {

    }





}