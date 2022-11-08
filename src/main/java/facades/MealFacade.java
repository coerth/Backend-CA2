package facades;

import dataFetcher.DataFetcher;
import dtos.CombinedFoodAndDrinkDTO;
import dtos.DrinkDTO;
import dtos.FoodDTO;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

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
        ExecutorService executorService = Executors.newCachedThreadPool();
        DataFetcher drinkFetcher = new DataFetcher<DrinkDTO[]>(drinkUrl, DrinkDTO[].class);
        DataFetcher foodFetcher = new DataFetcher<FoodDTO>(foodUrl, FoodDTO.class);


        Future<DrinkDTO[]> drinkDTOFuture = executorService.submit(drinkFetcher);
        Future<FoodDTO> foodDTOFuture = executorService.submit(foodFetcher);

        CombinedFoodAndDrinkDTO combinedFoodAndDrinkDTO = new CombinedFoodAndDrinkDTO(foodDTOFuture.get(), drinkDTOFuture.get()[0]);

        return combinedFoodAndDrinkDTO;
    }

}
