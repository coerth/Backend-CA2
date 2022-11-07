package dataFetcher;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.DrinkDTO;
import dtos.FoodDTO;
import dtos.RestaurantDto;
import utils.HttpUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;

public class MenuFetcher {


   /* Gson gson = new GsonBuilder().setPrettyPrinting().create();
    public String getMenuSequential() throws IOException {



        ChuckDTO chuckDTO = gson.fromJson(chuck, ChuckDTO.class);
        DadDTO dadDTO = gson.fromJson(dad, DadDTO.class);

        CombinedDTO combinedDTO = new CombinedDTO(chuckDTO,dadDTO);

        String combinedJson = gson.toJson(combinedDTO);


        return combinedJson;
    }*/

    public static void main(String[] args) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        MenuFetcher menuFetcher = new MenuFetcher();
       FoodDTO foodDTO = gson.fromJson(menuFetcher.getFoodDTOS(),FoodDTO.class);
    }


    public Set<FoodDTO> getFoodDTOS(Set<RestaurantDto.InnerFoodDto> innerFoodDtos) {
        Set<FoodDTO> foodDTOS = new LinkedHashSet<>();

        ExecutorService executorService = Executors.newFixedThreadPool(8);

        for (RestaurantDto.InnerFoodDto innerFoodDto : innerFoodDtos) {
            FoodGetter foodGetter = new FoodGetter(innerFoodDto.getId());
            Future<FoodDTO> foodDTOFuture = executorService.submit(foodGetter);
            try {
                foodDTOS.add(foodDTOFuture.get());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        return foodDTOS;
    }

    public Set<DrinkDTO> getDrinkDTOS(Set<RestaurantDto.InnerDrinkDto> innerDrinkDtos) {

        Set<DrinkDTO> drinkDTOS = new LinkedHashSet<>();

        ExecutorService executorService = Executors.newFixedThreadPool(8);

        for (RestaurantDto.InnerDrinkDto innerDrinkDto : innerDrinkDtos) {
            DrinkGetter drinkGetter = new DrinkGetter(innerDrinkDto.getId());
            Future<DrinkDTO> drinkDTOFuture = executorService.submit(drinkGetter);
            try {
                drinkDTOS.add(drinkDTOFuture.get());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return drinkDTOS;
    }

}
