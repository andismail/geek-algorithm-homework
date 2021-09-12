package common.test.io;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class NoneBlocking {
    public static void main(String[] args) throws IOException {
        ServerSocketChannel ssChannel = ServerSocketChannel.open();
        ssChannel.bind(new InetSocketAddress(9001));
        ssChannel.configureBlocking(false);

        while (true) {
            SocketChannel client = ssChannel.accept();

            if (client == null) {
                System.out.println("client is null");

            } else {
                client.configureBlocking(false);
            }

        }

    }
}
