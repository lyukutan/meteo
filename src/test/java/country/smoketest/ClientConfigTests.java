package country.smoketest;

import com.example.country.WeatherApplication;
import com.example.country.client.countryinfo.CountryInfoServiceClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.oorsprong.websamples.CountryName;
import org.oorsprong.websamples.CountryNameResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.MatcherAssert.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = WeatherApplication.class)
public class ClientConfigTests {

    private static final Logger log = LoggerFactory.getLogger(ClientConfigTests.class);

    @Autowired
    private CountryInfoServiceClient countryInfoServiceClient;

    @Test
    public void supportServiceCreated() {
        assertThat("CountryInfoServiceClient инициализируется и не равен null", countryInfoServiceClient != null);
    }

    @Test
    public void testCountryInfoService_CountryName() {
        CountryName countryNameRequest = new CountryName();
        countryNameRequest.setSCountryISOCode("AD");
        String niceNameResult = "Andorra";
        CountryNameResponse response = (CountryNameResponse) countryInfoServiceClient.call(countryNameRequest);
        assertThat("Ответ получен и не пустой", response != null);
        assertThat("CountryNameResult = " + niceNameResult, niceNameResult.equals(response.getCountryNameResult()));
        log.debug(response.toString());
    }
}
