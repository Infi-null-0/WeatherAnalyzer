import java.io.File;
import org.apache.commons.csv.CSVRecord;

import edu.duke.DirectoryResource;

/**
 * This is the main class and it runs the main method
 * U can use it to analyze the csv data on weather
 */
public class Main {

    public static void run() {

        // start
        System.out.println(">> Start");

        // select file
        System.out.println(">> Select the file\n");
        DirectoryResource dr = new DirectoryResource();
        Iterable<File> selected = dr.selectedFiles();

        // temperature
        System.out.println("\u001B[36mTEMPERATURE\u001B[0m");
        CSVRecord minTemp = Weather.getLowTempMulti(selected);
        CSVRecord maxTemp = Weather.getHighTempMulti(selected);
        System.out.println(
                "\n>> lowest temperature was recorded in  date: \u001B[35m" + minTemp.get("DateUTC").substring(0, 10)
                        + "\u001B[0m as \u001B[34m" + minTemp.get("TemperatureF") + "F\u001B[0m at time: \u001B[35m"
                        + minTemp.get("DateUTC").substring(10) + "\u001B[0m");

        System.out.println(
                "\n>> highest temperature was recorded in  date: \u001B[35m" + maxTemp.get("DateUTC").substring(0, 10)
                        + "\u001B[0m as \u001B[31m" + maxTemp.get("TemperatureF") + "F\u001B[0m at time: \u001B[35m"
                        + maxTemp.get("DateUTC").substring(10) + "\u001B[0m");

        // humidity
        System.out.println("\n\u001B[36mHUMIDITY\u001B[0m");
        CSVRecord minHum = Weather.getLowHumMulti(selected);
        CSVRecord maxHum = Weather.getHighHumMulti(selected);

        System.out.println(
                "\n>> lowest humidity was recorded in  date: \u001B[35m" + minHum.get("DateUTC").substring(0, 10)
                        + "\u001B[0m as \u001B[34m" + minHum.get("Humidity") + "\u001B[0m at time: \u001B[35m"
                        + minHum.get("DateUTC").substring(10) + "\u001B[0m");

        System.out.println(
                "\n>> highest humidity was recorded in  date: \u001B[35m" + maxHum.get("DateUTC").substring(0, 10)
                        + "\u001B[0m as \u001B[31m" + maxHum.get("Humidity") + "\u001B[0m at time: \u001B[35m"
                        + maxHum.get("DateUTC").substring(10) + "\u001B[0m");

        System.out.println("\n>> End");
    }

    public static void main(String[] args) {
        run();
    }
}