import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class UitvalChecker {
	static Ledborg ledborg = new Ledborg();
	static String[] maandag = new String[9];
	static String[] dinsdag = new String[9];
	static String[] woensdag = new String[9];
	static String[] donderdag = new String[9];
	static String[] vrijdag = new String[9];

	public static void main(String[] args) {

		LeesRooster();

		DateFormat dateFormat = new SimpleDateFormat("u");
		DateFormat hourFormat = new SimpleDateFormat("H");
		Calendar cal = Calendar.getInstance();
		int day = Integer.parseInt(dateFormat.format(cal.getTime()));
		int hour = Integer.parseInt(hourFormat.format(cal.getTime()));
		if (hour > 17) {
			day++;
		}
		switch (day) {
		case 6:
			day = 1;
		case 7:
			day = 1;
		case 8:
			day = 1;
		case 1:
			CheckRooster(maandag);
			break;
		case 2:
			CheckRooster(dinsdag);
			break;
		case 3:
			CheckRooster(woensdag);
			break;
		case 4:
			CheckRooster(donderdag);
			break;
		case 5:
			for (String e : vrijdag) {
				System.out.println(e);
			}
			break;
		/*	case default:
		*	day =1;
		*	break;
		*/
		}

	}

	public static void LeesRooster() {
		int leerlingNummer = 100616;
		// Rajiv: 462, Kasper 616, Jesse 469
		String url = "http://www.cygnusgymnasium.nl/ftp_cg/roosters/infoweb/index.php?ref=2&id="
				+ leerlingNummer;
		Document infoweb = null;
		try {
			infoweb = Jsoup.connect(url).get();
		} catch (Exception e) {
			System.out.println("Link not found!");
		}
		infoweb.getElementsByClass("vrij").html("vrij");
		infoweb.getElementsByClass("vervallen").html("uitval");
		Elements uren = infoweb.select("tr.oneven > td , tr.even > td");
		// System.out.println(uren.text());

		short int dag = 1;
		int index = 0;

		for (Element uur : uren) {
			// System.out.println(index);
			switch (dag) {
			case 1:
				maandag[index] = uur.text();
				// System.out.println(uur.text());
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
	public static void CheckRooster(String[] dag)	
	{
		short int EersteUur = 0; //SHORT INTS!!!!
		try
		{
		while(dag[EersteUur].equals("vrij")){
			EersteUur++;
		}//accolades kunnen weg bij enkele statements
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			
		}
		EersteUur++;
		if(dag[EersteUur].equals("uitval"))
		{
			//Uitval eerste les uur!
			ledborg.ledColor(100);//Rood   niet helemaal netjes om INTS gebruiken bij STANDEN gebruik daarvoor ENUMS
		}
		else
		{
			System.out.println("Op het " + EersteUur + "e uur is er geen uitval");
			boolean uitval = false;
			for(String e : dag)
			{
				if (e.equals("uitval")){uitval = true;}
			}
			if(uitval)
			{
				ledborg.ledColor(011);//Blauw
			}
			else
			{
				ledborg.ledColor(000);
			}
		}
	}

}
