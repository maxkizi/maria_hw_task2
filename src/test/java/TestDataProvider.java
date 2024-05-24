import dto.Account;

public class TestDataProvider {
    public static Account buildValidAccount() {
        return new Account("testLogin", "testPassword123456+", "active");
    }
}
