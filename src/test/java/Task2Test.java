import dto.Account;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class Task2Test {
    /**
     * На  моём компе порт 9999 занят, поэтому я подымал тестовое приложение на порту 8080
     * Для этого вместо: java              -jar app-ibank.jar -P:profile=test
     * я использовал:    java -DPORT=8080  -jar app-ibank.jar -P:profile=test
     */

    private static final int PORT = 8080;

    private static final RequestSpecification REQUEST_SPEC = new RequestSpecBuilder()
            .setBaseUri("http://localhost")
            .setPort(PORT)
            .setAccept(ContentType.JSON)
            .setContentType(ContentType.JSON)
            .log(LogDetail.ALL)
            .build();

    @Test
    void createAccount() {
        Account validAccountObject = TestDataProvider.buildValidAccount();
        given() // "дано"
                .spec(REQUEST_SPEC) // указываем, какую спецификацию используем
                .body(validAccountObject) // передаём в теле объект, который будет преобразован в JSON
                .when() // "когда"
                .post("/api/system/users") // на какой путь относительно BaseUri отправляем запрос
                .then() // "тогда ожидаем"
                .statusCode(200); // код 200 OK
    }
}
