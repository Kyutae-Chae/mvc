package com.codestates.mvc.coffee;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/v1/coffees")
public class CoffeeController {

    @PostMapping
    public ResponseEntity postCoffee(@RequestParam("engName") String engName,
                                     @RequestParam("korName") String korName,
                                     @RequestParam("price") int price) {
        System.out.println("# engName = " + engName);
        System.out.println("# korName = " + korName);
        System.out.println("# price = " + price);

        Map<String, Object> map = new HashMap<>();
        map.put("engName", engName);
        map.put("korName", korName);
        map.put("price", price);
        return new ResponseEntity(map, HttpStatus.CREATED);
    }

    @RequestMapping("/{coffee-id}")
    public ResponseEntity getCoffee(@PathVariable("coffee-id") long coffeeId) {
        System.out.println("# coffeeId = " + coffeeId);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping
    public ResponseEntity getCoffees() {
        System.out.println("CoffeeController.getCoffees");
        return new ResponseEntity(HttpStatus.OK);
    }
}
