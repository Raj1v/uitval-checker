import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


    public class Config
    {
        static File config = new File("uitval/config.xml");
 
        public static String Get(String setting)
        {
        	try{
        	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        	Document doc = dBuilder.parse(config);
        	
        	doc.getDocumentElement().normalize();
        	NodeList settings = doc.getDocumentElement().getChildNodes();
        	
        	for (int temp = 0; temp < settings.getLength(); temp++) {
        		Node node = settings.item(temp);
        		if(node.getNodeType() == Node.ELEMENT_NODE && node.getNodeName() == setting){
        			return node.getNodeValue();
        			
        		}
        	}
        	}
        	catch(Exception e){
        		//TODO : Error handling
        	}
        	return null;
            
        }
 
        public static void Set(String setting, String value)
        {
            XDocument file = XDocument.Load(configFile);
            try
            {
                XElement element = file.Root.Elements(setting).Single();
                element.Value = value;
                file.Save(configFile);
            }
            catch (InvalidOperationException) //This exception occurs when a the setting doesn't already exist
            {
                XElement element = new XElement(setting, value);
                file.Root.Add(element);
                file.Save(configFile);
            }
        }
 
        public static void Reset()
        {
            XDocument file = new XDocument();
            XElement root = new XElement("config");
 
            XElement ip = new XElement("ip", "");
            XElement version = new XElement("version", "");
            XElement limit = new XElement("limit", "");
 
            //Add the elements as childs of the root
            root.Add(ip);
            root.Add(version);
            root.Add(limit);
 
            file.Add(root);
            file.Save(configFile);
        }
    }