package me.conclure.vanis;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Unmodifiable;

import me.conclure.vanis.serialization.GameServerDeserializer;
import me.conclure.vanis.serialization.GameServersDeserializer;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.function.UnaryOperator;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

final class VanisImpl implements Vanis {
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
      return null;
    }, this.executor);
  }
}
