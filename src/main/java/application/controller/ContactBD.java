package application.controller;

import org.springframework.web.bind.annotation.RestController;

import javax.jws.WebService;
import java.util.List;


@RestController
public class ContactBD<T> implements application.apiInt.ContactBD {

    @Override
    public T select(Object obj, int id) {
        return null;
    }

    @Override
    public List<T> selectList(Object obj, int id) {
        return null;
    }

    @Override
    public Boolean delete(Object obj, int id) {
        return null;
    }

    @Override
    public Object create(Object obj) {
        return null;
    }

    @Override
    public T update(Object obj) {
        return null;
    }
}
