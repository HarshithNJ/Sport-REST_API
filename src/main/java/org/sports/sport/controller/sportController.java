package org.sports.sport.controller;

import org.sports.sport.service.sportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class sportController {

    @Autowired
    sportService service;
    
}
