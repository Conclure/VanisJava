package me.conclure.vanis;

import org.jetbrains.annotations.ApiStatus.NonExtendable;
import org.jetbrains.annotations.NotNull;

import java.net.URI;

@NonExtendable
public interface GameServer {
  @NotNull
  String name();

  @NotNull
  String domain();

  int port();

  @NotNull
  GameMode gameMode();

  int currentPlayers();

  int maxPlayers();

  @NotNull
  URI checkInUrl();

  @NotNull
  URI url();

  @NotNull
  Region region();
}
