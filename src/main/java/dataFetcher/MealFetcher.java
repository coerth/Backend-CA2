package dataFetcher;

import dtos.CombinedFoodAndDrinkDTO;
import dtos.DrinkDTO;

public class MealFetcher {


    public CombinedFoodAndDrinkDTO combinedMeal() throws Exception {

        DrinkGetter drinkGetter = new DrinkGetter();
        FoodGetter foodGetter = new FoodGetter();
        DrinkDTO[] drinkDTOS = drinkGetter.call();

        try {
            CombinedFoodAndDrinkDTO combinedFoodAndDrinkDTO = new CombinedFoodAndDrinkDTO(foodGetter.call(), drinkDTOS[0]);
            return combinedFoodAndDrinkDTO;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public static void main(String[] args) throws Exception {
        MealFetcher mealFetcher = new MealFetcher();

        System.out.println(mealFetcher.combinedMeal());


    }




   /* Gson gson = new GsonBuilder().setPrettyPrinting().create();
    public String getMenuSequential() throws IOException {



        ChuckDTO chuckDTO = gson.fromJson(chuck, ChuckDTO.class);
        DadDTO dadDTO = gson.fromJson(dad, DadDTO.class);

        CombinedDTO combinedDTO = new CombinedDTO(chuckDTO,dadDTO);

        String combinedJson = gson.toJson(combinedDTO);


        return combinedJson;
    }*/

    /*public static void main(String[] args) {
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
    }*/

}
