import java.io.IOException;

public class CafeStore extends ActivityStore {
    public CafeStore() {
        super();
    }

    public CafeStore(String fileName) throws IOException {
        super(fileName);
    }

    @Override
    public void add(String key, String item) {
        super.add(key, item + "(cafe)");
    }    
        
}