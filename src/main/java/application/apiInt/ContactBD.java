package application.apiInt;

import java.util.List;

public interface ContactBD<T> {

    T select(Object obj, int id);
    List<T> selectList(Object obj, int id);
    Boolean delete(Object obj, int id);
    T create(Object obj);
    T update(Object obj);
}
