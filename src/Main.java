import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	private static Scanner sc = new Scanner(System.in);
	private static int mStudentSize;
	private static int mStudentDivide;
	private static ArrayList<Integer> mStudentList = new ArrayList<Integer>();
	private static ArrayList<Integer> mMissedStudentList = new ArrayList<Integer>();
	private static StudentBook mStudentBook = new StudentBook();

	public static void main(String[] args) {

		System.out.println("학생 자리배치를 시작합니다.");

		// 학생 수를 설정한다.
		System.out.println("학생 수를 설정합니다.");
		setStudentSize();

		// 분단 수를 설정한다.
		System.out.println("분단의 갯수를 설정합니다.");
		setStudentDivide();

		// 결번을 입력한다.
		System.out.println("결번을 입력해주세요.");
		System.out.println("그만 입력하시려면 0을 입력하세요");
		setMissedStudent();
		
		// 학생 목록을 만든다.
		setStudentList();

		// 학생이름을 입력한다.
		setStudentName();

		// 학생이름을 출력한다.
		getStudentName();
	}

	/**
	 * 학생 수를 설정하는 함수이다. 스캐너로 입력을 받아 설정한다.
	 */
	private static void setStudentSize() {
//		while (true) {
//			int size = sc.nextInt();
//			if (size < 15 || size > 40) {
//				System.out.println("15 이상, 40 이하로 학생 수를 설정해주세요.");
//			} else {
//				mStudentSize = size;
//				break;
//			}
//		}
		int size = sc.nextInt();
		mStudentSize = size;
	}

	/**
	 * 학생 분단을 설정하는 함수이다. 스캐너로 입력을 받아 설정한다.
	 */
	private static void setStudentDivide() {
		while (true) {
			int devide = sc.nextInt();
			if (devide < 2 || devide > 4) {
				System.out.println("2 이상, 4 이하로 분단 설정해주세요.");
			} else {
				mStudentDivide = devide;
				break;
			}
		}
	}

	/**
	 * 결번을 입력하는 함수이다. 스캐너로 입력을 받아 설정한다.
	 */
	private static void setMissedStudent() {
		while (true) {
			int studentNum = sc.nextInt();
			if (studentNum > mStudentSize) {
				System.out.println("이런 번호의 학생은 없어요");
				continue;
			}
			if (studentNum == 0) {
				System.out.println("결번 입력을 종료합니다.");
				break;
			} else {
				if (mMissedStudentList.size() == 0) {
					mMissedStudentList.add(studentNum);
					continue;
				}
				if (checkMissedStudent(studentNum)) {
					System.out.println("중복된 학생입니다");
				} else {
					mMissedStudentList.add(studentNum);
				}
			}

		}
	}

	
	/**
	 * 결석 학생을 체크하는 함수이다.
	 * @param 결석 학생인지 궁금한 학생의 번호
	 * @return 결석학생인가?
	 */
	private static boolean checkMissedStudent(int num) {
		for (int i : mMissedStudentList) {
			if (i == num) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 학생 목록을 설정하는 함수이
	 */
	private static void setStudentList() {
		for (int i = 1; i <= mStudentSize; i++) {
			if (!checkMissedStudent(i))
				mStudentList.add(i);
		}
	}

	/**
	 * 학생 목록의 학생들에게 이름을 입력해주는 함수이다.
	 */
	private static void setStudentName() {
		for (int num : mStudentList) {
			System.out.println(num + " 번 학생의 이름은?");
			String studentName = sc.next();
			mStudentBook.setStudentName(num, studentName);
		}
	}

	/**
	 * 학생 목록에 있는 학생의 이름을 출력해주는 함수이다.
	 */
	private static void getStudentName() {
		for (int num : mStudentList) {
			System.out.println(num + " 번 학생의 이름은 " + mStudentBook.getStudentName(num));
		}
	}
}
