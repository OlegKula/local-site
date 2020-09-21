package net.ukr.kekos222.repo;

import net.ukr.kekos222.model.User;

import java.util.List;

public interface UserRepo {

    List<User> findAll();

    boolean isExist(String email, String password);

    void save(User user);

}
