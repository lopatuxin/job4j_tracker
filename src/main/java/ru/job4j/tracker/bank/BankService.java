package ru.job4j.tracker.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает работу банковского сервиса по переводу средств с одного счета на другой
 * @author Лопатухин Антон
 * @version 1.0
 */
public class BankService {
    /**
     * Все данные о клиентах банка хранятся в списке Map.
     * Каждый клиент может иметь несколько счетов в банке, которые хранятся в списке
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод проверяет, есть ли в списке уже такой пользователь,
     * если нет, то добавляет его в список.
     * @param user Пользователь который добавляется в список
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * Метод ищет пользователя по пасспорту, затем проверяет есть ли в списке счетов уже такой счет,
     * если нет, то добавляет в список счетов новый счет
     * @param passport номер пасспорта
     * @param account счет в банке
     */
    public void addAccount(String passport, Account account) {
            User user = findByPassport(passport);
            if (user != null) {
                List<Account> accounts = users.get(user);
                if (!accounts.contains(account)) {
                    accounts.add(account);
                }
            }
    }

    /**
     * Метод ищет пользователя по номеру пасспорта
     * @param passport номер пасспорта
     * @return если пользователь не найден возвращает Null, либо User
     */
    public User findByPassport(String passport) {
        return users.keySet().stream()
                .filter(user -> user.getPassport().equals(passport))
                .findFirst()
                .orElse(null);
    }

    /**
     * Метод ищет пользователя по номеру паспорта, если находит, то в списке его счетов ищет необходимый счет
     * @param passport номер паспорта
     * @param requisite реквизиты счета
     * @return возвращает Account либо null
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            return users.get(user).stream()
                    .filter(account -> account.getRequisite().equals(requisite))
                    .findFirst()
                    .orElse(null);
        }
        return null;
    }

    /**
     * Метод переводит деньги с одного счета на другой
     * @param srcPassport номер пасспорта
     * @param srcRequisite номер счета с которого переводят деньги
     * @param destPassport номер пасспорта
     * @param destRequisite номер счета на который переводят деньги
     * @param amount сумма перевода
     * @return возвращает false если счет не найден либо не хватает денег
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount != null && destAccount != null && srcAccount.getBalance() >= amount) {
            srcAccount.setBalance(srcAccount.getBalance() - amount);
            destAccount.setBalance(destAccount.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}
