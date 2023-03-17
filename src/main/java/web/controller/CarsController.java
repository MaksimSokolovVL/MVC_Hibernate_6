package web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarServiceImp;

import java.util.List;

// TODO: 17.03.2023 первая версия с @RequestMapping(value = "/cars")
/*
@Controller
@RequestMapping(value = "/cars")
public class CarsController {

    private final RemoveCarService carService;

    @Autowired
    public CarsController(RemoveCarService carService) {
        this.carService = carService;
    }


//    @GetMapping("/{countCars}")
//    public String getCars(@PathVariable int countCars, Model model){
//
//        List<Car> cars = carService.removeCars(countCars);
//        model.addAttribute("cars", cars);
//        return "cars";
//    }

    @GetMapping
    public String getCars(@RequestParam(required = false) Integer countCars, Model model) {

        List<Car> cars = countCars == null || countCars >= carService.getAllCars().size()
        ? carService.getAllCars() : carService.removeCars(countCars);

        model.addAttribute("cars", cars);
        return "cars";
    }
}
*/
@Controller
public class CarsController {

    private final CarServiceImp carServiceImp;

    public CarsController(CarServiceImp carServiceImp) {
        this.carServiceImp = carServiceImp;
    }

    @GetMapping("/cars")
    public String getCars(@RequestParam(name = "count", required = false) Integer countCars, Model model) {
        List<Car> cars = carServiceImp.getAllCars();
        int maxCount = cars.size();
        if (countCars == null || countCars > maxCount) {
            countCars = maxCount;
        } else if (countCars < 0) {
            countCars = 0;
        }

        model.addAttribute("cars", cars.subList(0, countCars));
        model.addAttribute("maxCount", maxCount);
        model.addAttribute("selectedCount", countCars);
        return "cars";
    }
}
