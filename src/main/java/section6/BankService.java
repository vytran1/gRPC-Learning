package section6;

import com.vytran.models.sec06.*;
import io.grpc.stub.StreamObserver;
import section6.repository.AccountRepository;

import java.util.List;
import java.util.Map;

public class BankService extends BankServiceGrpc.BankServiceImplBase {

    @Override
    public void getAccountBalance(BalanceCheckRequest request, StreamObserver<AccountBalance> responseObserver) {
        var accountNumber = request.getAccountNumber();

        var balanceInRepository = AccountRepository.getBalance(accountNumber);

        var accountBalance = AccountBalance
                .newBuilder()
                .setAccountNumber(accountNumber)
                .setBalance(balanceInRepository)
                .build();
        responseObserver.onNext(accountBalance);
        responseObserver.onCompleted();
    }

    @Override
    public void getAllAccount(GetAllBankAccountRequest request, StreamObserver<GetAllBankAccountResult> responseObserver) {
        Map<Integer,Integer> map = AccountRepository.getAllAccount();

        List<AccountBalance> listOfAllAccount = map.entrySet()
                .stream()
                .map(e -> AccountBalance.newBuilder().setAccountNumber(e.getKey()).setBalance(e.getValue()).build())
                .toList();

        GetAllBankAccountResult response = GetAllBankAccountResult.newBuilder().addAllAccount(listOfAllAccount).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();

    }
}
