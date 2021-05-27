package me.conclure.vanis;

import java.util.Collection;
import java.util.Set;

public interface GameServers {
  boolean isEmpty();

  GameServer getServer(String name);

  Collection<GameServer> servers();

  Set<String> serverNameSet();
}
