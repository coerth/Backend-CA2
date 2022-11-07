package dataFetcher;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.DrinkDTO;
import dtos.FoodDTO;
import utils.HttpUtils;

import java.util.concurrent.Callable;

public class DrinkGetter implements Callable {

    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    int id = 0;
    public DrinkGetter(int id) {
        this.id = id;
    }

    @Override
    public Object call() throws Exception {
        return gson.fromJson(HttpUtils.fetchData("https://api.punkapi.com/v2/beers/"+id), DrinkDTO.class);
    }
}
