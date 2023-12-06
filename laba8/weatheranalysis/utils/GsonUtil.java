import com.google.gson.Gson;

public class GsonUtil {

    private static final Gson gson = new Gson();

    public static String convertObjectToJson(Object object) {
        return gson.toJson(object);
    }

    public static <T> T convertJsonToObject(String json, Class<T> clazz) {
        return gson.fromJson(json, clazz);
    }
}