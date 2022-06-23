package com.codestates.mvc.coffee;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/v1/coffees")
public class CoffeeController {

    @PostMapping
    public ResponseEntity postCoffee(@RequestBody CoffeePostDto coffeePostDto) {
        return new ResponseEntity(coffeePostDto, HttpStatus.CREATED);
    }

    @PatchMapping
    public ResponseEntity patchCoffee(@RequestBody CoffeePatchDto coffeePatchDto) {
        coffeePatchDto.setEngName("Vanilla Latte");
        return new ResponseEntity(coffeePatchDto, HttpStatus.OK);
    }

    @GetMapping("/{coffee-id}")
    public ResponseEntity getCoffee(@PathVariable("coffee-id") long coffeeId) {
        System.out.println("# coffeeId = " + coffeeId);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getCoffees(HttpEntity httpEntity) {
        for (Map.Entry<String, List<String>> entry : httpEntity.getHeaders().entrySet()) {
            System.out.println("key : " + entry.getKey()
                    + ", " + "value : " + entry.getValue());
        }
        System.out.println("host : " + httpEntity.getHeaders().getHost());
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/{coffee-id}")
    public ResponseEntity deleteCoffee(@PathVariable("coffee-id") long coffeeId) {
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
