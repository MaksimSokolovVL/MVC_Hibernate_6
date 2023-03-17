package web.dao;

import org.springframework.stereotype.Repository;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CarsDaoImp implements CarsDao {

    private final List<Car> carsList = List.of(
            new Car("Toyota", "Corolla", 1999),
            new Car("Toyota", "Mark", 2001),
            new Car("Toyota", "Camry", 2005),
            new Car("Toyota", "Crown", 2018),
            new Car("Toyota", "Supra", 2003),
            new Car("Toyota", "Celiac", 1998));

    @Override
    public List<Car> removeCars(int volume) {
        return carsList.stream().limit(volume).toList();
    }

    @Override
    public List<Car> getAllCars() {
        return new ArrayList<>(carsList);
    }
}
