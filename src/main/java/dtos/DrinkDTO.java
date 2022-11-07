package dtos;

import java.util.Objects;

public class DrinkDTO {
    int id;
    String name;

    public DrinkDTO(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DrinkDTO)) return false;
        DrinkDTO drinkDTO = (DrinkDTO) o;
        return getId() == drinkDTO.getId() && getName().equals(drinkDTO.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName());
    }
}
