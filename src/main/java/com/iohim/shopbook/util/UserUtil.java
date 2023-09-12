package com.iohim.shopbook.util;

import com.iohim.shopbook.model.User;
import com.iohim.shopbook.service.UsersServiceImp;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserUtil {

    private final UsersServiceImp usersServiceImp;

    public UserUtil(UsersServiceImp usersServiceImp) {
        this.usersServiceImp = usersServiceImp;
    }

    /**
     * Метод внедряет пользователей в БД.
     */
    public void createFiveUserAndSaveInDb() {
        List<User> usersList = new ArrayList<>();
        User user1 = new User();
        user1.setName("Александр");
        user1.setLastName("Иохим");
        user1.setPatronymic("Викторович");
        user1.setAge(35);
        user1.setEmail("mlpiav@mail.ru");

        User user2 = new User();
        user2.setName("Оксана");
        user2.setLastName("Иохим");
        user2.setPatronymic("Анатольевна");
        user2.setAge(33);
        user2.setEmail("mlpiaa@mail.ru");

        User user3 = new User();
        user3.setName("Алексей");
        user3.setLastName("Иохим");
        user3.setPatronymic("Александрович");
        user3.setAge(8);
        user3.setEmail("mdpiaa@mail.ru");

        usersList.add(user1);
        usersList.add(user2);
        usersList.add(user3);

        for (User user:usersList) {
            usersServiceImp.save(user);
        }
        System.out.println("Пользователи добавленны в БД");
    }
}