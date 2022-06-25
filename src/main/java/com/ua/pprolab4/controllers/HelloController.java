package com.ua.pprolab4.controllers;

import com.ua.pprolab4.models.Message;
import com.ua.pprolab4.services.MessageService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/app")
public class HelloController {

    private final MessageService messageService;

    public HelloController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping("/greet")
    public String greetUser() {
        return "Greeting, user!";
    }

    @PostMapping("/saveMessage")
    public Message saveMessage(@RequestBody Message message) {
        System.out.println(message);
        return messageService.saveMessage(message);
    }

    @GetMapping("/getMessage/{id}")
    @ResponseBody
    public Message getMessage(@PathVariable("id") Long id) {
        return messageService.findMessageById(id);
    }
}
