package com.example.commons.text;

import org.apache.commons.text.similarity.LevenshteinDistance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TextSimilarity {

    private static final Logger logger = LoggerFactory.getLogger(TextSimilarity.class);

    public static void main(String args[]) {

        var left = "iphone";
        var right = "iPhone";


        var levenshteinDistance = LevenshteinDistance.getDefaultInstance();
        var result = levenshteinDistance.apply(left, right);
        logger.info("Edit Distance = {}", result);


    }

}
