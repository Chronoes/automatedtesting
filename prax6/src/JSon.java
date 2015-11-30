
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.net.URL;


public class JSon {
    public static void main(String[] args){
        JSon a = new JSon();
        try {
            URL comments = new URL("http://jsonplaceholder.typicode.com/comments");
            URL todos = new URL("http://jsonplaceholder.typicode.com/todos");
            JSONArray commentsArray = (JSONArray) a.retrieveJson(comments);
            JSONArray todosArray = (JSONArray) a.retrieveJson(todos);
            System.out.print(a.getData(commentsArray, todosArray));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private JSONParser parser;

    public JSon() {
        parser = new JSONParser();
    }

    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    private Object retrieveJson(URL url) throws IOException, ParseException {
        InputStream is = url.openStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));
        return parser.parse(readAll(bufferedReader));
    }

    protected int getData(JSONArray array1, JSONArray array2) {
        return array1.size() - array2.size();
    }
}
