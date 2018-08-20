package training.java8.stream;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TestJava8 {

	public static class Hosting {

		private int Id;
		private String name;
		private Date createdDate;

		public Hosting(int id, String name, Date createdDate) {
			Id = id;
			this.name = name;
			this.createdDate = createdDate;
		}

		public int getId() {
			return Id;
		}

		public void setId(int id) {
			Id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Date getCreatedDate() {
			return createdDate;
		}

		public void setCreatedDate(Date createdDate) {
			this.createdDate = createdDate;
		}

	}

	public static void main(String[] args) {

		List<Hosting> list = Ar
		list.add(new Hosting(1, "liquidweb.com", new Date()));
		list.add(new Hosting(2, "linode.com", new Date()));
		list.add(new Hosting(3, "digitalocean.com", new Date()));

		// example 1
		Map<Integer, String> result1 = list.stream().collect(Collectors.toMap(Hosting::getId, Hosting::getName));

		System.out.println("Result 1 : " + result1);

		// example 2
		Map<Integer, String> result2 = list.stream().collect(Collectors.toMap(x -> x.getId(), x -> x.getName()));

		System.out.println("Result 2 : " + result2);

	}

}
