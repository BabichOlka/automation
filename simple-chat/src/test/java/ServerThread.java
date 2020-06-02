import com.solvd.automation.classes.c10.Server;

public class ServerThread extends Thread {

    private Server server;

    public ServerThread(Server server) {
        this.server = server;

    }

    @Override
    public void run() {
        this.server.start();
    }

    public Server getServer() {
        return server;

    }

    public void setServer(Server server) {
        this.server = server;

    }
}
