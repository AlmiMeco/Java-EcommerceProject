package category;

import java.time.LocalDateTime;
import java.util.UUID;

public class SkinCare extends CategoryParent{


    public SkinCare(UUID id, String name) {
        super(id, name);
    }

    @Override
    public LocalDateTime calcDeliveryDate() {

        return LocalDateTime.now().plusHours(3);

    }


}
