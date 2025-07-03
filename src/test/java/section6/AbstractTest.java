package section6;

import com.vytran.models.sec06.BankServiceGrpc;
import common.AbstractChannelTest;
import common.GrpcServer;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public abstract class AbstractTest extends AbstractChannelTest {

    private final GrpcServer grpcServer = GrpcServer.create(new BankService());
    protected BankServiceGrpc.BankServiceStub asyncStub;
    protected BankServiceGrpc.BankServiceBlockingStub blockingStub;


    @BeforeAll
    public void setup(){
        this.grpcServer.start();
        this.asyncStub = BankServiceGrpc.newStub(this.managedChannel);
        this.blockingStub = BankServiceGrpc.newBlockingStub(this.managedChannel);
    }

    @AfterAll
    public void stop(){
        this.grpcServer.stop();
    }

}
