package me.conclure.vanis;

import org.jetbrains.annotations.ApiStatus.NonExtendable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Unmodifiable;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.function.UnaryOperator;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@NonExtendable
public interface Vanis {
  @NotNull
  Gson gson();

  @NotNull
  UnaryOperator<@NotNull GsonBuilder> populator();

  @NotNull
  Executor executor();

  @NotNull
  CompletableFuture<@NotNull GameServers> servers();


}