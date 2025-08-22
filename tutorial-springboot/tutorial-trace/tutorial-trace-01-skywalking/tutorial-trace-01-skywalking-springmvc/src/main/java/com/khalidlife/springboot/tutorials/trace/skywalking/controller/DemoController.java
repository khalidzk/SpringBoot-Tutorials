package com.khalidlife.springboot.tutorials.trace.skywalking.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * DemoController
 *
 * @author khalid
 */
@RestController
@RequestMapping("/demo")
public class DemoController {

    @GetMapping("/echo")
    public String echo() {
        return "SkyWalking";
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello SkyWalking!";
    }

}
