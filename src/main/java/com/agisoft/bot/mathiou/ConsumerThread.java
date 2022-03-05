package com.agisoft.bot.mathiou;

public class ConsumerThread implements Runnable {

    private ManagementConsole console;
    private String serverId;
    private boolean running = true;

    public ConsumerThread(final ManagementConsole console, final String serverId) {
        this.console = console;
        this.serverId = serverId;
    }

    public void stop() {
        running = false;
    }

    @Override
    public void run() {
        System.out.println("Server: " + serverId + " Consumer thread: " +Thread.currentThread().getName() + " started successfully.");
        while(running) {
            final String msg = console.receivedMsg();
            if (msg != null) {
                System.out.println("Server: " + serverId + " received: " + msg);
            } else {
                System.out.println("Msg queue is empty");
            }
        }
    }
}
