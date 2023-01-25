package category;

import java.time.LocalDateTime;
import java.util.UUID;

public class Electronic extends CategoryParent{


    public Electronic(UUID id, String name) {
        super(id, name);
    }

    @Override
    public LocalDateTime calcDeliveryDate() {

        return LocalDateTime.now().plusDays(4);

    }

    @Override
    public String generateCategoryCode() {
        return "EL-" + getId().toString().substring(0,8);
    }


}
