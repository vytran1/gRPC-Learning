package section3;

import com.vytran.models.sec03.PersonOuterClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Lec01Scalar {


    private static final Logger log = LoggerFactory.getLogger(Lec01Scalar.class);

    public static void main(String[] args) {
        PersonOuterClass.Person person1 = PersonOuterClass.Person
                .newBuilder()
                .setLastName("TranNguyenVy")
                .setEmail("trannguyenvy@gmail.com")
                .setEmployed(true)
                .setSalary(100000)
                .setBankAccountNumber(3123124124124l)
                .setBalance(-10000)
                .build();


        log.info("person {}",person1.toString());

    }

}
