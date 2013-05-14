import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Calendar;
public class logger {
public void file_checker()
{
	File log = new File("/uitval/log.log");
	File folder = new File("/uitval");
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
private File get_log()
{
	File log = new File("/uitval/log.log");
	if(!log.exists()){this.file_checker();}
	return log;
}
public void logger_info()
{
	
	try {
		Writer output;
		output = new BufferedWriter(new FileWriter(this.get_log(),true));
		output.append("\n[info]" + this.get_time() + " Test");
		output.close();
	} catch (IOException e) {
		e.printStackTrace();
	} 
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
