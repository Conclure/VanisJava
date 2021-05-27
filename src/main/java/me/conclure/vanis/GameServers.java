package me.conclure.vanis;

import java.util.Collection;
import java.util.Set;

public interface GameServers extends Iterable<GameServer> {
  boolean isEmpty();

  GameServer getServer(String name, Region region);

  Collection<GameServer> servers();

  Set<String> serverNameSet();
}
