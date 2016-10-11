import java.io.*;
import java.net.*;

public class GetInfo {
    public static void main (String[] args) throws IOException {
        BufferedReader username = new BufferedReader(new InputStreamReader(System.in));
        String input_username;
        System.out.println("Input username");
        input_username = username.readLine();
        //System.out.println(input_username);
        String link_string = "http://www.ecs.soton.ac.uk/people/";
        link_string = link_string + input_username;
        //System.out.println(link_string);
        URL userURL = new URL(link_string);
        BufferedReader in = new BufferedReader(
        new InputStreamReader(userURL.openStream()));
        String property;
        int i = 0;
        while ((property = in.readLine()) != null && i < 95) {
            //System.out.println(property);
            i++;
        }
        //System.out.println(property);
        int name_position = property.indexOf("property=\"name\">") + 16;
        String almost_there = property.substring(name_position);
        int end_position = almost_there.indexOf("<");
        System.out.println(almost_there.substring(0,end_position));
        in.close();
   }
}
