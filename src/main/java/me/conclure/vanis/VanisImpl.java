package me.conclure.vanis;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Unmodifiable;

import me.conclure.vanis.serialization.GameServerDeserializer;
import me.conclure.vanis.serialization.GameServersDeserializer;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.concurrent.Executor;
import java.util.function.UnaryOperator;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

final class VanisImpl implements Vanis {
  final OkHttpClient okHttpClient = new OkHttpClient();
  final Executor executor;
  final UnaryOperator<GsonBuilder> populator = builder -> builder
      .registerTypeAdapter(GameServer.class,new GameServerDeserializer())
      .registerTypeAdapter(GameServers.class,new GameServersDeserializer());
  final Gson gson = this.populator.apply(new GsonBuilder()).create();

  VanisImpl(Executor executor) {
    this.executor = executor;
  }

  @Override
  public @NotNull Gson gson() {
    return this.gson;
  }

  @Override
  public @NotNull UnaryOperator<GsonBuilder> populator() {
    return this.populator;
  }

  @Override
  public @NotNull Executor executor() {
    return this.executor;
  }

  @Override
  public @NotNull CompletableFuture<GameServers> servers() {
    return CompletableFuture.supplyAsync(() -> {

      Request request = new Request.Builder()
          .url("https://vanis.io/gameservers.json")
          .build();

      try (Response response = this.okHttpClient.newCall(request).execute()) {
        //noinspection ConstantConditions
        return this.gson.fromJson(response.body().string(),GameServers.class);
      } catch (IOException e) {
        throw new CompletionException(e);
      }
    }, this.executor);
  }
}
