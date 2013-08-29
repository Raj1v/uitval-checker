import java.io.IOException;


public class Ledborg {

public void ledColor(int RGB)
{
		try {
			Process p = Runtime.getRuntime().exec(new String[]{"bash","-c","echo \""+RGB+"\" > /dev/ledborg"});
		} catch (IOException e) {
			e.printStackTrace();
		}
	
}
//
}
