package pl.carapi.demo.repositories;

import org.springframework.stereotype.Repository;
import pl.carapi.demo.models.Car;
import pl.carapi.demo.models.enums.Color;
import pl.carapi.demo.repositories.abstracts.ICarRepository;

import java.util.*;

@Repository
public class CarRepository implements ICarRepository {

    private Map <Long, Car> cars = new HashMap <>();
    private Long counter = 0L;

    public CarRepository() {
        Car carFirst = new Car(increment() , "Nissan" , "QASHQAI" , Color.BLUE);
        Car carSecond = new Car(increment() , "Vauxhall" , "MOKKA" , Color.YELLOW);
        Car carThird = new Car(increment() , "Renault" , "CAPTUR" , Color.GREEN);
        cars.put(carFirst.getId() , carFirst);
        cars.put(carSecond.getId() , carSecond);
        cars.put(carThird.getId() , carThird);
    }

    @Override
    public Car addCar(Car car) {
        car.setId(increment());
        cars.put(car.getId() , car);
        return car;
    }

    @Override
    public Car updateCar(Car update) {
        cars.remove(update.getId());
        cars.put(update.getId() , update);
        return update;
    }

    @Override
    public void deleteCar(Long id) {
        cars.remove(id);
    }

    @Override
    public Optional <Car> getCar(Long id) {
        return Optional.ofNullable(cars.get(id));
    }

    @Override
    public List <Car> getCars() {
        return new ArrayList <>(cars.values());
    }

    private Long increment() {
        return ++counter;
    }


}
