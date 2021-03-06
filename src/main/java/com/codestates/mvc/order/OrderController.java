package com.codestates.mvc.order;

import com.codestates.mvc.coffee.Coffee;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/v1/orders")
public class OrderController {

    @PostMapping
    public ResponseEntity postOrder(@RequestParam("memberId") long memberId,
                                    @RequestParam("coffeeId") long coffeeId) {
        System.out.println("# memberId = " + memberId);
        System.out.println("# coffeeId = " + coffeeId);
//        Map<String, Long> map = new HashMap<>();
//        map.put("memberId", memberId);
//        map.put("coffeeId", coffeeId);
        return new ResponseEntity<>(new Order(memberId, coffeeId), HttpStatus.CREATED);
    }

    @GetMapping("/{order-id}")
    public ResponseEntity getOrder(@PathVariable("order-id") long orderId) {
        System.out.println("# orderId = " + orderId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getOrders() {
        System.out.println("OrderController.getOrders");
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
