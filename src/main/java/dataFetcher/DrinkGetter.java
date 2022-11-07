package dataFetcher;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.DrinkDTO;
import dtos.FoodDTO;
import utils.HttpUtils;

import java.util.concurrent.Callable;

public class DrinkGetter implements Callable<DrinkDTO[]> {

    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    /*int id = 0;
    public DrinkGetter(int id) {
        this.id = id;
    }*/

    public DrinkGetter() {
    }

    @Override
    public DrinkDTO[] call() throws Exception {

        String drink = HttpUtils.fetchData("https://api.punkapi.com/v2/beers/random");

        return gson.fromJson(drink, DrinkDTO[].class);
    }
}
