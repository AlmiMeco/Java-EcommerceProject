package category;

import java.time.LocalDateTime;
import java.util.UUID;

public class Furniture extends CategoryParent{


    public Furniture(UUID id, String name) {
        super(id, name);
    }


    @Override
    public LocalDateTime calcDeliveryDate() {

        return LocalDateTime.now().plusDays(1);

    }

    @Override
    public String generateCategoryCode() {
        return super.generateCategoryCode();
    }
}
