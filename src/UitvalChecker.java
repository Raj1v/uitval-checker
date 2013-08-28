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
		int uur = 0;
		if(uur > 4){
			day++;
		}
		switch(day){
		case 6:
			day = 1;
		case 7:
			day = 1;
		case 8:
			day = 1;
		case 1:
			for(String e : maandag){
				System.out.println(e);
			}
			break;
		case 2:
			for(String e : dinsdag){
				System.out.println(e);
			}
			break;
		case 3:
			for(String e : woensdag){
				System.out.println(e);
			}
			break;
		case 4:
			for(String e : donderdag){
				System.out.println(e);
			}
			break;
		case 5:
			for(String e : vrijdag){
				System.out.println(e);
			}
			break;
		}
		
		
		
		
		
	}

	public static void LeesRooster(){
		int leerlingNummer = 100463;
		//Rajiv: 462, Kasper 616
		String url = "http://www.cygnusgymnasium.nl/ftp_cg/roosters/infoweb/index.php?ref=2&id="
				+ leerlingNummer;
		Document infoweb = null;
		try {
			infoweb = Jsoup.connect(url).get();
		} catch (Exception e) {
			System.out.println("Link not found!");
		}
		infoweb.getElementsByClass("vrij").html("Vrij");
		infoweb.getElementsByClass("vervallen").html("Uitval!");
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