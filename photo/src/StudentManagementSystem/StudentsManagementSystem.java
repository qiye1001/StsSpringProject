package StudentManagementSystem;


public class StudentsManagementSystem {
	private StudentInformation studentInformation;
	private int currentIndex; // ����

	// ���
	public void add(int id, String name, int age) {
		if (studentInformation == null) {
			studentInformation = new StudentInformation(id, name, age);
		} else {
			studentInformation.addStudentInformation(id, name, age);
		}
	}

	// ����
	public void insert(int index, int id, String name, int age) {
		if (index < 0) 	return;
		currentIndex = 0;
		if (index == currentIndex) {
			StudentInformation newStudentInformation = new StudentInformation(id, name, age);
			newStudentInformation.next = studentInformation;
			studentInformation = newStudentInformation;
		} else {
			studentInformation.insertStudentInformation(index, id, name, age);
		}
	}

	// ɾ��
	public void delete(int id) {
		if (studentInformation.getId() == id) {
			studentInformation = studentInformation.next;
		} else {
			studentInformation.deleteStudentInformation(id);
		}
	}

	// �޸�
	public void update(int id, String name, int age) {
		if (studentInformation != null) {
			if (id == studentInformation.getId()) {
				studentInformation.setName(name);
				studentInformation.setAge(age);
			} else {
				studentInformation.updateStudentInformation(id, name, age);
			}
		}
	}

	// ��ӡ(˳��)
	public void print() {
		if (studentInformation != null) {
			studentInformation.printStudentInformation();
		}
	}

	// ��ӡ(����)
	public void printInverted() {
		if (studentInformation != null) {
			studentInformation.printStudentInformationInverted();
		}
	}

	private class StudentInformation {
		private StudentInformation next;
		private int id; // ѧ��
		private String name; // ����
		private int age; // ����

		public StudentInformation() {
		}

		public StudentInformation(int id, String name, int age) {
			this.id = id;
			this.name = name;
			this.age = age;
		}

		public void setName(String name) {
			this.name = name;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public int getId() {
			return id;
		}

		public String getName() {
			return name;
		}

		public int getAge() {
			return age;
		}

		public void addStudentInformation(int id, String name, int age) {
			if (this.next == null) {
				this.next = new StudentInformation(id, name, age);
			} else {
				this.next.addStudentInformation(id, name, age);
			}
		}

		public void insertStudentInformation(int index, int id, String name, int age) {
			currentIndex++;
			if (index == currentIndex) {
				StudentInformation newStudentInformation = new StudentInformation(id, name, age);
				newStudentInformation.next = this.next;
				this.next = newStudentInformation;

			} else {
				this.next.insertStudentInformation(index, id, name, age);
			}
		}

		public void deleteStudentInformation(int id) {
			if (this.next != null) {
				if (this.next.getId() == id) {
					this.next = this.next.next;
				} else {
					this.next.deleteStudentInformation(id);
				}
			}
		}

		public void updateStudentInformation(int id, String name, int age) {
			if (this.next != null) {
				if (this.next.getId() == id) {
					this.next.setAge(age);
					this.next.setName(name);
				} else {
					this.next.updateStudentInformation(id, name, age);
				}
			}

		}

		public void printStudentInformation() {
			System.out.println(toString());
			if (this.next != null) {
				this.next.printStudentInformation();
			}
		}

		public void printStudentInformationInverted() {
			if (this.next != null) {
				this.next.printStudentInformationInverted();
			}
			System.out.println(toString());
		}
		
		@Override
		public String toString() {
			return "StudentInformation [ѧ��=" + id + ", ����=" + name + ", ����=" + age + "]";
		}
	}
}
