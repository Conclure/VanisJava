package me.conclure.vanis.serialization;

import me.conclure.vanis.GameServer;
import me.conclure.vanis.GameServers;

import java.lang.reflect.Type;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

public class GameServersDeserializer implements JsonDeserializer<GameServers> {

  @Override
  public GameServers deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
      throws JsonParseException {
    if (!json.isJsonArray()) {
      return null;
    }

    JsonArray jsonArray = json.getAsJsonArray();

    if (jsonArray.isEmpty()) {
      return GameServersImpl.EMTPY_GAMESERVERS;
    }

    GameServer[] arr = new GameServer[jsonArray.size()];
    for (int i = 0; i < jsonArray.size(); i++) {
      GameServer server = context.deserialize(jsonArray.get(i), GameServer.class);

      if (server == null) {
        continue;
      }

      arr[i] = server;
    }

    if (arr.length == 0) {
      return GameServersImpl.EMTPY_GAMESERVERS;
    }

    return new GameServersImpl(arr);
  }
}
