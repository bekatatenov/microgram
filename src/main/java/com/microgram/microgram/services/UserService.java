package com.microgram.microgram.services;

import com.microgram.microgram.models.User;
import com.microgram.microgram.repositories.UserRepositories;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor

@Service
public class UserService {
    private final UserRepositories userRepositories;

    public List<User> getUsers() {
//       return userRepositories.findAll();
        // here return all users from database in List
        return List.of();
    }

    public void saveNewUser(User user) {
        //  userRepositories.save(user);
        // method saves new User to db
    }

    public void deleteUser(User user) {
//        userRepositories.delete(user);
        // method deletes user from db
    }

    public void changeUser(User user, User oldUser) {
//        userRepositories.delete(oldUser);
//        userRepositories.save(user);
        // method takes same 2 users, but with the different parameters
        // method delete from db oldUser and save the user with the new changes
    }

    public boolean isThereSuchUser(User user) {
//        Optional<User> byId = userRepositories.findById(user.getId());
//        if (byId == null) {
//            return false;
//        } else {
//            return true;
//        }

        // method returns boolean if there is a user in db return true
        // if not return false
        return true;
    }

    public Optional<User> login(String email, String password) {
//        User user = null;
//
//        List<User> all = userRepositories.findAll();
//        for (User uu:
//            all ) {
//            if(uu.getEmail().equals(email) && uu.getPassword().equals(password))
//            {
//                user = uu;
//            }
//        }


        // Method return user if password and email equals to one of the user's from db
        // return user
        // if not return Optional Empty

        return Optional.empty();
    }

    public boolean registerNewUser(User user) {
//        int count = 0;
//        List<User> all = userRepositories.findAll();
//
//        for (User u :
//                all) {
//            if (user.getEmail().equals(u.getEmail()) || user.getId() == u.getId() || user.getLogin().equals(u.getLogin())) {
//                count++;
//            }
//        }
//        if (count == 0) {
//            userRepositories.save(user);
//            return true;
//        } else {
//            return false;
//        }

        //method saves new User if new User's login, email and id is not equal to users's from db id, login and email
        return false;
    }

}
