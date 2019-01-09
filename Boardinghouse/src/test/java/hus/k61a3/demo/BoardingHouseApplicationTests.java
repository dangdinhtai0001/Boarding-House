package hus.k61a3.demo;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.preemptive;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {BoardingHouseApplication.class}, webEnvironment = RANDOM_PORT)
public class BoardingHouseApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Value("${local.server.port}")
    private int port;

    @Before
    public void setUp() {
        RestAssured.authentication = preemptive().basic("kai", "123456");
    }

    @Test
    public void shouldSayHello() {
        get("http://localhost:" + port + "api/feedbacks")
                .then()
                .assertThat()
                .statusCode(200)
                .body("id", Matchers.equalTo("1"))
                .and()
                .body("feedback", Matchers.equalTo("Smith"));
    }

}
