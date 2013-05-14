import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class UitvalChecker {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try
		{
		System.out.println("UitvalChecker V1.0");
		URL infoweb = new URL("http://www.cygnusgymnasium.nl/ftp_cg/roosters/infoweb/index.php?ref=5&id='CG3A'");
		BufferedReader bf = new BufferedReader(new InputStreamReader(infoweb.openStream()));
		String html = null;
		String line = null;
		while((line = bf.readLine())!=null)
		{
			html = html + "\n" + line;
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		}
	

}
