package section6;

import com.vytran.models.sec06.AccountBalance;
import com.vytran.models.sec06.BalanceCheckRequest;
import com.vytran.models.sec06.BankServiceGrpc;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class GrpcClient {


    private static final Logger log = LoggerFactory.getLogger(GrpcClient.class);

    public static void main(String[] args) throws InterruptedException {

        var channel = ManagedChannelBuilder.forAddress("localhost",6556)
                .usePlaintext()
                .build();


        var stub = BankServiceGrpc.newStub(channel);

//        var stub = BankServiceGrpc.newBlockingStub(channel);

//            var stub = BankServiceGrpc.newFutureStub(channel);
//
//            stub.getAccountBalance()

        stub.getAccountBalance(BalanceCheckRequest.newBuilder().setAccountNumber(2).build(), new StreamObserver<AccountBalance>() {
            @Override
            public void onNext(AccountBalance accountBalance) {
                log.info("{}",accountBalance);
            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onCompleted() {
                log.info("completed");
            }
        });


        log.info("done");
        Thread.sleep(2000l);


    }
}
