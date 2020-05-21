package automation.classes.c10;

import automation.classes.c10.bo.ConnectMessage;
import automation.constant.C10Constant;
import automation.io.exception.UnableToReadException;
import automation.io.interfaces.Packable;
import automation.util.PropertyUtil;
import automation.util.SerializationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * 1. object streams
 * 2. task
 * 3. swap strings
 * 33. loggers (stdin, stdout, stderr)
 * 4. refactoring
 * 5. fixes
 */
public class Client {

    public static void main(String[] args) throws IOException, UnableToReadException {
        final String HOST = PropertyUtil.getValueByKey(C10Constant.HOSTNAME);
        final int PORT = Integer.valueOf(PropertyUtil.getValueByKey(C10Constant.PORT));
        final String TOKEN = PropertyUtil.getValueByKey(C10Constant.TOKEN);

        Socket socket = null;
        DataOutputStream os = null;

        String path = System.getProperty("user.dir") + "\\src\\client_" + (int) (Math.random() * 10000);
        String responsePath = path + "_response";
        Path p1 = Paths.get(path);
        Path p2 = Paths.get(responsePath);

        try {
            Files.createFile(p1);
            Files.createFile(p2);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            socket = new Socket(HOST, PORT);
            os = new DataOutputStream(socket.getOutputStream());
            System.out.println(path);
            os.writeBytes(path + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }

        connect(path, HOST, PORT, TOKEN);

        Scanner in = new Scanner(System.in);

        while (true) {
            System.out.println("Enter your message:");
            String answer = WordsFilter.chesk(in.nextLine());

            if (answer.equalsIgnoreCase("GoodBye")) {
                System.out.println("Bye bye");
                break;
            }
            Packable pkg = new ConnectMessage(HOST, PORT, TOKEN, answer);
            new SerializationUtil(path, path + "_response").writeObject(pkg);
        }

    }

    private static void connect(String path, final String host, final int port, final String token) {
        String msg = "Conn";
        Packable pkg = new ConnectMessage(host, port, token, msg);
        new SerializationUtil(path, path).writeObject(pkg);
    }

    private static Packable getResponse(String path) {
        return new SerializationUtil(path, path).readResponse();
    }
}
