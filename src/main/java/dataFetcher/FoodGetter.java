package dataFetcher;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.FoodDTO;
import utils.HttpUtils;

import java.util.concurrent.Callable;

public class FoodGetter implements Callable {
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    int id = 0;
    public FoodGetter(int id) {
        this.id = id;
    }

    @Override
    public Object call() throws Exception {

        return gson.fromJson(HttpUtils.fetchData("www.themealdb.com/api/json/v1/1/lookup.php?i="+id), FoodDTO.class);

    }
}
