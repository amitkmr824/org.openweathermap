package open_Weather_XML;

import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;

import org.testng.TestNG;
import org.testng.xml.Parser;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

public class TestNgXml {

	public void testNGxmlSuite() {
		String xmlFileName = "testng.xml";
		// List<XmlSuite> suites = new ArrayList<XmlSuite>();
		try {
			List<XmlSuite> suites = (List<XmlSuite>) (new Parser(xmlFileName).parse());

			List<XmlClass> classes = new ArrayList<XmlClass>();

			TestNG tng = new TestNG();
			tng.setXmlSuites(suites);
			tng.run();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		TestNgXml tngxml = new TestNgXml();
		tngxml.testNGxmlSuite();

	}
}
