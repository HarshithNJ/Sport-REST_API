package org.sports.sport.service;

import org.sports.sport.repositories.sportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class sportService {

    @Autowired
    sportRepository repostiory;
    
}
