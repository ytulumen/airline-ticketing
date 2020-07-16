package com.finartz.demo.airlineticketing.service;

import com.finartz.demo.airlineticketing.model.BaseModel;
import com.finartz.demo.airlineticketing.repository.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public abstract class BaseService<T extends BaseModel> {
    @Autowired
    protected BaseRepository<T> repository;

    @Transactional
    public T save(T object) {
        return repository.save(object);
    }

    public Optional<T> findById(Long id) {
        return repository.findById(id);
    }

    public void deleteById(long id) {
        repository.deleteById(id);
    }
}
