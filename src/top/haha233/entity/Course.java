package top.haha233.entity;

public class Course {
	private int id;
	private String name;
	private int isDeleted;

	public Course() {
	}

	public Course(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public Course(int id, String name, int isDeleted) {
		this.id = id;
		this.name = name;
		this.isDeleted = isDeleted;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}

	@Override
	public String toString() {
		return "Course{" +
				"id=" + id +
				", name='" + name + '\'' +
				'}';
	}
}
