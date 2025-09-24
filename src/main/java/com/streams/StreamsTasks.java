//package com.streams;
//
//import java.util.*;
//import java.util.function.Function;
//import java.util.stream.Collectors;
//
//public class StreamsTasks {
//    private static void solution() {
//        List<String> names = List.of("Alice", "Bob", "Andrew", "Alex", "Steve");
//
//        names.stream()
//                .filter(s -> s.startsWith("A"))
//                .map(String::toUpperCase)
//                .collect(Collectors.toList());
//
//        List<String> words = List.of("apple", "banana", "apple", "orange", "banana", "apple");
//
//        Map<String, Long> map = words.stream()
//                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
//
//        List<Integer> numbers = List.of(10, 45, 32, 67, 89, 23, 91);
//        numbers.stream()
//                .sorted(Comparator.reverseOrder())
//                .limit(3)
//                .collect(Collectors.toList());
//
//        numbers.stream()
//                .mapToInt(a -> a*a)
//                .sum();
//
//        List<String> names2 = Arrays.asList("Alice", "John", "Bob", "Jane");
//
//        names2.stream()
//                .filter(name -> name.startsWith("J")).findFirst();
//
//        names2.stream()
//                .filter(s -> s.length() > 5)
//                .count();
//
//        names2.stream()
//                .collect(Collectors.groupingBy
//                        (string -> string.charAt(0)));
//
//        List<String> words2 = List.of("Java", "", "Streams", "API");
//        String result = words2.stream()
//                .filter(Objects::nonNull)
//                .filter(s -> !s.isEmpty())
//                .collect(Collectors.joining(","));
//        System.out.println(result);
//
//        List<Employee> employees = List.of(
//                new Employee("Alice", "HR", 60000),
//                new Employee("Bob", "IT", 80000),
//                new Employee("Charlie", "HR", 70000),
//                new Employee("David", "IT", 90000)
//        );
//
//        Map<String, Employee> map1 =
//                employees.stream()
//                        .collect(Collectors.groupingBy(Employee::dept,
//                                Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(Employee::salary)),
//                                        Optional::get)));
//        System.out.println(map1);
//
//        Map<String, Employee> map2 = employees.stream()
//                .collect(Collectors.groupingBy(Employee::dept,
//                        Collectors.collectingAndThen(Collectors.toList(),
//                                list -> list.stream()
//                                        .sorted(Comparator.comparingDouble(Employee::salary).reversed())
//                                        .skip(1)
//                                        .findFirst()
//                                        .get())));
//
//
//        List<Integer> nums = List.of(1, 2, 3, 4, 5, 6);
//
//        int sum = nums.stream()
//                .filter(n -> n % 2 == 0)
//                .mapToInt(n -> n * n)
//                .sum();
//
//        names2.stream()
//                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
//                .entrySet()
//                .stream()
//                .filter(entry -> entry.getValue() > 1)
//                .collect(Collectors.toList());
//
//        List<List<String>> nested = List.of(
//                List.of("A", "B"),
//                List.of("C", "D"),
//                List.of("E")
//        );
//
//        nested.stream().flatMap(List::stream)
//                .collect(Collectors.toList());
//
//        List<Employee2> employees2 = List.of(
//                new Employee2("Alice", "HR"),
//                new Employee2("Bob", "IT"),
//                new Employee2("Charlie", "HR")
//        );
//
//        Map<String, List<Employee2>> l = employees2.stream()
//                .collect(Collectors.groupingBy(Employee2::dept));
//
//
//        nums = List.of(1, 2, 3, 4, 5, 6);
//
//        Map<Boolean, List<Integer>> p = nums.stream()
//                .collect(Collectors.partitioningBy(i -> i % 2 == 0));
//
//        // Extract Distinct Words from Sentences
//        List<String> sentences = List.of(
//                "Java streams are powerful",
//                "Streams simplify collection processing",
//                "Java is great"
//        );
//
//
//        sentences.stream()
//                .flatMap(s -> Arrays.stream(s.split("\\s+")))
//                .map(String::toLowerCase)
//                .distinct()
//                .sorted()
//                .collect(Collectors.toList());
//
//
//        List<Person> people = List.of(
//                new Person("Tom", 32),
//                new Person("Jerry", 45),
//                new Person("Anna", 40)
//        );
//
//        people.stream()
//                .max(Comparator.comparing(Person::age));
//
//        people.stream()
//                .sorted(Comparator.comparingInt(Person::age).reversed())
//                .findFirst()
//                .map(Person::name);
//        people.stream()
//                .reduce(0,(partialAge, person) -> partialAge + person.age, Integer::sum);
//
//    }
//
//    public static void main(String[] args) {
//        solution();
//    }
//
//    record Employee(String name, String dept, double salary) {
//    }
//
//    record Employee2(String name, String dept) {
//    }
//
//    record Person(String name, int age) {
//    }
//}
