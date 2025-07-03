package section4;

import com.vytran.models.sec04.PersonOuterClass;
import com.vytran.models.sec04.common.AddressOuterClass;
import com.vytran.models.sec04.common.BodyStyle;
import com.vytran.models.sec04.common.Car;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Lec01Import {


    private static final Logger log = LoggerFactory.getLogger(Lec01Import.class);


    public static void main(String[] args) {
        var address = AddressOuterClass.Address.newBuilder().setCity("BienHoa").build();
        var car = Car.newBuilder().setBodyStyle(BodyStyle.COUPE).build();
        var person = PersonOuterClass.Person.newBuilder()
                .setName("TranNguyenVy")
                .setAge(21)
                .setCar(car)
                .setAddress(address)
                .setCar(car)
                .build()
                ;


        log.info("{}",person);

    }
}
