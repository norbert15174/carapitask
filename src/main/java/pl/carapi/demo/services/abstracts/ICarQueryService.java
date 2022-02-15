package pl.carapi.demo.services.abstracts;

import org.springframework.http.ResponseEntity;
import pl.carapi.demo.dtos.CarGetDTO;

import java.util.List;

public interface ICarQueryService {

    ResponseEntity <CarGetDTO> getCarById(Long id , String lang);

    ResponseEntity <List <CarGetDTO>> getCars(String lang);

}
