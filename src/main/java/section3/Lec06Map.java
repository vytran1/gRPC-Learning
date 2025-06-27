package section3;

import com.vytran.models.sec03.BodyStyle;
import com.vytran.models.sec03.Car;
import com.vytran.models.sec03.Dealer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class Lec06Map {


    private static final Logger log = LoggerFactory.getLogger(Lec06Map.class);

    public static void main(String[] args) {
        var car1 = Car.newBuilder()
                .setMake("Honda")
                .setModel("Civic")
                .setYear(2020)
                .setBodyStyle(BodyStyle.SEDAN)
                .build();

        var car2 = Car.newBuilder()
                .setMake("Mercedes")
                .setModel("GLC")
                .setYear(2025)
                .setBodyStyle(BodyStyle.COUPE)
                .build();

        var dealer = Dealer.newBuilder()
                .putInventory(car1.getYear(),car1)
                .putInventory(car2.getYear(),car2)
                .build();

        log.info("{}",dealer);


    }
}
