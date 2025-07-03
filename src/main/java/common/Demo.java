package common;

import section6.BankService;

public class Demo {

    public static void main(String[] args) {
        GrpcServer.create(new BankService())
                .start()
                .await();
    }

}
