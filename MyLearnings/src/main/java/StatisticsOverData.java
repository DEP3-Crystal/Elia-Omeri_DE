import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.DoubleSummaryStatistics;
import java.util.function.ToDoubleFunction;
import java.util.stream.Stream;

public class StatisticsOverData {

    public static void main(String[] args) {
        String lineNewYork = "1;New York; New York;8 336 817;780,9";
        ToDoubleFunction<String> lineToDensity = (line) -> {
            String[] split = line.split(";");
            String populationAsString = split[3];
            populationAsString = populationAsString.replace(" ", "");
            int population = Integer.parseInt(populationAsString);
            String landAreaAsString = split[4];
            landAreaAsString = landAreaAsString.replace(" ", "").replace(',', '.');
            double landArea = Double.parseDouble(landAreaAsString);
            return (double) population / landArea;
        };
        double density = lineToDensity.applyAsDouble(lineNewYork);
        System.out.println("Density of new York= " + density);
        Path path = Path.of("MyLearnings/src/main/resources/file.csv");

        try {
            Stream<String> lines = Files.lines(path, StandardCharsets.ISO_8859_1);

            try {
                DoubleSummaryStatistics summaryStatistics = lines.skip(1L).mapToDouble(lineToDensity).summaryStatistics();
                System.out.println("Statistics :" + summaryStatistics);
            } catch (Throwable var10) {
                if (lines != null) {
                    try {
                        lines.close();
                    } catch (Throwable var9) {
                        var10.addSuppressed(var9);
                    }
                }

                throw var10;
            }

            if (lines != null) {
                lines.close();
            }
        } catch (IOException var11) {
            var11.printStackTrace();
        }

    }
}


