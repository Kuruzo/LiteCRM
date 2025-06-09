package dev.artemon.crm.shared;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class Name {
    private final String firstName;
    private final String lastName;

    public static Name from(String firstName, String lastName) {
        return new Name(firstName, lastName);
    }
}
