package dev.artemon.crm.contact.domain;


import dev.artemon.crm.shared.Email;
import dev.artemon.crm.shared.ID;
import dev.artemon.crm.shared.Name;
import dev.artemon.crm.shared.PhoneNumber;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;


@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Contact {

    private final ID<Contact> id;
    private Name name;
    private Email email;
    private PhoneNumber phoneNumber;

    @NotNull
    @Contract("_, _, _ -> new")
    public static Contact createNewContact(Name name, Email email, PhoneNumber phoneNumber) {
        return new Contact(ID.newId(), name, email, phoneNumber);
    }

}
