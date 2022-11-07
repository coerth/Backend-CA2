package dtos;

public class ExtendedRestaurantDTO {

    private int foodID;
    private String foodName;
    private int drinkID;
    private int drinkName;

    public ExtendedRestaurantDTO(FoodDTO foodDTO,DrinkDTO drinkDTO) {
        this.foodID = foodDTO.getId();
        this.foodName = foodDTO.getName();
        this.drinkID = drinkDTO.getId();
        this.drinkName = drinkDTO.getId();
    }
}
