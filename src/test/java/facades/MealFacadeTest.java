package facades;

import dtos.CombinedFoodAndDrinkDTO;
import dtos.DrinkDTO;
import dtos.FoodDTO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class MealFacadeTest {

    private static MealFacade mealFacade;

    public MealFacadeTest() {

    }

    @BeforeAll
    public static void setUpClass() {
        mealFacade = MealFacade.getInstance();
    }

    @Test
    void getDrinkTest() throws Exception {
        DrinkDTO drinkDTO = mealFacade.getDrink();
        assertNotNull(drinkDTO);
    }

    @Test
    void getFoodTest() throws Exception {
        FoodDTO foodDTO = mealFacade.getFood();
        assertNotNull(foodDTO);
    }

    @Test
    void getCombinedTest () throws Exception {
        CombinedFoodAndDrinkDTO combinedFoodAndDrinkDTO = mealFacade.combinedMeal();

        assertNotNull(combinedFoodAndDrinkDTO);
    }
}
