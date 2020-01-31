package org.qasimovey.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = {"/api/public"})
public class PublicAPI {

    @GetMapping
    public String getMessage(){
        return "This is public API , no need for authentication";
    }
}
