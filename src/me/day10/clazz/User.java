package me.day10.clazz;

public class User {
    static final String EMAIL_REGEX = "^\\w+@\\w+\\.\\w+(\\.\\w+)?$";
    static final String PHONE_REGEX = "^\\d{2,3}-\\d{3,4}-\\d{4}$";

    // 자바: 필드 (field)
    // C/C++: 멤버변수
    private String userId;
    // 아무도 수정 불가능
    private String userPw;
    // 일반적으로 외부에서 패스워드 수정/반환 불가
    // 하지만 admin, dev 일 경우 수정/반환 가능
    private String userEmail;
    // 수정 가능 (asdsad@gmail.com)
    private String userPhone;
    // 수정 가능 (010-0000-0000)
    private Gender userGender;
    // 수정 가능 (null 값으로는 수정 불가)

    private Authorization authorization;

    public User() {
        // 디폴트 생성자 (개발 구현상의 문제가 생길 수 있으므로 디폴트하게 만드는 것이 좋음)
        // 만약 생성자가 아무것도 정의되어있지 않으면 컴파일러가 자동 생성
    }

    public User(String userId, String userPw, String userEmail) {
        this.userId = userId;
        this.userPw = userPw;
        this.userEmail = userEmail;
    }

    public User(String userId, String userPw, String userEmail,
                String userPhone, Gender userGender) {
        this.userId = userId;
        this.userPw = userPw;
        this.userEmail = userEmail;
        this.userPhone = userPhone;
        this.userGender = userGender;
        this.authorization = Authorization.USER;
    }

    public User(String userId, String userPw, String userEmail,
                String userPhone, Gender userGender, Authorization authorization) {
        this.userId = userId;
        this.userPw = userPw;
        this.userEmail = userEmail;
        this.userPhone = userPhone;
        this.userGender = userGender;
        this.authorization = authorization;
    }

    public String getUserId() {
        return userId;
    }

    private void setUserId(String userId) {
        this.userId = userId;
    }

    private String getUserPw() {
        return userPw;
    }

    public String sudoGetUserPw(User user) { // 관리자가 특정 유저의 비밀번호를 수정하는 함수
        if (authorization == Authorization.ADMIN || authorization == Authorization.DEV) {
            return user.userPw;
        } else {
            System.out.println("[ERROR] Check Your Authorization!");
        }
        return null;
    }

    private void setUserPw(String userPw) { // 일반 유저가 호출할 수 있는 함수
        this.userPw = userPw;
    }

    public void sudoSetUserPw(User user, String userPw) { // 관리자가 특정 유저의 비밀번호를 수정하는 함수
        if (authorization == Authorization.ADMIN || authorization == Authorization.DEV) {
            user.setUserPw(userPw);
        } else {
            System.out.println("[ERROR] Check Your Authorization!");
        }
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        if (userEmail.matches(EMAIL_REGEX)) {
            this.userEmail = userEmail;
        } else {
            System.out.println("[ERROR] Check Your Data Format!");
        }
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        if (userPhone.matches(PHONE_REGEX)) {
            this.userPhone = userPhone;
        } else {
            System.out.println("[ERROR] Check Your Data Format!");
        }
    }

    public Gender getUserGender() {
        return userGender;
    }

    public void setUserGender(Gender userGender) {
        if (userGender != null) {
            this.userGender = userGender;
        } else {
            System.out.println("[ERROR] Null Exception.");
        }
    }

    private Authorization getAuthorization() {
        return authorization;
    }

    private void setAuthorization(Authorization authorization) {
        this.authorization = authorization;
    }
}
