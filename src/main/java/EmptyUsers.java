import java.util.Collections;
import java.util.List;

public class EmptyUsers implements Users {
    @Override
    public List<User> all() {
        return Collections.emptyList();
    }
}