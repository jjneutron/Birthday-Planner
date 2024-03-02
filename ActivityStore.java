import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class ActivityStore {
    private Map<String, List<String>> activityStore;

    public ActivityStore() {
        activityStore = new HashMap<>();
    }
      
    public ActivityStore(String fileName) throws IOException {
        activityStore = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.isEmpty()) {
                    String key = line.substring(0, 1).toLowerCase();
                    String item = line.trim();
                    if (!activityStore.containsKey(key)) {
                        activityStore.put(key, new ArrayList<>());
                    }
                    activityStore.get(key).add(item);
                }
            }
        }
        
    }

    public void add(String key, String item) {
        key = key.toLowerCase();
        item = item.toLowerCase();
        List<String> items = activityStore.get(key);
        if (items == null) {
            items = new ArrayList<>();
            activityStore.put(key, items);
        }
        items.add(item);
    }

    public String getRandomItem(String key) {
        key = key.toLowerCase();
        List<String> items = activityStore.get(key);
        if (items == null || items.isEmpty()) {
            return null;
        }
        Random random = new Random();
        String randomActivity = items.get(random.nextInt(items.size()));
        return key.substring(0, 1).toUpperCase() + key.substring(1) + randomActivity.substring(key.length());

    }
}
