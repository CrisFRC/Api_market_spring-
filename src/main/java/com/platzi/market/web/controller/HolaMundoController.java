package com.platzi.market.web.controller;

import org.springframework.web.bind.annotation.*;
;

@RestController
@RequestMapping("/sayHello")
public class HolaMundoController {

    @GetMapping("/hola")
    public String sayHello(){
        return "Hola";
    }
}
