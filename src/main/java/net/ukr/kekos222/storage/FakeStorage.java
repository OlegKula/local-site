package net.ukr.kekos222.storage;

import net.ukr.kekos222.model.User;
import org.mindrot.jbcrypt.BCrypt;

import java.util.ArrayList;
import java.util.List;

public class FakeStorage {
    private final static FakeStorage storage;

    private List<User> users;

    static {
        storage = new FakeStorage();
    }

    private FakeStorage() {
        this.users = new ArrayList<>();

        users.add(new User("Oleg","Kula","kekos222@ukr.net", "123"));
    }

    public static FakeStorage storage() {
        return storage;
    }

    public List<User> users() {
        return users;
    }

}
