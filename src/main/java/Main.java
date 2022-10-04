
public class Main {

	public static void main(String[] args) {
		testA();
		System.out.println("A Okay");
		testB();
		System.out.println("B Okay");
		System.out.println("test C:");
		testC();
		testD();
		System.out.println("D Okay");
	}

	public static void testA() {
		ReportCard r = new ReportCard("Yossi Hammerschlag", 3);
		assert (r.getStuName().equals("Yossi Hammerschlag"));
		assert (r.getSubArray().length == 3);
	}

	public static ReportCard createReportCard(String name, String[] sub, int[] grades) {
		Subject[] a = new Subject[sub.length];
		for (int i = 0; i < sub.length; i++) {
			a[i] = new Subject(sub[i], grades[i]);
		}
		ReportCard r = new ReportCard(name, sub.length);
		r.setSubArray(a);
		return r;
	}

	public static void testB() {
		String[] sub = { "Sports", "Math", "History", "Bible" };
		int[] grades = { 85, 85, 85, 100 };
		ReportCard r = createReportCard("Yosi", sub, grades);
		assert (r.isExcellent());
		Subject[] a = r.getSubArray();
		a[0].setGrade(60); // now avg < 85
		assert (!r.isExcellent());
		a[0].setGrade(85);
		a[3].setGrade(99); // now no 100
		assert (!r.isExcellent());
		a[3].setGrade(100);
		a[0].setGrade(54);
		a[1].setGrade(99);
		a[2].setGrade(99); // has below 55, but has 100 and avg>=85
		assert (!r.isExcellent());
	}

	public static void printExcellent(ReportCard[] cards) {
		for (int i = 0; i < cards.length; i++) {
			if (cards[i].isExcellent()) {
				System.out.println(cards[i].getStuName());
			}
		}
	}

	public static void testC() {
		String[] sub = { "Sports", "Math", "History", "Bible" };
		int[] grades1 = { 85, 85, 85, 100 };
		ReportCard r1 = createReportCard("Yosi", sub, grades1);
		int[] grades2 = { 80, 80, 80, 80 };
		ReportCard r2 = createReportCard("David", sub, grades2);
		ReportCard[] a = { r1, r2 };
		printExcellent(a);
	}

	public static void testD() {
		String[] sub = { "Sports", "Math", "History", "Bible" };
		int[] grades1 = { 85, 85, 85, 100 };
		ReportCard r1 = createReportCard("Yosi", sub, grades1);

		ReportCard r2 = new ReportCard(r1);
		r2.getSubArray()[0].setGrade(100);
		assert (r1.getSubArray()[0].getGrade() == 85);
	}
}
