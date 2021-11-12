package pakeg;

import java.net.HttpURLConnection;

import demo1.ChromeDriver;
import demo1.ChromeOptions;
import demo1.HashMap;
import demo1.Iterator;
import demo1.List;
import demo1.Map;
import demo1.Set;
import demo1.URL;
import demo1.WebDriver;
import demo1.WebElement;

public class MyFirstCodepush {
	public static void main(String[] args) {
        URL url = null;
        HttpURLConnection connection = null;
        System.setProperty("webdriver.chrome.driver", "/Users/ninja/drivers/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.target.com/");



        List<WebElement> elements = driver.findElements(By.tagName("a"));

        Iterator<WebElement> iterator = elements.iterator();

        HashMap<String, String> data = new HashMap<>();

        while (iterator.hasNext()) {
           String link = iterator.next().getAttribute("href");

            try {
                url = new URL(link);
                connection = (HttpURLConnection) url.openConnection();
                connection.setConnectTimeout(5000);
                connection.connect();
                if (connection.getResponseCode() >= 400) {
                    data.put(link, connection.getResponseMessage());
                } else {
                    data.put(link, connection.getResponseMessage());
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        Set<Map.Entry<String, String>> entrySet = data.entrySet();
        Iterator<Map.Entry<String, String>> iterator1 = entrySet.iterator();

        while (iterator1.hasNext()) {
            Map.Entry<String, String> b = iterator1.next();

            if (b.getValue().equalsIgnoreCase("OK")) {
                System.out.println(b.getKey());
            }
        }





    }
}
