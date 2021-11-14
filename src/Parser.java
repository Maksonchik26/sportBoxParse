import java.io.IOException;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Parser {
    public static void main(String[] args) throws IOException{
        System.out.println(" Хозяева   Счет   Гости");
        Document page = getPage();
        Element tab = page.select("div[class=col-lg-4 col-md-4 col-sm-6 col-xs-12]").first();
        Elements events = tab.select("div[class=b-onlines-box__side]");
        for (Element event : events) {
            String team1f = event.select("div[class=b-onlines-box__side_left]").text();
            String result = event.select("div[class=count]").text();
            String team2 = event.select("div[class=b-onlines-box__side_right]").text();
            String team1;
            if (team1f.startsWith("1") || team1f.startsWith("0") || team1f.startsWith("2")) {
                team1 = team1f.substring(6);
            }
            else {
                team1 = team1f;
            }
            System.out.println(team1 + " " + result + " " + team2);
        }



    }

    private static Document getPage() throws IOException {
        String url = "https://news.sportbox.ru/stats";
        Document page = Jsoup.parse(new URL(url), 5000);
        return page;
    }
}
