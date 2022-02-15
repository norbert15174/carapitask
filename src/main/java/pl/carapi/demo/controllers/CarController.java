package pl.carapi.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.carapi.demo.dtos.CarGetDTO;
import pl.carapi.demo.services.abstracts.ICarQueryService;

import java.util.List;

@RestController
@RequestMapping("/car")
public class CarController {

    private final ICarQueryService carQueryService;

    @Autowired
    public CarController(ICarQueryService carQueryService) {
        this.carQueryService = carQueryService;
    }

    @GetMapping
    public ResponseEntity <CarGetDTO> getCar(@RequestParam Long carId , @RequestParam(required = false) String lang) {
        return carQueryService.getCarById(carId , lang);
    }

    @GetMapping("/all")
    public ResponseEntity <List <CarGetDTO>> getCars(@RequestParam(required = false) String lang) {
        return carQueryService.getCars(lang);
    }

}
