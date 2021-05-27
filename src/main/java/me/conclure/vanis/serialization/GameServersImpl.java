package me.conclure.vanis.serialization;

import org.jetbrains.annotations.NotNull;

import me.conclure.vanis.GameServer;
import me.conclure.vanis.GameServers;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

final class GameServersImpl implements GameServers {
  static GameServers EMTPY_GAMESERVERS = new Empty();

  private final Map<String,GameServer> lookupMap;

  GameServersImpl(GameServer[] servers) {
    Map<String,GameServer> temp = new HashMap<>();

    for (GameServer server : servers) {
      temp.put(server.name(),server);
    }

    this.lookupMap = Map.copyOf(temp);
  }

  @Override
  public boolean isEmpty() {
    return false;
  }

  @Override
  public GameServer getServer(String name) {
    return this.lookupMap.get(name);
  }

  @Override
  public Collection<GameServer> servers() {
    return this.lookupMap.values();
  }

  @Override
  public Set<String> serverNameSet() {
    return this.lookupMap.keySet();
  }

  @Override
  public String toString() {
    return "GameServersImpl{" +
        "lookupMap=" + lookupMap +
        '}';
  }

  @NotNull
  @Override
  public Iterator<GameServer> iterator() {
    return this.servers().iterator();
  }

  static class Empty implements GameServers {

    @Override
    public boolean isEmpty() {
      return true;
    }

    @Override
    public GameServer getServer(String name) {
      return null;
    }

    @Override
    public Collection<GameServer> servers() {
      return Collections.emptyList();
    }

    @Override
    public Set<String> serverNameSet() {
      return Collections.emptySet();
    }

    @NotNull
    @Override
    public Iterator<GameServer> iterator() {
      return Collections.emptyIterator();
    }
  }
}
