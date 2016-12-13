package org.rbkpro.campus;
import org.junit.Before;
import org.junit.Test;
import org.rbkpro.campus.AnalyticsService;
import org.rbkpro.campus.JSONFileReader;
import org.rbkpro.campus.Word;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
/**
 * Created by BOUNHH on 07-10-2016.
 */
public class MainClass {
    public static void main(String[] args) throws Exception {

        JSONFileReader reader = new JSONFileReader();
        AnalyticsService service = new AnalyticsService();
        PrintStream out = new PrintStream(new FileOutputStream("Scores.txt"));
        int count = 1;

        reader.readFile("AFINN-111.txt");

        List<Word> words = reader.getWords();

        for (String tweet : reader.getTweets("3tweets.json")) {
            System.out.print("Tweet number :"+ count + " " + tweet +" score is : ");
            System.out.println(service.getTweetScore(words, tweet));
            count ++;
            System.setOut(out);
        }
    }
}
