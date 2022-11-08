package dataFetcher;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import utils.HttpUtils;

import java.util.concurrent.Callable;

public class DataFetcher <T> implements Callable<T> {

    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    final String url;
    final Class<T> t;

    public DataFetcher(String url, Class<T> t) {
        this.url = url;
        this.t = t;
    }

    @Override
    public T call() throws Exception {
        String returned = HttpUtils.fetchData(url);

        return (T) gson.fromJson(returned, t);
    }
}
