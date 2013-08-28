import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class UitvalChecker {
	public static void main(String[] args) {
		int leerlingNummer = 100463;
		String url = "http://www.cygnusgymnasium.nl/ftp_cg/roosters/infoweb/index.php?ref=2&id="
				+ leerlingNummer;
		Document infoweb = null;
		try {
			infoweb = Jsoup.connect(url).get();
		} catch (Exception e) {
			System.out.println("Link not found!");
		}
		infoweb.getElementsByClass("vrij").html("Vrij");
		Elements uren = infoweb.select("tr.oneven > td , tr.even > td");
		//System.out.println(uren.text());
		
		String[] maandag = new String[9];
		String[] dinsdag = new String[9];
		String[] woensdag = new String[9];
		String[] donderdag = new String[9];
		String[] vrijdag = new String[9];
		
		int dag = 1;
		int index = 0;
		
		for(Element uur : uren){
			//System.out.println(index);
			switch(dag){
				case 1:
					maandag[index] = uur.text();
					//System.out.println(uur.text());
					dag++;
					break;
				case 2:
					dinsdag[index] = uur.text();
					dag++;
					break;
				case 3:
					woensdag[index] = uur.text();
					dag++;
					break;
				case 4:
					donderdag[index] = uur.text();
					dag++;
					break;
				case 5:
					vrijdag[index] = uur.text();
					dag = 1;
					index++;
					break;
			}
			
		}
		for(String e : woensdag){
			System.out.println(e);
		}
		/*int c = 1;
		
		for (Element a : uren) {
			if (c == 5) {
				c = 1;
			}
			if (c == 1) {
				System.out.println(a.text());
			}
			c++;
		}*/
		
	}
}