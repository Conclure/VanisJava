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
    for (JsonElement element : jsonArray) {
      GameServer server = context.deserialize(element, GameServer.class);
    }
    return null;
  }
}
