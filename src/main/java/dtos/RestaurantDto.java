package dtos;

import entities.Drink;
import entities.Food;
import entities.Restaurant;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

/**
 * A DTO for the {@link Restaurant} entity
 */
public class RestaurantDto implements Serializable {
    private final Integer id;
    @Size(max = 45)
    @NotNull
    private final String name;
    @NotNull
    private final Integer zip;
    private final Set<InnerDrinkDto> drinks;
    private final Set<InnerFoodDto> foods;

    public RestaurantDto(Integer id, String name, Integer zip, Set<InnerDrinkDto> drinks, Set<InnerFoodDto> foods) {
        this.id = id;
        this.name = name;
        this.zip = zip;
        this.drinks = drinks;
        this.foods = foods;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getZip() {
        return zip;
    }

    public Set<InnerDrinkDto> getDrinks() {
        return drinks;
    }

    public Set<InnerFoodDto> getFoods() {
        return foods;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RestaurantDto entity = (RestaurantDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.name, entity.name) &&
                Objects.equals(this.zip, entity.zip) &&
                Objects.equals(this.drinks, entity.drinks) &&
                Objects.equals(this.foods, entity.foods);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, zip, drinks, foods);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "name = " + name + ", " +
                "zip = " + zip + ", " +
                "drinks = " + drinks + ", " +
                "foods = " + foods + ")";
    }

    /**
     * A DTO for the {@link Drink} entity
     */
    public static class InnerDrinkDto implements Serializable {
        private final Integer id;

        public InnerDrinkDto(Integer id) {
            this.id = id;
        }

        public Integer getId() {
            return id;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            InnerDrinkDto entity = (InnerDrinkDto) o;
            return Objects.equals(this.id, entity.id);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id);
        }

        @Override
        public String toString() {
            return getClass().getSimpleName() + "(" +
                    "id = " + id + ")";
        }
    }

    /**
     * A DTO for the {@link Food} entity
     */
    public static class InnerFoodDto implements Serializable {
        private final Integer id;

        public InnerFoodDto(Integer id) {
            this.id = id;
        }

        public Integer getId() {
            return id;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            InnerFoodDto entity = (InnerFoodDto) o;
            return Objects.equals(this.id, entity.id);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id);
        }

        @Override
        public String toString() {
            return getClass().getSimpleName() + "(" +
                    "id = " + id + ")";
        }
    }
}