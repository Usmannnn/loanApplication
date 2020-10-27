package com.koc.application.loan.controller;

import com.koc.application.loan.dao.Connection;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public void getPerson(){
        Connection connection = new Connection();
    }
}
