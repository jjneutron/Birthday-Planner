import java.io.IOException;

public class RestaurantStore extends ActivityStore {
    public RestaurantStore() {
        super();
    }

    public RestaurantStore(String fileName) throws IOException {
        super(fileName);
    }

    @Override
    public void add(String key, String item) {
        super.add(key, item + "(restaurant)");
    }
}
