
/*
 * This Weather class contains methods for Main.java to run
 * 
 */
import java.io.File;
import edu.duke.FileResource;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.csv.CSVParser;

public class Weather {

    // ? low temp ---------------------
    public static CSVRecord getLowTempMulti(Iterable<File> selected) {

        CSVRecord min = null;

        for (File f : selected) {
            FileResource fr = new FileResource(f);
            CSVParser parser = fr.getCSVParser();

            CSVRecord record = getLowTempSingle(parser);
            if (min == null) {
                min = record;
            } else {
                double minTemp = Double.parseDouble(min.get("TemperatureF"));
                double recTemp = Double.parseDouble(record.get("TemperatureF"));
                if (minTemp > recTemp) {
                    min = record;
                }
            }
        }
        return min;
    }

    public static CSVRecord getLowTempSingle(CSVParser parser) {

        CSVRecord min = null;

        for (CSVRecord record : parser) {
            if (min == null) {
                min = record;
            } else {
                if (record.get("TemperatureF").contentEquals("-9999"))
                    continue;
                double minTemp = Double.parseDouble(min.get("TemperatureF"));
                double recTemp = Double.parseDouble(record.get("TemperatureF"));
                if (minTemp > recTemp) {
                    min = record;
                }
            }
        }
        return min;
    }

    // ? high temp ---------------------
    public static CSVRecord getHighTempMulti(Iterable<File> selected) {

        CSVRecord max = null;

        for (File f : selected) {
            FileResource fr = new FileResource(f);
            CSVParser parser = fr.getCSVParser();

            CSVRecord record = getHighTempSingle(parser);
            if (max == null) {
                max = record;
            } else {
                double maxTemp = Double.parseDouble(max.get("TemperatureF"));
                double recTemp = Double.parseDouble(record.get("TemperatureF"));
                if (maxTemp < recTemp) {
                    max = record;
                }
            }
        }
        return max;
    }

    public static CSVRecord getHighTempSingle(CSVParser parser) {

        CSVRecord max = null;

        for (CSVRecord record : parser) {
            if (max == null) {
                max = record;
            } else {
                if (record.get("TemperatureF").contentEquals("-9999"))
                    continue;
                double maxTemp = Double.parseDouble(max.get("TemperatureF"));
                double recTemp = Double.parseDouble(record.get("TemperatureF"));
                if (maxTemp < recTemp) {
                    max = record;
                }
            }
        }
        return max;
    }

    // ? low hum ---------------------
    public static CSVRecord getLowHumMulti(Iterable<File> selected) {

        CSVRecord min = null;

        for (File f : selected) {
            FileResource fr = new FileResource(f);
            CSVParser parser = fr.getCSVParser();

            CSVRecord record = getLowHumSingle(parser);
            if (min == null) {
                min = record;
            } else {
                double minHum = Double.parseDouble(min.get("Humidity"));
                double recHum = Double.parseDouble(record.get("Humidity"));
                if (minHum > recHum) {
                    min = record;
                }
            }
        }
        return min;
    }

    public static CSVRecord getLowHumSingle(CSVParser parser) {

        CSVRecord min = null;

        for (CSVRecord record : parser) {
            if (min == null) {
                min = record;
            } else {
                if (record.get("Humidity").contentEquals("N/A"))
                    continue;
                double minHum = Double.parseDouble(min.get("Humidity"));
                double recHum = Double.parseDouble(record.get("Humidity"));
                if (minHum > recHum) {
                    min = record;
                }
            }
        }
        return min;
    }

    // ? high hum ---------------------
    public static CSVRecord getHighHumMulti(Iterable<File> selected) {

        CSVRecord max = null;

        for (File f : selected) {
            FileResource fr = new FileResource(f);
            CSVParser parser = fr.getCSVParser();

            CSVRecord record = getHighHumSingle(parser);
            if (max == null) {
                max = record;
            } else {
                double maxHum = Double.parseDouble(max.get("Humidity"));
                double recHum = Double.parseDouble(record.get("Humidity"));
                if (maxHum < recHum) {
                    max = record;
                }
            }
        }
        return max;
    }

    public static CSVRecord getHighHumSingle(CSVParser parser) {

        CSVRecord max = null;

        for (CSVRecord record : parser) {
            if (max == null) {
                max = record;
            } else {
                if (record.get("Humidity").contentEquals("N/A"))
                    continue;
                double maxHum = Double.parseDouble(max.get("Humidity"));
                double recHum = Double.parseDouble(record.get("Humidity"));
                if (maxHum < recHum) {
                    max = record;
                }
            }
        }
        return max;
    }
}
