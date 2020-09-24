package management;

import java.util.List;

public interface IService<T> {
    void add(T object);
    void update(long id,T newObject);
    void delete(long id);
    T findById (long id);
    List<T> findByName (String name);
    List<T> findAll();
}
