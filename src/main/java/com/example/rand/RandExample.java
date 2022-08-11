package com.example.rand;

import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.rng.simple.RandomSource;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashSet;

public class RandExample {

    private static final int TRY_COUNT = 1000;
    private static final int RAND_RANGE = 1000;

    public static void main(String args[]) throws NoSuchAlgorithmException {
        // 本当は100回やった結果の平均値でやるのが正しいけど
        commonsRandUtil();
        secureRand();
        commonsRng();
        mathRand();
    }

    static void secureRand() throws NoSuchAlgorithmException {

        var rand = SecureRandom.getInstance("SHA1PRNG");
        var result = new ArrayList<Integer>();
        for (int i = 0; i < TRY_COUNT; i++) {
            var value = rand.nextInt(RAND_RANGE);
            result.add(value);
        }

        var uniqResult = new HashSet<>(result);
        var allCount = result.size();
        var uniqCount = uniqResult.size();
        var duplicateCount = TRY_COUNT - uniqResult.size();

        System.out.println("Commons RandUtils:");
        System.out.println("All Count: " + allCount);
        System.out.println("Uniq Count: " + uniqCount);
        System.out.println("Duplicate Count: " + duplicateCount);
        System.out.println("Duplicate Rate: " + (duplicateCount * 100) / TRY_COUNT);
        System.out.println("------------------------");
    }

    static void commonsRandUtil() {

        var result = new ArrayList<Integer>();
        for (int i = 0; i < TRY_COUNT; i++) {
            var value = RandomUtils.nextInt(0, RAND_RANGE);
            result.add(value);
        }


        var uniqResult = new HashSet<>(result);
        var allCount = result.size();
        var uniqCount = uniqResult.size();
        var duplicateCount = TRY_COUNT - uniqResult.size();

        System.out.println("Commons RandUtils:");
        System.out.println("All Count: " + allCount);
        System.out.println("Uniq Count: " + uniqCount);
        System.out.println("Duplicate Count: " + duplicateCount);
        System.out.println("Duplicate Rate: " + (duplicateCount * 100) / TRY_COUNT);
        System.out.println("------------------------");
    }

    static void commonsRng() {
        var rng = RandomSource.MT_64.create();
        var result = new ArrayList<Integer>();
        for (int i = 0; i < TRY_COUNT; i++) {
            var value = rng.nextInt(RAND_RANGE);
            result.add(value);
        }

        var uniqResult = new HashSet<>(result);
        var allCount = result.size();
        var uniqCount = uniqResult.size();
        var duplicateCount = TRY_COUNT - uniqResult.size();

        System.out.println("Commons RNG:");
        System.out.println("All Count: " + allCount);
        System.out.println("Uniq Count: " + uniqCount);
        System.out.println("Duplicate Count: " + duplicateCount);
        System.out.println("Duplicate Rate: " + (duplicateCount * 100) / TRY_COUNT);
        System.out.println("------------------------");
    }

    static void mathRand() {
        var result = new ArrayList<Integer>();
        for (int i = 0; i < TRY_COUNT; i++) {
            var value = (int) Math.ceil(Math.random() * RAND_RANGE);
            result.add(value);
        }

        var uniqResult = new HashSet<>(result);
        var allCount = result.size();
        var uniqCount = uniqResult.size();
        var duplicateCount = TRY_COUNT - uniqResult.size();

        System.out.println("Math Random:");
        System.out.println("All Count: " + allCount);
        System.out.println("Uniq Count: " + uniqCount);
        System.out.println("Duplicate Count: " + duplicateCount);
        System.out.println("Duplicate Rate: " + (duplicateCount * 100) / TRY_COUNT);
        System.out.println("------------------------");
    }

}
