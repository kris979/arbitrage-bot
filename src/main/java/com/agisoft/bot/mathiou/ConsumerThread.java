package com.agisoft.bot.mathiou;

import lombok.SneakyThrows;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

public class ConsumerThread implements Runnable {

    private Queue<String> msgs = new ConcurrentLinkedDeque<>();
    private boolean running = true;
    private String serverId;

    public ConsumerThread(final String serverId) {
        this.serverId = serverId;
    }

    public void stop() {
        running = false;
    }

    @Override
    public void run() {
        System.out.println("Server: " + serverId + " Consumer thread: " +Thread.currentThread().getName() + " started successfully.");
        while(running) {
            final String msg = msgs.poll();
            if (msg != null) {
                System.out.println("Server: " + serverId + " received: " + msg);
            }
        }
    }

    public void offer(final String msg) {
        msgs.offer(msg);
    }
}
