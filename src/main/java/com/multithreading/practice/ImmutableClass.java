package com.multithreading.practice;

import java.util.HashMap;
import java.util.Map;

public class ImmutableClass {
    private final int id;
    private final String name;
    private Map<String, String> map;

    public ImmutableClass(int id, String name, Map<String, String> map) {
        this.id = id;
        this.name = name;

        Map<String, String> tempMap = new HashMap<>();

//        for(Map.Entry<String,String> entry: map.entrySet()){
//            map.put(entry.getKey(),entry.getValue());
//        }

        for (Map.Entry<String, String> entry : map.entrySet()) {
            tempMap.put(entry.getKey(), entry.getValue());
        }
        this.map = tempMap;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Map<String, String> getMap() {
        Map<String, String> tempMap = new HashMap<>();
        tempMap.putAll(this.map);
        return tempMap;
    }

}

class MainImmutable {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("a", "aa");
        map.put("b", "bb");
        map.put("c", "cc");
        ImmutableClass immutableClass = new ImmutableClass(1, "Omid", map);
        System.out.println(immutableClass.getName());
        System.out.println(immutableClass.getId());
        System.out.println(immutableClass.getMap());

        map.put("d","dd");
        System.out.println(immutableClass.getMap());
        immutableClass.getMap().put("e","ee");
        System.out.println(immutableClass.getMap());
    }
}
