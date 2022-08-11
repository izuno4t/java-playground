package com.example.rand;

import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.rng.simple.RandomSource;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.SplittableRandom;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandExample {

    private static final int TRY_COUNT = 1000;
    private static final int RAND_RANGE = 1000;

    public static void main(String args[]) throws Exception {
        // 本当は100回やった結果の平均値でやるのが正しいけど
        randomUtils();
        mathRand();
        secureRandom();
        commonsRng();
        threadLocalRandom();
        splittableRandom();
        shuffle();
//        nano();
    }

    static void secureRandom() throws NoSuchAlgorithmException {

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

        System.out.println("SecureRandom:");
        System.out.println("All Count: " + allCount);
        System.out.println("Uniq Count: " + uniqCount);
        System.out.println("Duplicate Count: " + duplicateCount);
        System.out.println("Duplicate Rate: " + (duplicateCount * 100) / TRY_COUNT + "%");
        System.out.println("------------------------");
    }

    static void randomUtils() {

        var result = new ArrayList<Integer>();
        for (int i = 0; i < TRY_COUNT; i++) {
            var value = RandomUtils.nextInt(0, RAND_RANGE);
            result.add(value);
        }


        var uniqResult = new HashSet<>(result);
        var allCount = result.size();
        var uniqCount = uniqResult.size();
        var duplicateCount = TRY_COUNT - uniqResult.size();

        System.out.println("Commons RandomUtils (Random):");
        System.out.println("All Count: " + allCount);
        System.out.println("Uniq Count: " + uniqCount);
        System.out.println("Duplicate Count: " + duplicateCount);
        System.out.println("Duplicate Rate: " + (duplicateCount * 100) / TRY_COUNT + "%");
        System.out.println("------------------------");
    }

    static void commonsRng() {
        var rng = RandomSource.XO_SHI_RO_128_SS.create();
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
        System.out.println("Duplicate Rate: " + (duplicateCount * 100) / TRY_COUNT + "%");
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
        System.out.println("Duplicate Rate: " + (duplicateCount * 100) / TRY_COUNT + "%");
        System.out.println("------------------------");
    }

    static void nano() throws InterruptedException {
        var result = new ArrayList<Integer>();
        for (int i = 0; i < TRY_COUNT; i++) {
            Thread.sleep(RandomUtils.nextInt(1, 10));
            var value = (int) System.nanoTime() % RAND_RANGE;
            System.out.println(value);
            result.add(value);
        }

        var uniqResult = new HashSet<>(result);
        var allCount = result.size();
        var uniqCount = uniqResult.size();
        var duplicateCount = TRY_COUNT - uniqResult.size();

        System.out.println("nanoTime:");
        System.out.println("All Count: " + allCount);
        System.out.println("Uniq Count: " + uniqCount);
        System.out.println("Duplicate Count: " + duplicateCount);
        System.out.println("Duplicate Rate: " + (duplicateCount * 100) / TRY_COUNT + "%");
        System.out.println("------------------------");
    }

    static void threadLocalRandom() {
        var result = new ArrayList<Integer>();
        for (int i = 0; i < TRY_COUNT; i++) {
            var value = ThreadLocalRandom.current().nextInt(RAND_RANGE);
            result.add(value);
        }

        var uniqResult = new HashSet<>(result);
        var allCount = result.size();
        var uniqCount = uniqResult.size();
        var duplicateCount = TRY_COUNT - uniqResult.size();

        System.out.println("ThreadLocalRandom:");
        System.out.println("All Count: " + allCount);
        System.out.println("Uniq Count: " + uniqCount);
        System.out.println("Duplicate Count: " + duplicateCount);
        System.out.println("Duplicate Rate: " + (duplicateCount * 100) / TRY_COUNT + "%");
        System.out.println("------------------------");
    }

    static void splittableRandom() {
        var rand = new SplittableRandom();
        var result = new ArrayList<Integer>();
        for (int i = 0; i < TRY_COUNT; i++) {
            var value = rand.nextInt(RAND_RANGE);
            result.add(value);
        }

        var uniqResult = new HashSet<>(result);
        var allCount = result.size();
        var uniqCount = uniqResult.size();
        var duplicateCount = TRY_COUNT - uniqResult.size();

        System.out.println("SplittableRandom:");
        System.out.println("All Count: " + allCount);
        System.out.println("Uniq Count: " + uniqCount);
        System.out.println("Duplicate Count: " + duplicateCount);
        System.out.println("Duplicate Rate: " + (duplicateCount * 100) / TRY_COUNT + "%");
        System.out.println("------------------------");
    }

    static void shuffle() {
        var shuffle = IntStream.range(0, 1000).boxed().collect(Collectors.toList());
        Collections.shuffle(shuffle);

        var result = new ArrayList<Integer>();
        for (int i = 0; i < TRY_COUNT; i++) {
            var value = shuffle.get(i);
            result.add(value);
        }

        var uniqResult = new HashSet<>(result);
        var allCount = result.size();
        var uniqCount = uniqResult.size();
        var duplicateCount = TRY_COUNT - uniqResult.size();

        System.out.println("SplittableRandom:");
        System.out.println("All Count: " + allCount);
        System.out.println("Uniq Count: " + uniqCount);
        System.out.println("Duplicate Count: " + duplicateCount);
        System.out.println("Duplicate Rate: " + (duplicateCount * 100) / TRY_COUNT + "%");
        System.out.println("------------------------");
    }
}
