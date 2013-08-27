import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class UitvalChecker {
	public static void main(String[] args) {
		int leerlingNummer = 100616;
		String url = "http://www.cygnusgymnasium.nl/ftp_cg/roosters/infoweb/index.php?ref=2&id="
				+ leerlingNummer;
		Document infoweb = null;
		try {
			infoweb = Jsoup.connect(url).get();
		} catch (Exception e) {
			System.out.println("Link not found!");
		}
		infoweb.getElementsByClass("vrij").html("Vrij");
		Elements uren = infoweb.select(".oneven > td,.even > td");
		int c = 1;
		
		for (Element a : uren) {
			if (c == 5) {
				c = 1;
			}
			if (c == 1) {
				System.out.println(a.text());
			}
			c++;
		}
	}
}