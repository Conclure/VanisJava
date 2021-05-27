package me.conclure.vanis.serialization;

import me.conclure.vanis.GameServer;

import java.lang.reflect.Type;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.regex.Pattern;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;

public class GameServerDeserializer implements JsonDeserializer<GameServer> {
  private static final Pattern REGION_PATTERN = Pattern.compile("\\d+");

  @Override
  public GameServer deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
      throws JsonParseException {
    if (!json.isJsonObject()) {
      return null;
    }

    JsonObject jsonObject = json.getAsJsonObject();
    JsonElement nameElement = jsonObject.get("name");
    JsonElement domainElement = jsonObject.get("domain");
    JsonElement portElement = jsonObject.get("port");
    JsonElement gameModeElement = jsonObject.get("gameMode");
    JsonElement currentPlayersElement = jsonObject.get("currentPlayers");
    JsonElement maxPlayersElement = jsonObject.get("maxPlayers");
    JsonElement checkInUrlElement = jsonObject.get("checkInUrl");
    JsonElement urlElement = jsonObject.get("url");

    boolean isValid = nameElement.isJsonPrimitive()
        && domainElement.isJsonPrimitive()
        && portElement.isJsonPrimitive()
        && gameModeElement.isJsonPrimitive()
        && currentPlayersElement.isJsonPrimitive()
        && maxPlayersElement.isJsonPrimitive()
        && checkInUrlElement.isJsonPrimitive()
        && urlElement.isJsonPrimitive();

    if (!isValid) {
      return null;
    }

    JsonPrimitive namePrimitive = nameElement.getAsJsonPrimitive();
    JsonPrimitive domainPrimitive = nameElement.getAsJsonPrimitive();
    JsonPrimitive portPrimitive = nameElement.getAsJsonPrimitive();
    JsonPrimitive gameModePrimitive = nameElement.getAsJsonPrimitive();
    JsonPrimitive currentPlayersPrimitive = nameElement.getAsJsonPrimitive();
    JsonPrimitive maxPlayersPrimitive = nameElement.getAsJsonPrimitive();
    JsonPrimitive checkInUrlPrimitive = nameElement.getAsJsonPrimitive();
    JsonPrimitive urlPrimitive = nameElement.getAsJsonPrimitive();

    isValid = portPrimitive.isNumber()
        && currentPlayersPrimitive.isNumber()
        && maxPlayersPrimitive.isNumber();

    if (!isValid) {
      return null;
    }

    int portInt = portPrimitive.getAsInt();
    int currentPlayersInt = currentPlayersPrimitive.getAsInt();
    int maxPlayersInt = maxPlayersPrimitive.getAsInt();

    isValid = namePrimitive.isString()
        && domainPrimitive.isString()
        && gameModePrimitive.isString()
        && checkInUrlPrimitive.isString()
        && urlPrimitive.isString();

    if (!isValid) {
      return null;
    }

    String nameString = namePrimitive.getAsString();
    String domainString = domainElement.getAsString();
    String gameModeString = gameModePrimitive.getAsString();
    String checkInUrlString = checkInUrlPrimitive.getAsString();
    String urlString = urlPrimitive.getAsString();

    URI checkInUrlUri = null;
    URI urlUri = null;

    try {
      checkInUrlUri = URI.create(checkInUrlString);
      urlUri = URI.create(urlString);
    } catch (IllegalArgumentException exception) {
      return null;
    }

    if (!REGION_PATTERN.matcher(domainString).group()) {
      return
    }

    return null;
  }
}