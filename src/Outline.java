import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class Outline {

  public static List<String> getList() {
    return List.of("hi", "bat", "ear", "hello", "iguana",
            "beaver", "winterland", "elephant", "eye", "qi");
  }

  // Loop through the words and print each one on a separate line,
  // with two spaces in front of each word.
  public static void question1() {
    List<String> words = getList();
    System.out.println("1: ");
    // YOUR CODE
    List<String> myList = getList();
    myList.stream().forEach(s -> System.out.println("  " + s));
  }

  // Repeat this problem but without two spaces in front of each word.
  // This should be trivial if you use the same approach as the previous
  // question; the point here is to make use of a method reference.
  public static void question2() {
    List<String> words = getList();
    System.out.println("2: ");
    // YOUR CODE
    List<String> myList = getList();
    myList.stream().forEach(System.out::println);
  }

  // For each of the following lambda expressions (see Question 5 in Worksheet 2),
  // produce the list that contains the elements of the original list
  // that satisfy the predicate defined by the lambda expression
  // (use the filter stream operation):
  //  - s -> s.length() < 4 (strings with no more than 3 characters),
  //  -  s -> s.contains("b") (strings containing "b"),
  // s -> (s.length() % 2) == 0 (strings of even length).

  public static void question3() {
    List<String> words = getList();
    System.out.println("3:");
    // YOUR CODE
    System.out.println("\nstrings with no more than 3 characters:");
    words.stream().filter(s -> s.length() < 4).forEach(System.out::println);
    System.out.println("\nstrings that contain the letter b:");
    words.stream().filter(s -> s.contains("b")).forEach(System.out::println);
    System.out.println("\nstrings of an even length:");
    words.stream().filter(s -> (s.length() % 2) == 0).forEach(System.out::println);
  }


  // For each of the following lambda expressions (see Question 7 in Worksheet 2),
  // produce the list that contains the results of applying the function
  // defined by the lambda expression to each element of the original list
  // (use the map stream operation):
  // - s -> s + "!",
  //  s -> s.replace("i", "eye"),
  //  s -> s.toUpperCase().

  public static void question4() {
    List<String> words = getList();
    System.out.println("4:");
    // YOUR CODE
    System.out.println("\nPart one (add !)");
    words.stream().map(s -> s + "!").forEach(System.out::println);
    System.out.println("\nPart two (replace i with eye)");
    words.stream().map(s -> s.replace("i", "eye")).forEach(System.out::println);
    System.out.println("\nPart three (change to uppercase)");
    words.stream().map(s -> s.toUpperCase()).forEach(System.out::println);

  }


  // (*) Turn the strings in the list into uppercase, keep only the
  // ones that are shorter than four characters, and, of what is remaining,
  // keep only the ones that contain "e", and print the first result.
  // Repeat the process, except checking for a "q" instead of an "e".

  public static void question5() {
    List<String> words = getList();
    System.out.println("5a:");
    // YOUR CODE
    System.out.println("Part one (with e):");
    words.stream().filter(s -> s.length() < 4).filter(s -> s.contains("e"))
            .map(String::toUpperCase).findFirst().ifPresent(System.out::println);
    // instead of findFirst use limit(1)
    System.out.println("Part one (with q):");
    words.stream().filter(s -> s.length() < 4).filter(s -> s.contains("q"))
            .map(String::toUpperCase).findFirst().ifPresent(System.out::println);
  }


  // (** ) The above example uses lazy evaluation, but it is not easy to see
  // that it is doing so. Create a variation of the above example that shows
  // that it is doing lazy evaluation. The simplest way is to track which
  // entries are turned into upper case.

  public static void question6() {
    List<String> words = getList();
    System.out.println("6:");
    // YOUR CODE
    words.stream()
            .map(String::toUpperCase).peek(System.out::println)
            .filter(s -> s.length() <4).peek(System.out::println)
            .filter(s -> s.contains("E")).peek(System.out::println)
            .findFirst().ifPresent(System.out::println);
  }

  // (*) Produce a single String that is the result of concatenating the
  // uppercase versions of all the Strings.
  // For example, the result should be "HIHELLO...".
  // Hint: use a map operation that turns the words into upper case,
  // followed by a reduce operation that concatenates them.

  public static void question7() {
    List<String> words = getList();
    System.out.println("7:");
    // YOUR CODE
    String result = words.stream().map(String::toUpperCase)
            .reduce("", (string1, string2) -> string1 + string2);
    System.out.println(result);
  }


  // (*) Produce a single String that is the result of concatenating the
  // uppercase versions of all the Strings.
  // For example, the result should be "HIHELLO...".
  // Use a single reduce operation, without using map.

  public static void question8() {
    List<String> words = getList();
    System.out.println("8:");
    // YOUR CODE
    String result = words.stream()
            .reduce("", (string1, string2) -> string1 + string2.toUpperCase());
    System.out.println(result);
  }

  // (*) Produce a String that is all the words concatenated together, but
  // with commas in between. For example, the result should be "hi,hello,...".
  // Note that there is no comma at the beginning, before "hi", and also no comma
  // at the end, after the last word.

  public static void question9() {
    List<String> words = getList();
    System.out.println("9:");
    // YOUR CODE
    Optional<String> result = words.stream()
            .reduce((string1, string2) -> string1 + "," + string2);
    System.out.println(result);
    String res2 = words.stream().collect(Collectors.joining(","));
    System.out.println(res2);
  }

  // CONTINUE WITH THE REST OF THE QUESTIONS
  public static void question10() {
    List<Dish> dishes = Dish.getMenu();
    dishes.stream().limit(2).forEach(System.out::println);
  }

  public static void question11() {
    List<Dish> dishes = Dish.getMenu();
    // use mapToInt instead of map
    // for the reduce Integer::sum method reference
    int total = dishes.stream().map(d -> 1).reduce(0, (i, j) -> i + j);
    System.out.println(total);
    System.out.println(dishes.stream().count());
  }

  // For questions 12 onwards
  public static Integer[] getIntegerArray() {
    return new Integer[] { 1, 7, 3, 4, 8, 2 };
  }

  public static void question12() {
    Integer [] integerArray = getIntegerArray();
    Integer[] squareArray = Arrays.stream(integerArray)
            .map(n -> n * n).toArray(Integer[]::new);
    System.out.println(Arrays.toString(squareArray));

    int[] intArr = {1, 7, 3, 4, 8, 2};
    List<Integer> squares = IntStream.of(intArr)
            .mapToObj(n -> n * n)
            .collect(Collectors.toList());
    System.out.println(squares);
  }

  public static void question13() {
    Integer[] arr1 = { 1, 2, 3 };
    Integer[] arr2 = {3, 4};
    Integer[][] result = Arrays.stream(arr1)
            .flatMap(i -> Arrays.stream(arr2).map(n -> new Integer[] {i, n}))
            .toArray(Integer[][]::new);
    System.out.println(Arrays.deepToString(result));
  }

  public static void question14() {
    int[] arr1 = { 1, 2, 3 };
    int[] arr2 = {3, 4};

    List<List<Integer>> result = Arrays.stream(arr1)
            .boxed()
            .flatMap(i -> Arrays.stream(arr2)
                    .filter(j -> (i + j) % 3 == 0)
                    .mapToObj(j -> List.of(i, j)))
            .collect(Collectors.toList());
    System.out.println(result);
  }

  public static void question15() {
    List<Integer> listNum = List.of(1, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
    int res1 = listNum.stream().reduce(0, (a, b) -> a + b);
    System.out.println("first result: " + res1);
    int res2 = listNum.stream().reduce(Integer::sum).orElse(0);
    System.out.println(res2);
    int res3 = listNum.stream().mapToInt(Integer::intValue).sum();
    System.out.println(res3);
    int res4 = listNum.stream().collect(Collectors.summingInt(Integer::intValue));
    System.out.println(res4);

  }

  public static List<Double> randomDoubles(int size) {
    Random random = new Random();

    //alternative
    Stream.generate(new Random()::nextDouble)
            .limit(size)
            .collect(Collectors.toList());

    return IntStream.range(0, size)
            .mapToObj(i -> random.nextDouble())
            .collect(Collectors.toList());
  }

  public static void question16() {
    System.out.println((randomDoubles(5)));
  }

  public static List<Integer> orderedNumberLists(int start, int size, int step) {
    return IntStream.iterate(start, i -> i + step)
            .limit(size)
            .boxed()
            .collect(Collectors.toList());
    // could also use Stream.iterate
  }

  public static void question17() {
    System.out.println(orderedNumberLists(50, 5, 5));
  }

  public static void question18() {
    List<Integer> listNum = List.of(1, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
    int res1 = listNum.parallelStream().reduce(0, (a, b) -> a + b);
    System.out.println("first result: " + res1);
    int res2 = listNum.parallelStream().reduce(Integer::sum).orElse(0);
    System.out.println(res2);
    int res3 = listNum.parallelStream().mapToInt(Integer::intValue).sum();
    System.out.println(res3);
    int res4 = listNum.parallelStream().collect(Collectors.summingInt(Integer::intValue));
    System.out.println(res4);
  }

  public static void question19() {
    List<Double> doubles = List.of(4.04, 3.03, 2.02, 1.01, 5.05);
    Double seq = doubles.stream().reduce(1.0, (a, b) -> a * b);
    Double parallel = doubles.parallelStream().reduce(1.0, (a, b) -> a * b);
    System.out.println("seq: " + seq + " parallel: " + parallel);
  }

  // check Q15 from video
  public static void main(String... args) { // varargs alternative to String[]
    question19();
    //question15();
    int n = 1_00;
    double[] numbers = new double[n];
    Random random = new Random();

    for (int i = 0; i < n; i++) {
      numbers[i] = random.nextDouble();
    }

    // Calculate the product using a serial stream
    double serialProduct = Arrays.stream(numbers).reduce(1.0, (a, b) -> a * b);

    // Calculate the product using a parallel stream
    double parallelProduct = Arrays.stream(numbers).parallel().reduce(1.0, (a, b) -> a * b);

    System.out.println("Serial Product: " + serialProduct);
    System.out.println("Parallel Product: " + parallelProduct);

    if (serialProduct != parallelProduct) {
      System.out.println("The serial and parallel products are different!");
    } else {
      System.out.println("The serial and parallel products are the same.");
    }
  }
}