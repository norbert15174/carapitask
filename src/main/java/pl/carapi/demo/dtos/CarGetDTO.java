package pl.carapi.demo.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.carapi.demo.models.Car;
import pl.carapi.demo.models.enums.Language;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CarGetDTO {

    private Long id;
    private String make;
    private String model;
    private String color;

    public CarGetDTO(Car car , Language lang) {
        this.id = car.getId();
        this.make = car.getMake();
        this.model = car.getModel();
        this.color = lang.equals(Language.EN) ? car.getEngColorValue() : car.getPlColorValue();
    }
}
