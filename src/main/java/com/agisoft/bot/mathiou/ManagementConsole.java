package com.agisoft.bot.mathiou;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentLinkedDeque;

public enum ManagementConsole {

    CONSOLE;

    private List<Server> servers = new ArrayList<>();
    private Queue<String> msgs = new ConcurrentLinkedDeque<>();
    public static final int MAX_MSGS_TO_SEND = 10;

    public void addServer(Server server) {
        servers.add(server);
    }

    private void startAll() {
        for (Server server : servers) {
            server.start();
        }
    }

    public void stopAll() {
        for (Server server : servers) {
            server.stop();
        }
    }

    public void sendMsg(final String msg) {
        msgs.offer(msg);
    }

    public String receivedMsg() {
        System.out.println("Msgs left:" + msgs.size() );
        return msgs.element();
    }

    public static void main(String[] args) throws InterruptedException {
        ManagementConsole console = ManagementConsole.CONSOLE;

        Server server1 = new Server(console, "1");
        Server server2 = new Server(console, "2");
        console.addServer(server1);
        console.addServer(server2);
        console.startAll();
        console.stopAll();
        System.out.println("Simulation Terminated Successfully.");
    }

}
