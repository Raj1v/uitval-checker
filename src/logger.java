import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
public class logger {
public void file_checker()
{
	File log = new File("uitval/log.log");
	File folder = new File("uitval");
	try
	{
	if(!folder.exists())
	{
		folder.mkdirs();
	}
	if(!log.exists())
	{
		log.createNewFile();
	}
	}
	catch(IOException e)
	{
		e.printStackTrace();
	}
}
public void logger_info()
{
	
}
public void logger_warning()
{
	
}
private String get_time()
{
	String time = null;
	Calendar cal = Calendar.getInstance();
	SimpleDateFormat sdf = new SimpleDateFormat("kk:mm:ss");
	time = "[" + sdf.format(cal.getTime()) + "]";
	return time;
}
}
