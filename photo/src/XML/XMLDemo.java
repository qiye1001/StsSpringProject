package XML;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.junit.Test;
import org.xml.sax.SAXException;

public class XMLDemo {
	
	@Test
	public void test01() throws ParserConfigurationException, SAXException, IOException {
		
		// ����һ��sax��������������
		SAXParserFactory newInstance = SAXParserFactory.newInstance();
		// ͨ��������ȡsax�Ľ�����
		SAXParser newSAXParser = newInstance.newSAXParser();
		// �������������Լ���д��
		PersonHandler personHandler = new PersonHandler();
		// ���н���
		InputStream is = Thread.currentThread().getContextClassLoader()
				.getResourceAsStream("XML/Person.xml");
		newSAXParser.parse(is, personHandler);
	
		List<Person> list = personHandler.getPersons();
		list.forEach(System.out::println);
		
	}
}
