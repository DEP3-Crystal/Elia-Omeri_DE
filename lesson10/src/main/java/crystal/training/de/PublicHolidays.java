package crystal.training.de;

import io.swagger.client.ApiClient;
import io.swagger.client.ApiException;
import io.swagger.client.api.PublicHolidayApi;
import io.swagger.client.model.PublicHolidayV3Dto;
import lombok.Builder;
import lombok.Data;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;

public class PublicHolidays {
    public static void main(String[] args) throws IOException, ApiException {
        InputStream is = PublicHolidays.class.getResourceAsStream("/cc.csv");
        try (CSVParser csvParser = new CSVParser(new InputStreamReader(is, StandardCharsets.UTF_8), CSVFormat.DEFAULT)) {
            List<CountryInfo> countries = csvParser.stream()
                    .map(csvRecord -> CountryInfo.builder()
                            .name(csvRecord.get(0))
                            .code(csvRecord.get(1))
                            .build())
                    .collect(Collectors.toList());
            //System.out.println(countries);

            ApiClient apiClient = new ApiClient();
            apiClient.setBasePath("https://date.nager.at");
            PublicHolidayApi publicHolidayApi = new PublicHolidayApi(apiClient);
            countries.stream().parallel().forEach(country -> {
                try {
                    List<PublicHolidayV3Dto> result = publicHolidayApi.publicHolidayPublicHolidaysV3(2022, country.getCode());
                    country.setNumberOfHolidays(result.size());

                } catch (NullPointerException | ApiException e) {
                    country.setNumberOfHolidays(0);
                }
            });
            countries.removeIf(e -> (e.numberOfHolidays == 0));
            OptionalInt max = countries.stream().parallel().mapToInt(code -> code.getNumberOfHolidays()).max();
            System.out.println(max);
            OptionalInt min = countries.stream().parallel().mapToInt(code -> code.getNumberOfHolidays()).min();
            System.out.println(min);
            countries.stream().parallel().filter(code -> code.getNumberOfHolidays() == max.getAsInt())
                    .forEach(country -> System.out.println("State with maximum number of holidays is: " + country.name + " with " + country.getNumberOfHolidays() + " days off."));

            countries.stream().parallel().filter(code -> code.getNumberOfHolidays() == min.getAsInt())
                    .forEach(country -> System.out.println("State with minimum number of holidays is: " + country.name + " with " + country.getNumberOfHolidays() + " days off."));

        }
    }

    @Builder(toBuilder = true)
    @Data
    static class CountryInfo {
        private String name;
        private String code;
        private int numberOfHolidays;

    }
}
