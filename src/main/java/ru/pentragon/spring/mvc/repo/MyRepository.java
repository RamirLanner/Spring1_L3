package ru.pentragon.spring.mvc.repo;

import ru.pentragon.spring.mvc.model.Product;

import java.util.List;

public interface MyRepository {

    List<Product> getProductList();

    void add(Product product);

    void updateRecordByID(long id, String newTitle, float newCost);

    Product getByID(long id);

    void deleteRecordByID(long id);

}
