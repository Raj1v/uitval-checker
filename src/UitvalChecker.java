import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class UitvalChecker {
	
	static String[] maandag = new String[9];
	static String[] dinsdag = new String[9];
	static String[] woensdag = new String[9];
	static String[] donderdag = new String[9];
	static String[] vrijdag = new String[9];
	
	public static void main(String[] args) {
		
		LeesRooster();
		
		DateFormat dateFormat = new SimpleDateFormat("u");
		Calendar cal = Calendar.getInstance();
		int day = Integer.parseInt(dateFormat.format(cal.getTime()));
		
		switch(day){
		case 1:
			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			break;
		case 5:
			break;
		case 6:
			break;
		case 7:
			break;
		}
		
		for(String e : maandag){
			System.out.println(e);
		}
		
		
	}

	public static void LeesRooster(){
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
		Elements uren = infoweb.select("tr.oneven > td , tr.even > td");
		//System.out.println(uren.text());
		
		
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
		
	}
}