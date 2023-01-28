package com.example;

import java.util.LinkedHashMap;

public class Foo {

    public static void main(String args[]) {

//        こう書きたいんだけどLinkedHashMapは真面目に書くしかなさそう
//        var map = LinkedHashMap.of(
//                "", "選択してください", //
//                "1", "ああああ", //
//                "2", "いいいい"//
//        );

        var map = new LinkedHashMap<String, String>();
        map.put("", "選択してください");
        map.put("1", "ああああ");
        map.put("2", "いいいい");


        map.forEach((key, value) -> System.out.println(key + ": " + value));


    }
}
