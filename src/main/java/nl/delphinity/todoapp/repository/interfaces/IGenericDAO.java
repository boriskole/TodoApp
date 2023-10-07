package nl.delphinity.todoapp.repository.interfaces;

import java.io.Serializable;
import java.util.Optional;
import java.util.Set;

public interface IGenericDAO<T, ID extends Serializable> {

    Optional<T> findById(ID id);

    Set<T> findAll();

    T save(T entity);

    Set<T> saveAll(Set<T> entities);

    void delete(T entity);

    void deleteById(ID id);

}
