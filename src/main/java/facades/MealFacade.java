package facades;

import dataFetcher.DataFetcher;
import dtos.CombinedFoodAndDrinkDTO;
import dtos.DrinkDTO;
import dtos.FoodDTO;

public class MealFacade {
    private static MealFacade instance;
    String drinkUrl = "https://api.punkapi.com/v2/beers/random";
    String foodUrl = "https://www.themealdb.com/api/json/v1/1/random.php";

    public static MealFacade getInstance() {
        if(instance == null) {
            instance = new MealFacade();
        }
        return instance;
    }

    public DrinkDTO getDrink () throws Exception {

        DataFetcher dataFetcher = new DataFetcher<DrinkDTO[]>(drinkUrl, DrinkDTO[].class);

        DrinkDTO[] drinkDTOS = (DrinkDTO[]) dataFetcher.call();
        return drinkDTOS[0];
    }

    public FoodDTO getFood () throws Exception {
        DataFetcher dataFetcher = new DataFetcher<FoodDTO>(foodUrl, FoodDTO.class);

        FoodDTO foodDTO = (FoodDTO) dataFetcher.call();
        return foodDTO;
    }

    public CombinedFoodAndDrinkDTO combinedMeal () throws Exception {
        DrinkDTO drinkDTO = getDrink();
        FoodDTO foodDTO = getFood();

        CombinedFoodAndDrinkDTO combinedFoodAndDrinkDTO = new CombinedFoodAndDrinkDTO(foodDTO, drinkDTO);

        return combinedFoodAndDrinkDTO;
    }

    public static void main(String[] args) throws Exception {
        MealFacade  instance = getInstance();
        System.out.println(instance.combinedMeal());
    }
}
