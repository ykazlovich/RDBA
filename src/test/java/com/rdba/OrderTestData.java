package com.rdba;

import org.springframework.test.web.servlet.ResultMatcher;
import com.rdba.model.jpa.item.Item;
import com.rdba.model.jpa.order.Order;


import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static com.rdba.web.json.JsonUtil.writeIgnoreProps;

public class OrderTestData {
    public static final Order orderCheck1 = new Order(1, "Not work", new Item("WD10EARX", "WX12018319423"));
    public static final Order orderCheck2 = new Order(2, "Not detect in BIOS", new Item("ST500DM001", "SV39KDHE3"));
    public static final Order orderCheck3 = new Order(3, "Partition not recognized", new Item("MK3259GSXP", "TV2KDMWU"));

    public static final List<Order> allOrder = List.of(orderCheck1, orderCheck2, orderCheck3);

    public static ResultMatcher contentJson(Order expected) {
        return content().json(writeIgnoreProps(expected, "client"));
    }

    public static ResultMatcher contentJsonIterable(List<Order> orders){
        return content().json(writeIgnoreProps(orders, "client"));
    }

}
