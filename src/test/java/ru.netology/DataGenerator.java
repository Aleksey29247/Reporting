package ru.netology;

import com.github.javafaker.Faker;
import lombok.Data;
import lombok.Value;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Data

public class DataGenerator {
       private DataGenerator() {
    }

    private static Faker faker = new Faker(new Locale("ru"));


    public static String generateDate(int days) {
       return LocalDate.now().plusDays(days).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));

        // TODO: добавить логику для объявления переменной date и задания её значения, для генерации строки с датой
        // Вы можете использовать класс LocalDate и его методы для получения и форматирования даты

    }

    public static String generateCity(String locale) {
        String[] citis = {"Новосибирск", "Омск", "Томск", "Барнаул"};
        int n = (int) Math.floor(Math.random() * citis.length);
        return citis[n];
        // TODO: добавить логику для объявления переменной city и задания её значения, генерацию можно выполнить
        // с помощью Faker, либо используя массив валидных городов и класс Random

    }

    public static String generateName(String locale) {
        var faker = new Faker(new Locale(locale));
        return faker.name().fullName();
        // TODO: добавить логику для объявления переменной name и задания её значения, для генерации можно
        // использовать Faker

    }

    public static String generatePhone(String locale) {
        var faker = new Faker(new Locale(locale));
        return faker.phoneNumber().phoneNumber();
        // TODO: добавить логику для объявления переменной phone и задания её значения, для генерации можно
        // использовать Faker

    }

    public static class Registration {
        private Registration() {
        }

        public static UserInfo generateUser(String locale) {
            UserInfo user = new UserInfo(generateCity(locale), generateName(locale), generatePhone(locale));
            return user;
            // TODO: добавить логику для создания пользователя user с использованием методов generateCity(locale),
            // generateName(locale), generatePhone(locale)

        }
    }

    @Value
    public static class UserInfo {
        String city;
        String name;
        String phone;
    }
}