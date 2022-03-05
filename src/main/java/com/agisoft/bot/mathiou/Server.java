package com.agisoft.bot.mathiou;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Server {


    private ExecutorService executor = Executors.newFixedThreadPool(2);
    private ProducerThread producer;
    private ConsumerThread consumer;

    public Server(final ManagementConsole console, final String serverId) {
        this.producer = new ProducerThread(console, serverId);
        this.consumer = new ConsumerThread(serverId);
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

    public void offer(final String msg) {
        consumer.offer(msg);
    }
}
