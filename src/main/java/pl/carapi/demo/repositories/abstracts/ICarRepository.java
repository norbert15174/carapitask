package pl.carapi.demo.repositories.abstracts;

import pl.carapi.demo.models.Car;

import java.util.List;
import java.util.Optional;

public interface ICarRepository {

    Car addCar(Car car);

    Car updateCar(Car update);

    void deleteCar(Long id);

    Optional <Car> getCar(Long id);

    List <Car> getCars();

}
