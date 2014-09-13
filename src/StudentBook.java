import java.util.Hashtable;

public class StudentBook {
	private Hashtable<Integer, String> mStudentBook = new Hashtable<Integer, String>();

	/**
	 * 학생의 목록을 설정하는 함수이다.
	 * @param key
	 * @param name
	 */
	public void setStudentName(int key, String name) {
		mStudentBook.put(key, name);
	}

	/**
	 * 학생 목록을 조회하는 함수이다.
	 * @param key
	 * @return
	 */
	public String getStudentName(int key) {
		return mStudentBook.get(key);
	}
}
