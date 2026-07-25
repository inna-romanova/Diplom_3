package user;

import model.User;

import org.apache.commons.lang3.RandomStringUtils;

public class TestUserDataGenerator {
    public static User getRandomUser() {
        return new User()
                .setEmail("Inna" + randomString(9) + "@yandex.ru")
                .setPassword(randomString(9))
                .setName(randomString(9));
    }

    private static String randomString(int length) {
        return RandomStringUtils.randomAlphabetic(length);
    }

    public static String getInvalidPassword() {
        return randomString(4);
    }
}
