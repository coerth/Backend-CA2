package dataFetcher;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.FoodDTO;
import utils.HttpUtils;

import java.util.concurrent.Callable;

public class FoodGetter implements Callable<FoodDTO> {
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    /*int id = 0;
    public FoodGetter(int id) {
        this.id = id;
    }*/

    public FoodGetter() {
    }

    @Override
    public FoodDTO call() throws Exception {

        String food = HttpUtils.fetchData("https://www.themealdb.com/api/json/v1/1/random.php");

        return gson.fromJson(food, FoodDTO.class);

    }
}
