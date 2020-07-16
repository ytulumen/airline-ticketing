package com.finartz.demo.airlineticketing.controller;

import com.finartz.demo.airlineticketing.model.BaseModel;
import com.finartz.demo.airlineticketing.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

public abstract class BaseController<T extends BaseModel> {

    @Autowired
    protected BaseService<T> service;

    @PostMapping(path = "/save", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public T save(@RequestBody T object) {
        return service.save(object);
    }

    @GetMapping(path = "/findById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public T findById(@PathVariable("id") final Long id) {
        Optional<T> optional = service.findById(id);

        if (optional.isPresent()) {
            return optional.get();
        }
        System.out.println("exceptiooon");
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Object not found with id: ");
    }
}
