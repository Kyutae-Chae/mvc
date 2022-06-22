package com.codestates.mvc.coffee;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/coffees")
public class CoffeeController {

    @PostMapping
    public String postCoffee(@RequestParam("engName") String engName,
                             @RequestParam("korName") String korName,
                             @RequestParam("price") int price) {
        System.out.println("# engName = " + engName);
        System.out.println("# korName = " + korName);
        System.out.println("# price = " + price);

        String response =
                "{\"" +
                        "engName\":\"" + engName + "\"," +
                        "\"korName\":\"" + korName + "\",\"" +
                        "price\":\"" + price +
                        "\"}";
        return response;
    }

    @RequestMapping("/{coffee-id}")
    public String getCoffee(@PathVariable("coffee-id") long coffeeId) {
        System.out.println("# coffeeId = " + coffeeId);

        return null;
    }

    @RequestMapping
    public String getCoffees() {
        System.out.println("CoffeeController.getCoffees");
        return null;
    }
}
