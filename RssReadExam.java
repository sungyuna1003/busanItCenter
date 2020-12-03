package tib;



import java.io.IOException;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public class RssReadExam {

	// http://www.kma.go.kr/wid/queryDFS.jsp?gridx=59&gridy=125
	private String rssFeed = "http://www.kma.go.kr/wid/queryDFS.jsp?gridx=%s&gridy=%s"; // �ּ�
	String MAIN_TITLE = "�ص���û�";
	String sql = "select MAIN_TITLE, gridx, gridy from travel where uc_seq = ?";
	/**
	 * �׽�Ʈ�� ���� ���θ޼ҵ�
	 */
	public static void main(String[] args) {
		RssReadExam r = new RssReadExam();
		r.getTownForecast("97", "74");
	}

	/**
	 * �ش� ��ǥ�� ���� ������ ��ȯ.
	 */
	public List<Map<String, String>> getTownForecast(String x, String y) {

		List<Map<String, String>> result = new ArrayList<Map<String, String>>();

		try {

			SAXBuilder parser = new SAXBuilder();
			parser.setIgnoringElementContentWhitespace(true);

			// URL url = new URL(rssFeed);
			// InputSource is = new InputSource(url.openStream());
			// Document doc = parser.build(is);

			String url = String.format(rssFeed, x, y);
			Document doc = parser.build(url);
			Element root = doc.getRootElement();

			Element channel = root.getChild("body");
			List<Element> list = channel.getChildren("data");

			// for (int i=0; i<1; i++) {

			Element el = (Element) list.get(0);
			Map<String, String> data = new LinkedHashMap<String, String>();
			/*
			 * data.put("seq", el.getAttributeValue("seq")); //48�ð��� ���° ���� ����Ŵ
			 * data.put("hour",el.getChildTextTrim("hour") ); //���׿��� 3�ð� ����
			 * data.put("day",el.getChildTextTrim("day") ); //1��°�� (0: ����/1: ����/2: ��)
			 * data.put("temp",el.getChildTextTrim("temp") ); //���� �ð��µ�
			 * data.put("tmx",el.getChildTextTrim("tmx") ); //�ְ� �µ�
			 * data.put("tmn",el.getChildTextTrim("tmn") ); //���� �µ�
			 * data.put("sky",el.getChildTextTrim("sky") ); //�ϴ� �����ڵ� (1: ����, 2: ��������,
			 * 3:��������, 4:�帲) 
			 * data.put("pty",el.getChildTextTrim("pty") ); //���� �����ڵ� (���� : 0, �� : 1, ��/�� : 2, �� : 3)
			 * data.put("wfkor",el.getChildTextTrim("wfKor") ); //���� �ѱ��� 
			 *data.put("wfEn",el.getChildTextTrim("wfEn") ); //���� ����
			 * data.put("pop",el.getChildTextTrim("pop") ); //���� Ȯ��%
			 * data.put("r12",el.getChildTextTrim("r12") ); //12�ð� ���� ������
			 * data.put("s12",el.getChildTextTrim("s12") ); //12�ð� ���� ������
			 * data.put("ws",el.getChildTextTrim("ws") ); //ǳ��(m/s)
			 * data.put("wd",el.getChildTextTrim("wd") ); //ǳ�� (0~7:��, �ϵ�, ��, ����, ��, ����, ��,
			 * �ϼ�) data.put("wdKor",el.getChildTextTrim("wdKor") ); //ǳ�� �ѱ���
			 * data.put("wdEn",el.getChildTextTrim("wdEn") ); //ǳ�� ����
			 * data.put("reh",el.getChildTextTrim("reh") ); //���� %
			 * data.put("r06",el.getChildTextTrim("r06") ); //6�ð� ���� ������
			 * data.put("s06",el.getChildTextTrim("s06") ); //6�ð� ���� ������
			 */
			System.out.println("�������� : " + MAIN_TITLE);
			System.out.println("������ : " + el.getChildTextTrim("temp"));
			System.out.println("���糯�� : " +  el.getChildTextTrim("wfKor"));
			System.out.println("�ϴ� ���� : " +  el.getChildTextTrim("sky"));
			System.out.println("�������� : " + el.getChildText("pty"));
			
			String sky = el.getChildTextTrim("sky");
			if (sky.equals("1")) {
                System.out.println("tib/sunshien.png");
			} else if(sky.equals("2")) {
				System.out.println("tib/sunny_cloudy1.png");
			}else if(sky.equals("3")) {
				System.out.println("tib/sunny_cloudy2.png");
			}else if(sky.equals("")) {
				System.out.println("tib/over_cloudy.png");
			}
           
			String pty = el.getChildTextTrim("pty");
			if (pty.equals("0")) {
                System.out.println("tib/no_rain.png");
			} else if(pty.equals("1")) {
				System.out.println("tib/rain.png");
			}else if(pty.equals("2")) {
				System.out.println("tib/rain_snow.png");
			}else if(pty.equals("3")) {
				System.out.println("tib/snow.png");
			}

          
			
			//System.out.println(data);
			result.add(data);
			// }

		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return result;
	}
}