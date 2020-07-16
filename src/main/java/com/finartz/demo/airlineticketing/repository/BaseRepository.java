package com.finartz.demo.airlineticketing.repository;

import com.finartz.demo.airlineticketing.model.BaseModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public abstract class BaseRepository<T extends BaseModel> implements CrudRepository<T, Long> {

    @PersistenceContext
    protected EntityManager entityManager;

    private Class<T> clazz;

    public abstract Class<T> getClassType();

    public BaseRepository() {
        super();
        clazz = getClassType();
    }

    @Override
    public <S extends T> S save(S s) {
        return entityManager.merge(s);
    }

    @Override
    public <S extends T> Iterable<S> saveAll(Iterable<S> iterable) {
        Iterator<S> iterator = iterable.iterator();
        List<S> savedList = new ArrayList<>();

        while (iterator.hasNext()) {
            savedList.add(save(iterator.next()));
        }

        return savedList;
    }

    @Override
    public Optional<T> findById(Long aLong) {
        return Optional.ofNullable(entityManager.find(clazz, aLong));
    }

    @Override
    public boolean existsById(Long aLong) {
        return entityManager.find(clazz, aLong).getId().equals(aLong);
    }

    @Override
    public Iterable<T> findAll() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = builder.createQuery(clazz);
        Root<T> root = criteriaQuery.from(clazz);
        criteriaQuery.select(root);

        return entityManager.createQuery(criteriaQuery).getResultList();
    }

    @Override
    public Iterable<T> findAllById(Iterable<Long> iterable) {
        return null;
    }

    @Override
    public long count() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> criteriaQuery = criteriaBuilder.createQuery(Long.class);
        criteriaQuery.select(criteriaBuilder.count(criteriaQuery.from(clazz)));
        return entityManager.createQuery(criteriaQuery).getSingleResult();
    }

    @Override
    public void deleteById(Long aLong) {
        delete(entityManager.find(clazz, aLong));
    }

    @Override
    public void delete(T t) {
        entityManager.remove(entityManager.contains(t) ? t : entityManager.merge(t));
    }

    @Override
    public void deleteAll(Iterable<? extends T> iterable) {

    }

    @Override
    public void deleteAll() {

    }
}
