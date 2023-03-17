package web.service;

import web.model.Car;

import java.util.List;

public interface CarService {
    List<Car> removeCars(int volume);
    List<Car> getAllCars();
}
