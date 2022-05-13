package ru.job4j.tracker.bank;

import java.util.Objects;

/**
 * Класс описывает модель дананых клиента банка
 * @author Лопатухин Антон
 * @version 1.0
 */
public class User {
    /**
     * В переменной хранится номер паспорта
     */
    private String passport;
    /**
     * В переменной хранится имя клиента банка
     */
    private String userName;

    public User(String passport, String userName) {
        this.passport = passport;
        this.userName = userName;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}
