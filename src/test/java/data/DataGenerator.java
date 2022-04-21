package data;

import com.github.javafaker.Faker;
import domian.RegistrationByCardInfo;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class DataGenerator {
    private DataGenerator() {
    }

    public static class Registration {
        private Registration() {
        }

        private static final RequestSpecification requestSpec = new RequestSpecBuilder()
                .setBaseUri("http://localhost")
                .setPort(9999)
                .setAccept(ContentType.JSON)
                .setContentType(ContentType.JSON)
                .log(LogDetail.ALL)
                .build();

        public static RegistrationByCardInfo setUpAll(String status) {
            Faker faker = new Faker();
            RegistrationByCardInfo user = new RegistrationByCardInfo(faker.name().username(), faker.internet().password(), status);
                     given()
                    .spec(requestSpec)
                    .body(user)
                    .when()
                    .post("/api/system/users")
                    .then()
                    .statusCode(200);
            return user;
        }

        public static RegistrationByCardInfo invalidData() {
            Faker faker1 = new Faker();
            return new RegistrationByCardInfo(faker1.name().username(), faker1.internet().password());
        }

        public static RegistrationByCardInfo emptyData() {
            return new RegistrationByCardInfo("", "");
        }
    }
 }