import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import me.conclure.vanis.GameServer;
import me.conclure.vanis.GameServers;
import me.conclure.vanis.Vanis;
import me.conclure.vanis.VanisBuilder;

import java.io.IOException;

public class SerializationTest {
  public static void main(String[] args) {
    Vanis vanis = VanisBuilder.create().build();
    vanis
        .servers()
        .thenAccept(
            servers -> {
              for (GameServer server : servers) {
                System.out.println(server);
              }
            }).join();
  }
}
