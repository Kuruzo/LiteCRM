package dev.artemon.crm.shared;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

import java.util.Objects;
import java.util.UUID;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public final class  ID<T> {

    private final UUID value;

    public static <T> ID<T> newId() {
        return new ID<>(UUID.randomUUID());
    }

    public static <T> ID<T> from(UUID id) {
        return new ID<>(id);
    }

    public UUID value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ID<?> id)) return false;
        return Objects.equals(value, id.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }

    @Override
    public String toString() {
        return value.toString();
    }

}