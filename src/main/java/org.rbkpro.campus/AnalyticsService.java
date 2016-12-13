package org.rbkpro.campus;

import java.util.Arrays;
import java.util.List;

/**
 * Created by BOUNHH on 07-10-2016.
 */

public class AnalyticsService {

    int openion;

    public AnalyticsService() {

    }

    public int getTweetScore(List<Word> words, String tweet){
        openion = 0;
        tweet = tweet.toLowerCase();
        String[] splited = tweet.split("\\b+");

        for(Word word : words){
            if (Arrays.asList(splited).contains(word.getContent().toLowerCase())){
                openion = openion + word.getValue();
//                System.out.println(" This is the word : " + word.getContent() + " / " + word.getValue());
            }
        }
        return openion;
    }

}
