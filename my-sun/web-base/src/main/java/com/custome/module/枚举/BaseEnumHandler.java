package com.custome.module.枚举;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public abstract class BaseEnumHandler{


    public static <K, V, T extends Enum<?> & BaseEnum<K, V>> List<K> getKeysByEnum(Class<T> enumClass) {
        return Arrays.stream(enumClass.getEnumConstants())
                .map(BaseEnum::getKey)
                .collect(Collectors.toList());
    }

    public static <K, V, T extends Enum<?> & BaseEnum<K, V>> List<V> getValuesByEnum(Class<T> enumClass) {
        return Arrays.stream(enumClass.getEnumConstants())
                .map(BaseEnum::getValue)
                .collect(Collectors.toList());
    }

    public static <K, V, T extends Enum<?> & BaseEnum<K, V>> T getEnumByKey(Class<T> enumClass, String key) {
        return Arrays.stream(enumClass.getEnumConstants())
                .filter(t -> t.getKey().equals(key))
                .findFirst()
                .orElseThrow(() -> new RuntimeException(""));
    }

    public static <K, V, T extends Enum<?> & BaseEnum<K, V>> T getEnumByValue(Class<T> enumClass, String value) {
        return Arrays.stream(enumClass.getEnumConstants())
                .filter(t -> t.getValue().equals(value))
                .findFirst()
                .orElseThrow(() -> new RuntimeException(""));
    }

    public static <K, V, T extends Enum<?> & BaseEnum<K, V>> V getValueByKey(Class<T> enumClass, String key) {
        return Arrays.stream(enumClass.getEnumConstants())
                .filter(t -> t.getKey().equals(key))
                .findFirst()
                .orElseThrow(() -> new RuntimeException(""))
                .getValue();
    }

    public static <K, V, T extends Enum<?> & BaseEnum<K, V>> K getKeyByValue(Class<T> enumClass, String value) {
        return Arrays.stream(enumClass.getEnumConstants())
                .filter(t -> t.getValue().equals(value))
                .findFirst()
                .orElseThrow(() -> new RuntimeException(""))
                .getKey();
    }

}
