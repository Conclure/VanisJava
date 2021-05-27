package me.conclure.vanis;

import org.jetbrains.annotations.NotNull;

public enum Region {
  EU,
  NA,
  AS,
  UNKNOWN;

  private static final EnumCache<Region> CACHE = new EnumCache<>(Region.class,e -> e.name().toLowerCase(), String::toLowerCase);

  @NotNull
  public static Region get(String name) {
    Region region = CACHE.get(name);
    if (region == null) {
      return UNKNOWN;
    }
    return region;
  }
}
