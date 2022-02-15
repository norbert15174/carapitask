package pl.carapi.demo.models;

import com.google.common.base.Strings;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.carapi.demo.models.enums.Color;

import java.util.Optional;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Car {

    private Long id;
    private String make;
    private String model;
    private Color color;

    public boolean hasMake() {
        return Strings.isNullOrEmpty(make);
    }

    public boolean hasModel() {
        return Strings.isNullOrEmpty(model);
    }

    public boolean hasColor() {
        return Optional.ofNullable(color).isPresent();
    }

    public String getEngColorValue() {
        return color.getEngValue();
    }

    public String getPlColorValue() {
        return color.getPlValue();
    }

}
