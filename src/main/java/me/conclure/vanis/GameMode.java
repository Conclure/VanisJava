package me.conclure.vanis;

import org.jetbrains.annotations.NotNull;

import java.util.Optional;
import java.util.function.UnaryOperator;

public enum GameMode {
  SELF_FEED("Self-Feed"),
  FFA("FFA"),
  GIGASPLIT("Gigasplit"),
  MEGASPLIT("Megasplit"),
  CRAZY("Crazy"),
  INSTANT("Instant"),
  UNKNOWN(null);

  private static final EnumCache<GameMode> CACHE = new EnumCache<>(GameMode.class,e -> e.gameModeName, UnaryOperator.identity());
  private final String gameModeName;

  private GameMode(String gameModeName) {
    this.gameModeName = gameModeName;
  }

  @NotNull
  public static GameMode get(String name) {
    GameMode gameMode = CACHE.get(name);
    if (gameMode == null) {
      return UNKNOWN;
    }
    return gameMode;
  }

  public Optional<String> gameModeName() {
    return Optional.ofNullable(this.gameModeName);
  }
}
