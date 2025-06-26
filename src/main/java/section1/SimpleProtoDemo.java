package section1;

import com.vytran.models.sec01.PersonOuterClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleProtoDemo {


    private static final Logger log = LoggerFactory.getLogger(SimpleProtoDemo.class);

    public static void main(String[] args) {
        PersonOuterClass.Person tranNguyenVy = PersonOuterClass
                .Person
                .newBuilder()
                .setName("TranNguyenVy")
                .setAge(21)
                .build();

        log.info("{}",tranNguyenVy);
    }
}
