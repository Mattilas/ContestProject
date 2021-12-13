import org.json.JSONArray;
import org.json.JSONObject;

import java.awt.image.FilteredImageSource;
import java.io.*;
import java.util.ArrayList;

public class ContestParticipantsList {

    public static void main(String[] args) throws IOException {

        //Retrieving retweetters raw data
        String retweetsRawData = "";
        //First file
        String fileNameRetweets = "/home/masoquet96/Documents/ConcoursTwitter/retweets.txt";
        File fileRetweets = new File(fileNameRetweets);
        FileReader fr = new FileReader(fileRetweets);
        BufferedReader br = new BufferedReader(fr);
        String line;
        while((line = br.readLine()) != null){
            //process the line
            retweetsRawData+=line;
        }

        //System.out.println(retweetsRawData);

        //Parsing retweetters raw data
        ArrayList<String> retwetters = new ArrayList<>();
            //Parsing retweetters
        JSONArray retweetersRawList = new JSONArray(retweetsRawData);
        //System.out.println(retweetersRawList.length() );
        for (int i = 0; i < retweetersRawList.length(); i++) {

            //retweeterData
            JSONObject retweeterData = retweetersRawList.getJSONObject(i);
            JSONObject retweeterDataDetails = retweeterData.getJSONObject("user");
            //Retweeter name
            String retweeterName = retweeterDataDetails.getString("screen_name");
            //System.out.println(retweeterName);
            retwetters.add(retweeterName);

        }


        //Parsing copied Data
        String copiedData = "DGBCoin,\n" +
                "Riocation,\n" +
                "AllainVincent5,\n" +
                "isear77,\n" +
                "metabarbz,\n" +
                "RiddlerXrp,\n" +
                "Princesstoe,\n" +
                "iamthe_greatone,\n" +
                "CatCryptocom,\n" +
                "1Ahhyeah,\n" +
                "baska_greg,\n" +
                "TChipperfield,\n" +
                "HimalayanSalt9,\n" +
                "swervee93,\n" +
                "My1wayticket,\n" +
                "HypeStian,\n" +
                "mas_seb,\n" +
                "xXIrToKeNXx,\n" +
                "M_LoadedLion,\n" +
                "PirjolVlad,\n" +
                "jimscorpy,\n" +
                "LIFESECRET123,\n" +
                "sereszsolthu,\n" +
                "wh408,\n" +
                "buntoh1997,\n" +
                "Mika05057131,\n" +
                "IvanTokmakchiev,\n" +
                "slickram,\n" +
                "niko_wii,\n" +
                "Wynnpokerstar,\n" +
                "m20955596,\n" +
                "Oberon45k,\n" +
                "vagkaa,\n" +
                "SJB6991,\n" +
                "SYLVONMON,\n" +
                "VApollo83,\n" +
                "earphorny,\n" +
                "lprullo,\n" +
                "Koalofico,\n" +
                "ycjoo,\n" +
                "CryptosDiCaprio,\n" +
                "spacemonkey207,\n" +
                "BosRense,\n" +
                "djlindsey74,\n" +
                "ESandillon,\n" +
                "moonmovee,\n" +
                "socialpersonguy,\n" +
                "mathgril,\n" +
                "monishb21,\n" +
                "kharbouchii,\n" +
                "66Mhz";
        String[] manualListOfRetweetwers = copiedData.replace("\n","").split(",");
        for (String retweeter:manualListOfRetweetwers) {
            ////System.out.println(retweeter);
            retwetters.add(retweeter);
        }


        //System.out.println(retwetters.size());
        System.out.println("--------------------------------------");



        //Retrieving followers raw data
        String rawData_page1 = "";
            //First file
        String fileName = "/home/masoquet96/Documents/ConcoursTwitter/followers_page1.txt";
        File file = new File(fileName);
        fr = new FileReader(file);
        br = new BufferedReader(fr);
        while((line = br.readLine()) != null){
            //process the line
            rawData_page1+=line;
        }
            //Second file
        String rawData_page2 = "";
        String fileName2 = "/home/masoquet96/Documents/ConcoursTwitter/followers_page2.txt";
        File file2 = new File(fileName2);
        fr = new FileReader(file2);
        br = new BufferedReader(fr);
        while((line = br.readLine()) != null){
            //process the line
            rawData_page2+=line;
        }
            //Troisième file
        String rawData_page3 = "";
        String fileName3 = "/home/masoquet96/Documents/ConcoursTwitter/followers_page3.txt";
        File file3 = new File(fileName3);
        fr = new FileReader(file3);
        br = new BufferedReader(fr);
        while((line = br.readLine()) != null){
            //process the line
            rawData_page3+=line;
        }

        //Parsing followers raw data
        ArrayList<String> followers = new ArrayList<>();
            //Parsing followers in page 1
        JSONObject obj_page1 = new JSONObject(rawData_page1);
        JSONArray users_page1 = obj_page1.getJSONArray("users");
        for (int i = 0; i < users_page1.length(); i++) {
            followers.add(users_page1.getJSONObject(i).getString("screen_name"));
            //System.out.println(users_page1.getJSONObject(i).getString("screen_name"));
        }
            //Parsing followers in page 2
        JSONObject obj_page2 = new JSONObject(rawData_page2);
        JSONArray users_page2 = obj_page2.getJSONArray("users");
        for (int i = 0; i < users_page2.length(); i++) {
            followers.add(users_page2.getJSONObject(i).getString("screen_name"));
            //System.out.println(users_page2.getJSONObject(i).getString("screen_name"));
        }
            //Parsing followers in page 3
        JSONObject obj_page3 = new JSONObject(rawData_page3);
        JSONArray users_page3 = obj_page3.getJSONArray("users");
        for (int i = 0; i < users_page3.length(); i++) {
            followers.add(users_page3.getJSONObject(i).getString("screen_name"));
            //System.out.println(users_page3.getJSONObject(i).getString("screen_name"));
        }


        //System.out.println(followers.size());

        //Creation of final list
        ArrayList<String> finalList = new ArrayList<>(retwetters);
        for (String retweeter: retwetters) {
            if(followers.contains(retweeter)){
                finalList.add(retweeter);
            }
        }


        //Final list display
        for (String retweeter: finalList) {
            System.out.println(retweeter);
        }


    }


}
