package Main;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.SwingUtilities;

import org.json.JSONException;
import org.json.JSONObject;

public class Main {
	public static final int xSize = 800;
	public static final int ySize = 800;
	public static int xPlayer = 235;
	public static int yPlayer = 300;
	public static String tableau = "A1";
	public static String time;
	
	public static void main(String[] args) {
		
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        time = sdf.format(cal.getTime()); // Obtients le temps de la machine
        //System.out.println( sdf.format(cal.getTime()) );
				
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
		          new Fenetre();
			}
		});
	}
	
	private static String readAll(Reader rd) throws IOException {
		StringBuilder sb = new StringBuilder();
		int cp;
		while ((cp = rd.read()) != -1) {
			sb.append((char) cp);
		}
		return sb.toString();
	}
	  

	public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
		URLConnection connection = new URL(url).openConnection();
		connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
		connection.connect();
		BufferedReader r  = new BufferedReader(new InputStreamReader(connection.getInputStream(), Charset.forName("UTF-8")));
		try {
		    String jsonText = readAll(r);
		    JSONObject json = new JSONObject(jsonText);
		    return json;
		} finally {
		    r.close();
		}
	}

}