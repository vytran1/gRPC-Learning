package section6;

import com.vytran.models.sec06.AccountBalance;
import com.vytran.models.sec06.BalanceCheckRequest;
import com.vytran.models.sec06.GetAllBankAccountRequest;
import com.vytran.models.sec06.GetAllBankAccountResult;
import common.ResponseObserver;
import io.grpc.stub.StreamObserver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CountDownLatch;

public class Lec02UnaryAsyncClientTest extends AbstractTest{


    private static final Logger log = LoggerFactory.getLogger(Lec02UnaryAsyncClientTest.class);


    @Test
    public void getBalanceTest() throws InterruptedException {
        var request = BalanceCheckRequest.newBuilder().setAccountNumber(2).build();
//        var latch = new CountDownLatch(1);

//        this.asyncStub.getAccountBalance(request, new StreamObserver<AccountBalance>() {
//            @Override
//            public void onNext(AccountBalance accountBalance) {
//                log.info("async balance receive {}",accountBalance);
//                latch.countDown();
//            }
//
//            @Override
//            public void onError(Throwable throwable) {
//
//            }
//
//            @Override
//            public void onCompleted() {
//
//            }
//        });
//        latch.await();

        var observer = ResponseObserver.<AccountBalance>create();
        this.asyncStub.getAccountBalance(request,observer);

        observer.await();
        Assertions.assertEquals(1,observer.getItems().size());

    }


    @Test
    public void getAllAccountTest(){
        var observer = ResponseObserver.<GetAllBankAccountResult>create();
        this.asyncStub.getAllAccount(GetAllBankAccountRequest.newBuilder().build(),observer);
        observer.await();
    }

}
