import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Example {

	public static void main(String[] args) {

		// streamVsParallelStream();
		List<String> list = Arrays.asList();
		list=null;
		System.out.println(list+"abc");
		/*for(String x:list){
			System.out.println(x);
		}*/
		
		upperCaseUSingStream();
		exampleStreamFilter();

	}

	private static void streamVsParallelStream() {
		int result = 0;
		Random rand = new Random();
		List<Integer> data = new ArrayList<>();
		for (int i = 0; i < 1000000; i++) {
			data.add(rand.nextInt());
		}
		System.out.println("starting");
		long start = new Date().getTime();

		/*
		 * for (int k : data) { result += doSomething(k); }
		 */

		result = data.parallelStream().map(i -> doSomething(i))
				.reduce(Integer::sum).get();

		Stream<Integer> stream = data.stream().sorted();
		stream.forEach(System.out::println);

		System.out.println("Result" + result);
		long end = new Date().getTime();
		System.out.println(end - start);
	}

	private static int doSomething(int x) {
		for (int i = 1; i <= 10000; i++) {
			x = (x ^ i) % i;
			if (x <= 0)
				x = 10;

		}
		return x;
	}

	public static void upperCaseUSingStream() {
		String[] arr = new String[] { "hello", "how are you" };
		List<String> arrList = Arrays.asList(arr);

		arrList.forEach(System.out::println);
		Stream<String> streamArray = Arrays.stream(arr);
		streamArray.map(str -> str.toUpperCase()).forEach(System.out::println);
	}

	public static void exampleStreamFilter() {
		List<String> line = Arrays.asList("hello", "gokul", "pandey");
		List<String> line1 = line.stream().filter(str -> !"pandey".equals(str))
				.collect(Collectors.toList());
		line1.forEach(System.out::println);

	}

	public static void exampleFilterAndFindAny() {
		List<String> name = Arrays.asList("gokul", "manoj", "sanjay");
		String x = name.stream().filter(str -> "gokul".equals(name)).findAny()
				.orElse(null);
	}
}
