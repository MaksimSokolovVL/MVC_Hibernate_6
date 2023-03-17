package web.dao;

import web.model.Car;

import java.util.List;

public interface CarsDao {
    List<Car> removeCars(int volume);
    List<Car> getAllCars();
}
