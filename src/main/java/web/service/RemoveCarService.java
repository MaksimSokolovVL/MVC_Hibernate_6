package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.List;

@Service
public class RemoveCarService {

    private final List<Car> carsList = List.of(
            new Car("Toyota", "Corolla", 1999),
            new Car("Toyota", "Mark", 2001),
            new Car("Toyota", "Camry", 2005),
            new Car("Toyota", "Crown", 2018),
            new Car("Toyota", "Supra", 2003),
            new Car("Toyota", "Celiac", 1998));

    public List<Car> removeCars(int volume) {
        return carsList.stream().limit(volume).toList();
    }

    public List<Car> getAllCars() {
        return carsList;
    }
}
