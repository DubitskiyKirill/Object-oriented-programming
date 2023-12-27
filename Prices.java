import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Prices {
    public static void main(String[] args) {
        File file = new File(""); // Создаем объект File для указания пути к файлу
        try (BufferedReader br = new BufferedReader(new FileReader(file))) { // Создаем объект BufferedReader для чтения данных из файла
            String line;
            while ((line = br.readLine()) != null) { // Читаем строки из файла, пока не достигнем конца файла
                Pattern urePattern = Pattern.compile("\\d+\\.\\d{1,2}\\s+(USD|RUR|EU)"); // Создаем объект Pattern для поиска цен
                Matcher ureMatcher = urePattern.matcher(line); // Создаем объект Matcher для поиска цен в строке
                while (ureMatcher.find()) { // Пока находим цены в строке
                    System.out.println(ureMatcher.group()); // Выводим найденную цену на экран
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
