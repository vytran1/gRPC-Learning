package section2;

import com.vytran.models.sec02.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProtoDemo {


    private static final Logger log = LoggerFactory.getLogger(ProtoDemo.class);

    public static void main(String[] args) {
       var person1 = createPerson();

       var person2 = createPerson();

       log.info("equals {}",person1.equals(person2));

       log.info("name of person1 {}",person1.getName());
       log.info("name of person2 {}",person2.getName());


       Person person3 = person1.toBuilder().setName("VyTranNguyen").build();


       log.info("equals {}",person3 == person1);
       log.info("equals {}",person3.equals(person1));


       log.info("person1 {}", person1.toString());

       Person person4 = person1.toBuilder().clearName().build();

       log.info("person4 {}", person4.toString());



    }


    private static Person createPerson(){
        return Person.newBuilder().setName("TranNguyenVy").setAge(21).build();
    }

}
