package com.multithreading.practice.streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsMain {
    public static void main(String[] args) throws IOException {
        int[] numbers = {2, 4, 3, 5, 6, -2, 9, -5};

        Arrays.stream(numbers).forEach(System.out::println);

        Stream.of(numbers).forEach(System.out::println);

        int sum = Arrays.stream(numbers).sum();

        IntStream.range(0, 5).forEach(item -> System.out.println(item));


        IntStream.range(0, 10).filter(item -> item > 4).forEach(System.out::println);


        String[] names = {"Omid", "Jack", "Jonny", "Joe", "Martha"};

        Stream.of(names).forEach(System.out::println);

        Stream.of(names).sorted().forEach(System.out::println); // to get alphabetical order

        Stream.of(names).sorted(Comparator.reverseOrder()).forEach(System.out::println);  // reverse order or descending order

        Stream.of(names).filter(name -> name.startsWith("O")).forEach(System.out::println);


        // reading files using streams
        Stream<String> linesStream = Files.lines(Paths.get("src/main/resources/names"));
        linesStream.forEach(System.out::println);
        List<String> lines = linesStream.collect(Collectors.toList());
        linesStream.filter(name -> name.startsWith("O")).forEach(System.out::println);
        List<String> filteredNames = linesStream.filter(name -> name.startsWith("O")).collect(Collectors.toList());


        List<Student> students = new ArrayList<>();
        Student student1 = new Student("Omid", true);
        Student student2 = new Student("Martha", false);
        Student student3 = new Student("Jonny", false);
        Student student4 = new Student("Eliza", true);
        Student student5 = new Student("Jessica", true);

        students.stream().map(Student::getName).forEach(System.out::println);
        students.stream().map(Student::getName).filter(name -> name.startsWith("J")).forEach(System.out::println);
        students.stream().filter(student -> !student.isLocal()).forEach(System.out::println);
        long count = students.stream().filter(student -> !student.isLocal()).count();

        // output: Omid Eliza Jessica
        String namesWithJoins = students.stream().filter(student -> student.isLocal()).map(student -> student.getName()).collect(Collectors.joining(" "));

    }
}
