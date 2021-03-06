package ftcApp.service;

import ftcApp.repository.GenericRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

@Service
@Transactional
public class GenericServiceImpl<T, ID extends Serializable> implements GenericService<T, ID> {
    protected GenericRepository<T, ID> repository;

    protected Class<T> entityClass;

    public GenericServiceImpl() { }

    public GenericServiceImpl(GenericRepository<T, ID> repository, Class<T> entityClass) {
        this.repository = repository;
        this.entityClass = entityClass;
    }

    @Override
    public T save(T entity) {
        return repository.save(entity);
    }

    @Override
    public T update(T entity) {
        return repository.update(entity);
    }

    @Override
    public Iterable<T> updateAll(Iterable<T> entities) {
        entities.forEach(repository::update);
        return entities;
    }

    @Override
    public void delete(ID id) {
        repository.delete(id);
    }

    @Override
    public void delete(T entity) {
        repository.delete(entity);
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }

    @Override
    public Iterable<T> findAll() {
        return repository.findAll();
    }

    @Override
    public Iterable<T> findAllAndRefresh() {
        Iterable<T> entities = repository.findAll();
        return repository.refreshAll(entities);
    }

    @Override
    public T findOne(ID id) {
        return repository.findOne(id);
    }

    @Override
    public T findOneAndRefresh(ID id) {
        T entity = repository.findOne(id);
        return repository.refresh(entity);
    }

    @Override
    public boolean exists(ID id) {
        return repository.exists(id);
    }

    @Override
    public long count() {
        return repository.count();
    }
}
