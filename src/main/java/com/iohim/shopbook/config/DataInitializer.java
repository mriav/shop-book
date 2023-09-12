package com.iohim.shopbook.config;

import com.iohim.shopbook.util.UserUtil;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Класс инецеализирует тестовые данные сущностей в БД.
 */
@Component
public class DataInitializer {

    private UserUtil userUtil;

    @Autowired
    public DataInitializer(UserUtil userUtil) {
        this.userUtil = userUtil;
    }

    /**
     * Метод внедряет сущности при загрузки сервиса с помощью аннотации @PostConstruct.
     */
    @PostConstruct
    public void init() {
        userUtil.createFiveUserAndSaveInDb();
    }
}
