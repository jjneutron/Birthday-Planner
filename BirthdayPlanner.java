import java.util.*;

public class BirthdayPlanner {
    private ActivityStore activities;
    private CafeStore cafes;
    private RestaurantStore restaurants;

    public BirthdayPlanner(ActivityStore activities, CafeStore cafes, RestaurantStore restaurants) {
        this.activities = activities;
        this.cafes = cafes;
        this.restaurants = restaurants;
    }

    public List<String> generate(String input) {
        List<String> plan = new ArrayList<>();
        char[] chars = input.toLowerCase().toCharArray();
        boolean lastWasEating = false;
        boolean lastWasMain = false;
        boolean restaurantInPlan = false;

        for (char c : chars) {
            if (c == 'a') {
                continue;
            }

            String key = String.valueOf(c);
            String activity;

            if (lastWasMain || !lastWasEating) {
                activity = activities.getRandomItem(key);
                lastWasMain = true;
                lastWasEating = false;
            } else {
                if (!restaurantInPlan) {
                    activity = restaurants.getRandomItem(key);
                    restaurantInPlan = true;
                } else {
                    activity = cafes.getRandomItem(key);
                }
                lastWasMain = false;
                lastWasEating = true;
            }
            if (activity != null) {
                plan.add(activity);
            }
        }
        return plan;
        
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("Usage: java BirthdayPlanner <input>");
            return;
        }

        // Assuming activities files are "activities.txt", "cafes.txt", and "restaurants.txt"
        try {
            ActivityStore mainActivities = new ActivityStore("main-activities.txt");
            CafeStore cafes = new CafeStore("cafes.txt");
            RestaurantStore restaurants = new RestaurantStore("restaurants.txt");

            BirthdayPlanner planner = new BirthdayPlanner(mainActivities, cafes, restaurants);
            List<String> itinerary = planner.generate(args[0]);
            for (String activity : itinerary) {
                System.out.println(activity);
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }  
}

