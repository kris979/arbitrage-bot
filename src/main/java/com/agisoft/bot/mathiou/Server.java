package com.agisoft.bot.mathiou;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Server {

    private ExecutorService executor = Executors.newFixedThreadPool(2);
    private ProducerThread producer;
    private ConsumerThread consumer;
    private ManagementConsole console;
    private String serverId;

    public Server(final ManagementConsole console, final String serverId) {
        this.console = console;
        this.serverId = serverId;
        this.producer = new ProducerThread(console, serverId);
        this.consumer = new ConsumerThread(console, serverId);
    }

    public void start() {
        executor.execute(producer);
        executor.execute(consumer);
    }

    public void stop() {
        consumer.stop();
        executor.shutdown();
        try {
            if (!executor.awaitTermination(800, TimeUnit.MILLISECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }

    public void receivedMsg(final String msg) {
        System.out.println("Received msg: " + msg);
    }

    public String getServerId() {
        return serverId;
    }
}
