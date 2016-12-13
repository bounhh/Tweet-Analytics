package org.rbkpro.campus;

import org.json.JSONObject;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by BOUNHH on 07-10-2016.
 */

public class JSONFileReader {

    private List<String> tweests;
    private ArrayList<Word> words = new ArrayList<Word>();;

    public List<String> getTweets(String fileName)throws Exception{
        tweests = new ArrayList<String>();
        FileReader file = new FileReader(fileName);
        try(BufferedReader br = new BufferedReader(file)) {
            for(String line; (line = br.readLine()) != null; ) {
                if(isLineJson(line)){
                    tweests.add(getTweet(line));
                }
            }
        }
        return tweests;
    }

    private boolean isLineJson(String line) {
        boolean value;
        if (line.indexOf("text") >= 0) {
            value = true;
        }else{
            value = false;
        }


        return value;
    }


    public void readFile(String fileName)throws Exception{
        try(BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            for(String line; (line = br.readLine()) != null; ) {
                addInWords(line);
            }
        }
    }

    private void addInWords(String line) {
        Word word = new Word();
        Scanner scanner = new Scanner(line).useDelimiter("\t");
        word.setContent(scanner.next());
        word.setValue(Integer.parseInt(scanner.next()));
        words.add(word);
        scanner.reset();
    }

    public ArrayList<Word> getWords(){
        return words;
    }



    public String getTweet(String jsonLine) throws Exception{
        JSONObject json = new JSONObject(jsonLine);
        return json.getString("text");
    }

}
