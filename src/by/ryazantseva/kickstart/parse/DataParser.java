package by.ryazantseva.kickstart.parse;

import by.ryazantseva.kickstart.exception.InvalidInputDataException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.*;

public class DataParser {
    private static final String ONE_NUMBER = "-?\\d+\\.\\d";

    public List<Double> parseString(String stringWithPoints) throws InvalidInputDataException {
        if (stringWithPoints.isEmpty()) {
            throw new InvalidInputDataException("String is empty");
        }
        List<Double> points = new ArrayList<>();
        Pattern pattern = Pattern.compile(ONE_NUMBER);
        Matcher matcher = pattern.matcher(stringWithPoints);
        while (matcher.find()) {
            points.add(Double.parseDouble(stringWithPoints.substring(matcher.start(), matcher.end())));
        }
        return points;
    }


}
