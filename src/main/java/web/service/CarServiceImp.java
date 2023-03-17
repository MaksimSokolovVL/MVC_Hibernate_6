package web.service;

import org.springframework.stereotype.Service;
import web.dao.CarsDao;
import web.model.Car;

import java.util.List;

@Service
public class CarServiceImp implements CarService {

    private final CarsDao carsDao;

    public CarServiceImp(CarsDao carsDao) {
        this.carsDao = carsDao;
    }

    @Override
    public List<Car> removeCars(int volume) {
        return carsDao.removeCars(volume);
    }

    @Override
    public List<Car> getAllCars() {
        return carsDao.getAllCars();
    }
}
