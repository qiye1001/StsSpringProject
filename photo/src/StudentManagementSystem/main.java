package StudentManagementSystem;

public class main {
	public static void main(String[] args) {
		BinaryTree_StudentManagermentSystem student = new BinaryTree_StudentManagermentSystem();
		student.add(new StudentInformation(1004, "���з�", 73, "��"));
		student.add(new StudentInformation(1003, "��С��", 68, "Ů"));
		student.add(new StudentInformation(1006, "�մ��", 87, "Ů"));
		student.add(new StudentInformation(1002, "���ڷ�", 78, "Ů"));
		student.add(new StudentInformation(1005, "�ղ���", 85, "��"));
		student.print();
		System.out.println("-----------");
		student.delete(1003);
		student.print();
		
		System.out.println("-----------");
		System.out.println(student.find(1006));
		
		System.out.println("----------------");
		student.update(new StudentInformation(1007, "dafa", 52, "��"));
		student.print();
		
	}
}
