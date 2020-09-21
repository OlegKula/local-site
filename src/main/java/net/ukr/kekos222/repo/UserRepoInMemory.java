package net.ukr.kekos222.repo;

import net.ukr.kekos222.model.User;
import net.ukr.kekos222.storage.FakeStorage;
import org.mindrot.jbcrypt.BCrypt;

import java.util.List;

public class UserRepoInMemory implements UserRepo {
    @Override
    public List<User> findAll() {
        return FakeStorage.storage().users();
    }

    @Override
    public boolean isExist(String name, String password) {
        for (User user: FakeStorage.storage().users()){
            if (name.equals(user.getEmail()) && BCrypt.checkpw(password, user.getPassword()))
                return true;
        }
        return false;
    }

    @Override
    public void save(User user) {
        user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
        FakeStorage.storage().users().add(user);
    }
}
