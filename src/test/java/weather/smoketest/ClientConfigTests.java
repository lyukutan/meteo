package weather.smoketest;

import com.example.country.WeatherApplication;
import com.example.country.client.countryinfo.CountryInfoServiceClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.oorsprong.websamples.CountryName;
import org.oorsprong.websamples.CountryNameResponse;
import org.oorsprong.websamples.ObjectFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = WeatherApplication.class)
public class ClientConfigTests {

    private static final Logger log = LoggerFactory.getLogger(ClientConfigTests.class);

    @Autowired
    private CountryInfoServiceClient weatherServiceClient;

    @Test
    public void supportServiceCreated() {
        assertThat(weatherServiceClient).isNotNull();
    }

    @Test
    public void testWeatherServiceClientGetCitiesByCountry() {
        CountryName countryNameRequest = new ObjectFactory().createCountryName();
        countryNameRequest.setSCountryISOCode("AD");
        CountryNameResponse response = (CountryNameResponse) weatherServiceClient.call(countryNameRequest);
        assertThat(response).isNotNull();
    }
}
