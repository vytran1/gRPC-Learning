package section3;

import com.vytran.models.sec03.Credentials;
import com.vytran.models.sec03.Email;
import com.vytran.models.sec03.Phone;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Lec08OneOf {


    private static final Logger log = LoggerFactory.getLogger(Lec08OneOf.class);

    public static void main(String[] args) {

        var email = Email.newBuilder().setAddress("vytran@gmail.com").setPassword("123456789").build();
        var phone = Phone.newBuilder().setNumber(1111).setCode(84).build();


        login(Credentials.newBuilder().setEmail(email).build());
        login(Credentials.newBuilder().setPhone(phone).build());
        login(Credentials.newBuilder().setEmail(email).setPhone(phone).build());


    }

    private static void login(Credentials credentials){
        switch (credentials.getLoginTypeCase()){
            case EMAIL -> log.info("email {}",credentials.getEmail());
            case PHONE -> log.info("phone {}",credentials.getPhone());
        }
    }
}
