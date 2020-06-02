import com.solvd.automation.classes.c10.Client;
import com.solvd.automation.classes.c10.Server;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.testng.Assert.assertFalse;
import static org.testng.AssertJUnit.assertEquals;

public class ServerTest {
    private static final String HOST = "127.0.0.1";
    private static final int PORT = 8000;
    protected final int POOL_SIZE = 30;
    protected final int INVOCATION_COUNT = 1;
    protected final int INVOCATION_TIME_OUT = 10000;
    protected ServerThread serverThread;
    protected ExecutorService clientPool;

    @BeforeClass
    public void setUpSpace() throws IOException {
        serverThread = new ServerThread(new Server());
        serverThread.start();

        clientPool = Executors.newFixedThreadPool(POOL_SIZE);
        Runnable clientInitTask = () -> new Client(HOST, PORT);
        for (int i = 0; i < POOL_SIZE; i++) {
            clientPool.execute(clientInitTask);
        }
    }

    @Test(threadPoolSize = POOL_SIZE, invocationCount = INVOCATION_COUNT, invocationTimeOut = INVOCATION_TIME_OUT)
    public void testConnections() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            assertFalse(serverThread.getServer().getServerList().isEmpty());
            assertEquals(serverThread.getServer().getServerList().size(), POOL_SIZE);

        }
    }

    @AfterClass
    public void setDownSpace() {
        clientPool.shutdown();
    }
}
