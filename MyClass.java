package Streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MyClass {
	public static void main(String[] args) {
		List<Employee> dataList = Arrays.asList(new Employee(107, "Vivek", 25000, "developer", 23),
				new Employee(103, "Manju", 35000, "HR", 26), new Employee(102, "Ranjitha", 81000, "Architecture", 17),
				new Employee(110, "Hemanth", 21000, "developer", 22), new Employee(111, "Kratika", 45000, "Tester", 26),
				new Employee(101, "Sandeep", 16000, "developer", 28), new Employee(106, "Yoosodha", 70000, "MD", 50));

		// normal java conditions
//		for (Employee employee : dataList) {
//			if (employee.age < 25) {
//				System.out.println(employee);
//			}
//		}
		System.out.println("==============Filter the condition===================");
		List<Employee> filtering = dataList.stream().filter(i -> i.salary > 30000).collect(Collectors.toList());
		for (Employee employee : filtering) {
			System.out.println(employee);
		}
		System.out.println("=================filter condition with same line =====================");

		dataList.stream().filter(product -> product.age > 23)
				.forEach(product -> System.out.println(product.employee_Name));
		// System.out.println(dataList);

		System.out.println("=================Fittering endsWith=======================");
		dataList.stream().filter(r -> r.employee_Name.endsWith("a")).forEach(r -> System.out.println(r.employee_Name));

		System.out.println("=============Filtering startWith==============");
		dataList.stream().filter(r -> r.employee_Name.startsWith("S")).forEach(System.out::println);

		System.out.println("======================== Min Value  and Max Value============================");

		Stream<Employee> employees = dataList.stream();
		employees.min(Comparator.comparing(Employee::getSalary)).ifPresent(System.out::println);
		dataList.stream().max(Comparator.comparing(Employee::getAge)).ifPresent(System.out::println);
		System.out.println("======================== Sorting ========================");
		List<Employee> sorted = dataList.stream().sorted(Comparator.comparing(Employee::getEmployee_Name))
				.collect(Collectors.toList());

		// sorted.stream().filter(x -> x.salary > 25000).forEach(x ->
		// System.out.println()); --> Extra Condition
		// Collections.reverse(sorted); ---> Reverse Order

		for (Employee employee : sorted) {
			System.out.println(employee);

		}

		System.out.println("=============== Mapping group ==================");
		Map<Double, List<Employee>> collectGroup = dataList.stream()
				.collect(Collectors.groupingBy(Employee::getSalary));
		collectGroup.forEach((x, y) -> {
			System.out.println(x);
			y.forEach(System.out::println);
		});

		Map<Integer, List<Employee>> collectGroup1 = dataList.stream().collect(Collectors.groupingBy(Employee::getAge));
		collectGroup1.forEach((x, y) -> {
			System.out.println(x);
			y.forEach(System.out::println);
		});

		System.out.println("========= ======== Mapping ======== =======");

		System.out.println("Employee List With Id and Name : ");
		List<Map<Integer, String>> list = dataList.stream().map(t -> {
			Map<Integer, String> m = new HashMap<>();
			m.put(t.getEmployee_id(), t.getEmployee_Name());
			return m;
		}).collect(Collectors.toList());
				list.forEach(t -> {
			System.out.println("Id : " + t.entrySet().stream().map(x -> x.getKey()).collect(Collectors.toList()).stream().findFirst().get()
					+ ", Name : " + t.entrySet().stream().map(x -> x.getValue()).collect(Collectors.toList()).stream().findFirst().get()
					+ ".");
		});

		System.out.println("================ anyMatch & allMatch - boolean ================");

		boolean anyMatch = dataList.stream().anyMatch(x -> x.getAge() == 23);
		System.out.println("AllMatch : " + anyMatch);
		boolean allMatch = dataList.stream().allMatch(x -> x.Designation.isEmpty());
		System.out.println("AllMatch : " + allMatch);
	}
}
