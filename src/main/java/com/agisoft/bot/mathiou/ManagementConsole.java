package com.agisoft.bot.mathiou;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

public class ManagementConsole {

    public static final int MAX_MSGS_TO_SEND = 10;

    private List<Server> servers = new ArrayList<>();

    public void addServer(Server server) {
        servers.add(server);
    }

    public void removeServer(Server server) {
        servers.remove(server);
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
        for (Server server : servers) {
            server.offer(msg);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ManagementConsole console = new ManagementConsole();
        Server server1 = new Server(console, "1");
        Server server2 = new Server(console, "2");
        console.addServer(server1);
        console.addServer(server2);
        console.startAll();
    }

}
