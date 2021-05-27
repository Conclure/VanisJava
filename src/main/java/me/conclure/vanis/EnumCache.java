package me.conclure.vanis;

import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.function.UnaryOperator;

final class EnumCache<E extends Enum<E>> {
  final Map<String,E> lookup;
  final UnaryOperator<String> transformer;

  EnumCache(Class<? extends E> type, Function<E, String> registrator,
      UnaryOperator<String> lookupTranformer) {
    this.transformer = lookupTranformer;
    Map<String,E> temp = new HashMap<>();
    E[] constants = type.getEnumConstants();
    for (E constant : constants) {
      temp.put(registrator.apply(constant),constant);
    }
    this.lookup = Map.copyOf(temp);
  }

  @Nullable
  public E get(String string) {
    return this.lookup.get(this.transformer.apply(string));
  }
}
