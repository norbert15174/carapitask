package pl.carapi.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pl.carapi.demo.dtos.CarGetDTO;
import pl.carapi.demo.models.Car;
import pl.carapi.demo.models.enums.Language;
import pl.carapi.demo.repositories.abstracts.ICarRepository;
import pl.carapi.demo.services.abstracts.ICarCreateUpdateService;
import pl.carapi.demo.services.abstracts.ICarDeleteService;
import pl.carapi.demo.services.abstracts.ICarQueryService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarService implements ICarCreateUpdateService, ICarQueryService, ICarDeleteService {

    private final ICarRepository carRepository;

    @Autowired
    public CarService(ICarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public ResponseEntity <CarGetDTO> getCarById(Long id , String lang) {
        return carRepository.getCar(id)
                .map(car -> getResponseWithSelectedCar(car , lang))
                .orElse(ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity <List <CarGetDTO>> getCars(String lang) {
        return new ResponseEntity(mapAllCars(Language.getLanguage(lang)) , HttpStatus.OK);
    }

    private ResponseEntity <CarGetDTO> getResponseWithSelectedCar(Car car , String lang) {
        return new ResponseEntity <>(new CarGetDTO(car , Language.getLanguage(lang)) , HttpStatus.OK);
    }

    private List <CarGetDTO> mapAllCars(Language lang) {
        return carRepository.getCars()
                .stream()
                .map(car -> new CarGetDTO(car , lang))
                .collect(Collectors.toList());
    }
}
