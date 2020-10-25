package XML;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


public class PersonHandler extends DefaultHandler{
	
	private List<Person> persons = null;
	private Person person;	// �����Ķ���
	private String Tag;
	/**
	 * uri �����ռ�
	 * localName ����ǰ׺�ı�ǩ��
	 * qname ��ǰ׺�ı�ǩ��
	 * attribute ���Լ���
	 */

	public List<Person> getPersons() {
		return persons;
	}
	
	@Override
	public void startDocument() throws SAXException {
		super.startDocument();
		persons = new ArrayList<>();
		System.out.println("��ʼ�����ĵ�...");
	}
	
	@Override
	public void endDocument() throws SAXException {
		super.endDocument();
		System.out.println("�����ĵ�����...");
	}
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		super.startElement(uri, localName, qName, attributes);
		if("person".equals(qName)) {
			person = new Person();
			String personid = attributes.getValue("personid");
			person.setPersonid(personid);
		} 
		Tag = qName;
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		super.endElement(uri, localName, qName);
		if("person".equals(qName)) {
			persons.add(person);
			System.out.println(person);
		}
		Tag = null;
	}
	

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		super.characters(ch, start, length);
		if(Tag != null) {
			if("name".equals(Tag)) {
				person.setName(new String(ch, start, length));
			} else if ("address".equals(Tag)) {
				person.setAddress(new String(ch, start, length));
			} else if ("fax".equals(Tag)) {
				person.setFax(new String(ch, start, length));
			} else if ("tel".equals(Tag)) {
				person.setTel(new String(ch, start, length));
			}
		}
	}
}
