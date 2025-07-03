package section6;

import com.vytran.models.sec06.BalanceCheckRequest;
import com.vytran.models.sec06.GetAllBankAccountRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Lec01UnaryBlockingClientTest extends AbstractTest{


    private static final Logger log = LoggerFactory.getLogger(Lec01UnaryBlockingClientTest.class);

    @Test
    public void getBalanceTest(){
        var request = BalanceCheckRequest
                .newBuilder()
                .setAccountNumber(1)
                .build();

        var balance = this.blockingStub.getAccountBalance(request);
        log.info("Unary Balance {}",balance.getBalance());
        Assertions.assertEquals(100,balance.getBalance());
    }


    @Test
    public void getAllAccountTest(){
        var request = GetAllBankAccountRequest.newBuilder().build();

        var response = this.blockingStub.getAllAccount(request);
        log.info("Response {}",response);

    }


}
