import java.io.IOException;

class BirthdayPlannerTest {
    public static void main(String[] args) {
        try {
            ActivityStore activityStore = new ActivityStore("activities.txt");
            CafeStore cafeStore = new CafeStore("cafes.txt");
            RestaurantStore restaurantStore = new RestaurantStore("restaurants.txt");
            assert (activityStore.getRandomItem("a") != null);
            assert (cafeStore.getRandomItem("c").startsWith("C") && cafeStore.getRandomItem("c").endsWith("cafe"));
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}