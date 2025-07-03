package common;

import io.grpc.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import section6.BankService;

import java.io.IOException;
import java.util.Arrays;

public class GrpcServer {

    private static final Logger log = LoggerFactory.getLogger(GrpcServer.class);
    private final Server server;

    private GrpcServer(Server server){
        this.server = server;
    }

    public static GrpcServer create(BindableService... services){
        return createServer(6556,services);
    }

    public static GrpcServer createServer(int port, BindableService... services){
        ServerBuilder<?> serverBuilder = ServerBuilder.forPort(port);
        Arrays.asList(services).forEach(serverBuilder::addService);
        return new GrpcServer(serverBuilder.build());
    }

    public GrpcServer start(){
        var services = this.server.getServices()
                .stream()
                .map(ServerServiceDefinition::getServiceDescriptor)
                .map(ServiceDescriptor::getName)
                .toList();

        try {
            server.start();
            log.info("server started, listened on port {}, services {}",server.getPort(),services);
            return this;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void await(){
        try {
            server.awaitTermination();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void stop(){
        server.shutdownNow();
        log.info("Server Stopped");
    }

}
