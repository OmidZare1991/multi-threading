package com.multithreading.practice;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

class Key{
    private String key;
    private int id;

    public Key(String key) {
        this.key = key;
    }

    public Key(String key, int id) {
        this.key = key;
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Key key1 = (Key) o;
        return Objects.equals(key, key1.key);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key);
    }

    @Override
    public String toString() {
        return "Key{" +
                "key='" + key + '\'' +
                ", id=" + id +
                '}';
    }
}
public class TestHashCode {
    public static void main(String[] args) {
        Map<Key,String> map = new HashMap<>();
        Key test1 = new Key("test1",1);
        map.put(test1,"hello1");
        System.out.println(map.containsKey(test1));
        System.out.println("size: "+map.size());

        for(Map.Entry<Key,String> entry: map.entrySet()){
            System.out.println("key: "+entry.getKey()+", and value: "+entry.getValue());
        }
        test1.setKey("test2");

        for(Map.Entry<Key,String> entry: map.entrySet()){
            System.out.println("key: "+entry.getKey()+", and value: "+entry.getValue());
        }

        System.out.println("size: "+map.size());

        System.out.println(map.containsKey(test1));

        System.out.println(map.get(test1));

        System.out.println("size: "+map.size());

        for(Map.Entry<Key,String> entry: map.entrySet()){
            System.out.println("key: "+entry.getKey()+", and value: "+entry.getValue());
        }
        map.put(test1,"hello2");
        System.out.println(map.containsKey(test1));

        System.out.println(map.get(test1));
        for(Map.Entry<Key,String> entry: map.entrySet()){
            System.out.println("key: "+entry.getKey()+", and value: "+entry.getValue());
        }
    }
}
