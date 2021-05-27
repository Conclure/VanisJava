package me.conclure.vanis.serialization;

import org.jetbrains.annotations.NotNull;

import me.conclure.vanis.GameMode;
import me.conclure.vanis.GameServer;
import me.conclure.vanis.Region;

import java.net.URI;
import java.net.URL;

final class GameServerImpl implements GameServer {
  private final String name, domain;
  private final int port, currentPlayers, maxPlayers;
  private final GameMode gameMode;
  private final Region region;
  private final URI url, checkInUrl;

  public GameServerImpl(String name, String domain, int port, int currentPlayers, int maxPlayers,
      GameMode gameMode, Region region, URI url, URI checkInUrl) {
    this.name = name;
    this.domain = domain;
    this.port = port;
    this.currentPlayers = currentPlayers;
    this.maxPlayers = maxPlayers;
    this.gameMode = gameMode;
    this.region = region;
    this.url = url;
    this.checkInUrl = checkInUrl;
  }

  @Override
  public @NotNull String name() {
    return this.name;
  }

  @Override
  public @NotNull String domain() {
    return this.domain;
  }

  @Override
  public int port() {
    return this.port;
  }

  @Override
  public @NotNull GameMode gameMode() {
    return this.gameMode;
  }

  @Override
  public int currentPlayers() {
    return this.currentPlayers;
  }

  @Override
  public int maxPlayers() {
    return this.maxPlayers;
  }

  @Override
  public @NotNull URI checkInUrl() {
    return this.checkInUrl;
  }

  @Override
  public @NotNull URI url() {
    return this.url;
  }

  @Override
  public @NotNull Region region() {
    return this.region;
  }
}
