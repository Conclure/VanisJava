package me.conclure.vanis;

import java.util.concurrent.Executor;
import java.util.concurrent.ForkJoinPool;

public class VanisBuilder {
  private Executor executor = ForkJoinPool.commonPool();

  public VanisBuilder executor(Executor executor) {
    this.executor = executor;
    return this;
  }

  public static VanisBuilder create() {
    return new VanisBuilder();
  }

  public Vanis build() {
    return new VanisImpl(this.executor);
  }

}
