package top.haha233.entity;

public class Score {
	private int id;
	private Student student;
	private Course course;
	private int score;
	private int isDeleted;

	public Score() {
	}

	public Score(int id, Student student, Course course, int score) {
		this.id = id;
		this.student = student;
		this.course = course;
		this.score = score;
	}

	public Score(int id, Student student, Course course, int score, int isDeleted) {
		this.id = id;
		this.student = student;
		this.course = course;
		this.score = score;
		this.isDeleted = isDeleted;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}

	@Override
	public String toString() {
		return "姓名:" + student.getName() + " 课程:" + course.getName() + " 成绩:" + score;
	}
}
