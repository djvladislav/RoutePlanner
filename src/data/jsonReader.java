package data;

import com.google.gson.Gson;
import java.io.FileReader;
// i will be using gson lib for json ops
public class jsonReader {
    public static City readCity(String filePath) {
        try (FileReader reader = new FileReader(filePath)) {
            Gson gson = new Gson();
            return gson.fromJson(reader, City.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
