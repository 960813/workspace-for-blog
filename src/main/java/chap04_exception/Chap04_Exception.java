package chap04_exception;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

/**
 * @Author Heli
 */
public class Chap04_Exception {

    public static Integer readNumber(BufferedReader reader) throws IOException {
        try (reader) {
            String line = reader.readLine();
            return Integer.parseInt(line);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new StringReader("239"));
        System.out.println(readNumber(reader));
    }
}
