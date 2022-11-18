package me.day10.clazz;

public class ClassExample {
    public static void main(String[] args) {
        User user = new User("a",
                "a1234",
                "a@gmail.com",
                "010-0000-0000",
                Gender.MALE); // 메모리상에 새로운 공간 할당 (객체의 인스턴스)
        System.out.println(user.getUserId());
        System.out.println(user.getUserEmail());
        System.out.println(user.getUserPhone());
        System.out.println(user.getUserGender());
        System.out.println();

        user.setUserEmail("a@gmail.");
        user.setUserPhone("010-00-0000");
        user.setUserGender(null);
        System.out.println();

        User admin = new User("admin",
                "admin",
                "admin@gmail.com",
                "02-1111-2222",
                Gender.MALE,
                Authorization.ADMIN);

        admin.sudoSetUserPw(user, "a12345");
        System.out.println(admin.sudoGetUserPw(user));
    }
}
