package com.agisoft.bot.mathiou;

public class ProducerThread implements Runnable {

    private ManagementConsole main;
    private String serverId;

    public ProducerThread(final ManagementConsole main, final String serverId) {
        this.main = main;
        this.serverId = serverId;
    }

    @Override
    public void run() {
        System.out.println("Server: " + serverId + " Producer thread name: " +Thread.currentThread().getName() + " started successfully.");
        Integer i = 0;
        while(i < ManagementConsole.MAX_MSGS_TO_SEND) {
            ++i;
            main.sendMsg("msg from server " + serverId + " : " + i.toString());
        }
        main.stopAll();
    }
}
