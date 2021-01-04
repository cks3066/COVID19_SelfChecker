/* 
 * ��ü�������α׷���
 * 2015405060 �½���
 * �⸻��� ������Ʈ
 * ----------------
 * ������Ʈ��
 * > ����� COVID-19 �ڰ����� ���α׷�
 * ----------------
 * �������̽�, ���׸�, �÷��� �����ӿ�ũ, ���� ���
 */ 

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

// �Է¹��� �л� ��� �������̽�[���Ŀ� ���ٽ��� ���� ����]
interface PrintInfo<ID>{
	void printInfo(int age_,ID studentID_);
}

// �ڰ����� �������̽� [������ �л�, �ܱ��� �л��� ����üũ �� ��� ��� ���]
interface SelfChecker{	
	public void check();
	public int analysis();
}

// ������ �л�, �ܱ��� �л��� �θ� Ŭ����
class Student<ID> {	// ���׸� : �ܱ��� �л��� ��� student ID�� �й�(int)�� �ƴ� �� String ���� ����� �� �ֵ��� ó��
	private int age;
	private ID studentID;
	
	public Student(int age, ID studentID) {
		this.age = age;
		this.studentID = studentID;
	}
	
	public int getAge() {return age;}
	public ID getStudentID() {return studentID;}
}

// ������ �л� Ŭ����
class Korean<ID> extends Student implements SelfChecker{
	List<Integer> list = new ArrayList<>();	// �÷��� �����ӿ�ũ : List �̿� 
											// [�Է��� ���׵��� ArrayList�� ���� �� ������ ���꿡 ���]
	
	public Korean(int age, ID studentID) {
		super(age, studentID);
	}
	// �ڰ����� Ŭ���� SelfChecker �������̽��� �޼ҵ� ����
	public void check() {
		int cntCheck= 0;
		Scanner sc = new Scanner(System.in);
		
		PrintInfo lamda = (age_, studentID_) -> { // ���ٽ��� �̿��ؼ� �Է¹��� �л� Ŭ���� ���
			System.out.println("\n����: " + age_ +"�� \n�й�: "+studentID_);
		};
		lamda.printInfo(getAge(), getStudentID());	
		
		System.out.println("\n*** �ش��ϴ� ��ȣ�� ���ڸ� �Է����ּ���. *** [ex) 1]");
		System.out.println("1. �ڷγ�19 Ȯ������ ���˷� �� ������ ������");
		System.out.println("	1-1. �ֱ� 14�� �̳��� ���� �Ǵ� ���Ű����� �ڷγ�19 Ȯ��ȯ�ڿ� ������ ���� �ֽ��ϱ�?");
		System.out.println("		1. ������ �� ����	2.������ �� ����");
		System.out.print("		>> ");
		list.add(sc.nextInt());
		System.out.println("	1-2. �ֱ� 14�� �̳��� ���� �Ǵ� ���Ű����� �ؿܿ� �湮�� ���� �ֽ��ϱ�?");
		System.out.println("		1. �湮�� �� ����	2.�ش����");
		System.out.print("		>> ");
		list.add(sc.nextInt());
		System.out.println("	1-3. �ֱ� 14�� �̳��� �ڷγ�19 Ȯ���ڰ� �߻��� ���ܽü� �� ��������� �̿��� ���� �ֽ��ϱ�?");
		System.out.println("		1. ������ �� ����	2.�ش����");
		System.out.print("		>> ");
		list.add(sc.nextInt());
		System.out.println("2. �߿�����Ȯ�� (*37.5�� �̻�� 2ȸ üũ�Ͻñ� �ٶ��ϴ�.)");
		System.out.println("	1. 37.5�� �̻�	2.37.5�� �̸�");
		System.out.print("		>> ");
		list.add(sc.nextInt());
		System.out.println("3. �ؿ��� �� ������ ���� ����");
		System.out.println("	1. �ؿ���	2.������ 3.�������� ����");
		System.out.print("		>> ");
		list.add(sc.nextInt());
		System.out.println("4. ����Ȯ��");
		System.out.println("	| �߿�(�ְ��� ȣ�� ����) | ȣ�������(��ħ,����,������,ȣ����) | ȣ������� ��(������,����,���°�) | ���");
		System.out.println("	���� ���� �� �ϳ��� �߻� �� 1�� �Է�, �ش���� ��� 2�� �Է�");
		System.out.print("		>> ");
		list.add(sc.nextInt());
	}
	
	// ����� �м� �� ���
	// ��ȯ ���� �˻� �� ���ԵǴ� �׷쿡 ���� �ٸ� [�����豺:1, ���豺:2, �����豺:3]
	public int analysis() {
		int cnt = 0;
		Iterator iter = list.iterator();
		while(iter.hasNext()){//�������� �ִ��� üũ
		    if((int)iter.next() == 1) cnt++;
		}
		if(cnt == 0) {
			System.out.println("\n************************************************************************");
			System.out.println("*! ���豺�� ������ �ʽ��ϴ�. ����ũ ���� �� �վı⸦ ��Ȱȭ���ֽð� �����̿�ü��� �����ּ���.*");
			System.out.println("************************************************************************\n");
			System.out.println("\n------------------------------------------------------------------------------\n");
			return 1;
		}
		else if(cnt > 0 && cnt <4) {
			System.out.println("\n*******************************************************************************");
			System.out.println("*!! ���豺�� ���մϴ�. �����̿�ü� �̿��� �ﰡ���ֽð� �ڷγ� �˻� �� �ڰ��ݸ� ���� �Ǵ� ��Ź�帳�ϴ�.*");
			System.out.println("*******************************************************************************\n");
			System.out.println("\n------------------------------------------------------------------------------\n");
			return 2;
		}
		else if(cnt > 3) {
			System.out.println("\n**********************************************************");
			System.out.println("*!!! �����豺�� ���մϴ�. ����� ��������ҿ��� �ڷγ� �˻縦 �ޱ�ٶ��ϴ�.*");
			System.out.println("**********************************************************\n");
			System.out.println("\n------------------------------------------------------------------------------\n");
			return 3;
		}
		return 0;

	
	}
}

// �ܱ��� �л� Ŭ���� [������ �л��� �ٸ��� ������ ������ ����� ����ϸ� studentID�� �й�(int)�� �ƴ�]
class Foreigner<ID> extends Student implements SelfChecker{
	List<Integer> list = new ArrayList<>();
	
	public Foreigner(int age, ID studentID) {
		super(age, studentID);
	}
	
	public void check() {
		int cntCheck= 0;
		Scanner sc = new Scanner(System.in);
		
		PrintInfo lamda = (age_, studentID_) -> { // ���ٽ��� �̿��ؼ� �Է¹��� �л� Ŭ���� ���
			System.out.println("\nAge: " + age_+" \nStudentID: "+ studentID_);
		};
		lamda.printInfo(getAge(), getStudentID());	
		
		System.out.println("\n*** Please enter the number that you belong to [ex) 1]***");
		System.out.println("1. Check the connection with COVID-19 patients");
		System.out.println("	1-1. Have you or your family member ever been in contact with COVID-19 patients within the last 14 days?");
		System.out.println("		1. yes	2.no");
		System.out.print("		>> ");
		list.add(sc.nextInt());
		System.out.println("	1-2. Have you or your family member ever visited any foreign country within the last 14 days?");
		System.out.println("		1. yes	2.no");
		System.out.print("		>> ");
		list.add(sc.nextInt());
		System.out.println("	1-3. Have you or your family member ever visited any place that COVID-19 patients already visited within the last 14 days?");
		System.out.println("		1. yes	2.no");
		System.out.print("		>> ");
		list.add(sc.nextInt());
		System.out.println("2. Check body temperature (*please double check if your temperature is over 37 Celsius)");
		System.out.println("	1. Over 37.5 Celsius	2.Under 37.5 Celsius");
		System.out.print("		>> ");
		list.add(sc.nextInt());
		System.out.println("3. Check taking fever reducer or analgesic");
		System.out.println("	1. fever reducer 2.analgesic 3.not take");
		System.out.print("		>> ");
		list.add(sc.nextInt());
		System.out.println("4. Check Symptom");
		System.out.println("	| Fever | Respiratory symptoms(Cough,Sputum,Headache,Dyspnea) | Other case(Muscle pain, feeling a cold fit) | Pneumonia");
		System.out.println("	Enter 1 if any of the above symptoms occur. if not, enter 2");
		System.out.print("		>> ");
		list.add(sc.nextInt());
	}
	public int analysis() {	
		int cnt = 0;
		Iterator iter = list.iterator();
		while(iter.hasNext()){//�������� �ִ��� üũ
		    if((int)iter.next() == 1) cnt++;
		}
		if(cnt == 0) {
			System.out.println("\n***************************************************************");
			System.out.println("*! You are not in Danger Group. Please wear the mask whenever.*");
			System.out.println("***************************************************************\n");
			System.out.println("\n------------------------------------------------------------------------------\n");
			return 1;
		}
		else if(cnt > 0 && cnt <4) {
			System.out.println("\n******************************************************************");
			System.out.println("*!! You are in Danger Group. Please don't go to public facility. *");
			System.out.println("******************************************************************\n");
			System.out.println("\n------------------------------------------------------------------------------\n");
			return 2;
		}
		else if(cnt > 3) {
			System.out.println("\n*******************************************************************");
			System.out.println("*!!! You are in High-Risk Group. You need to have a COVID-19 TEST.*");
			System.out.println("*******************************************************************\n");
			System.out.println("\n------------------------------------------------------------------------------\n");
			return 3;
		}
		return 0;
	
	}
}

public class main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("����� COVID-19 �ڰ����� ���α׷�");
		System.out.println();
		
		// ������, �ܱ��ο� Ŭ���� �迭 ���� ����
		Korean[] kor = new Korean[100];
		Foreigner[] frg = new Foreigner[100];
		
		int check,age = 0, cntKor = 0, cntFrg = 0,intStudentId = 0;
		int nomal = 0, danger = 0, highRisk = 0;		// �ڰ����� �ǽ� �л��� �����豺, ���豺, �����豺���� ����
		String strStudentId = null;
		while(true) {
			do {
				check = 0;
				System.out.println("���ݱ��� �ڰ������� �ǽ��� �л� �� " + (cntKor + cntFrg) + "�� ��");
				System.out.println("���豺�� " + danger + "�� �̸�");
				System.out.println("�����豺�� " + highRisk + "�� �Դϴ�.\n");
				System.out.println("�������̸� 1��, �ܱ����̸� 2���� �Է����ּ���.\n(if you korean, enter 1. if not, enter 2)");
				System.out.print(">> ");
				check = sc.nextInt();
		
				if(check == 1) {
					System.out.println("�й��� �Է����ּ���. [ex) 2015405060]");
					System.out.print(">> ");
					intStudentId = sc.nextInt();
					System.out.println("���̸� �Է����ּ���. [ex) 26]");
					System.out.print(">> ");
					age = sc.nextInt();
					cntKor++;
				}
				else if(check == 2) {
					System.out.println("Enter your StudentID.[ex) James]");
					System.out.print(">> ");
					strStudentId = sc.next();
					System.out.println("Enter your age. [ex) 26]");
					System.out.print(">> ");
					age = sc.nextInt();
					cntFrg++;
				}
				else 
					System.out.println("�ٽ� �Է����ּ���.(Please Enter again.)");
			} while(check != 1 && check != 2);
			
			if(check == 1) {
				kor[cntKor]= new Korean(age,intStudentId);
				kor[cntKor].check();	// �ڰ�����
				int rst = kor[cntKor].analysis();	// �ڰ����� ��� ���
				if(rst == 2) danger++;
				else if(rst == 3) highRisk++;
			}
			
			else if(check == 2) {
				frg[cntFrg]= new Foreigner(age,strStudentId);
				frg[cntFrg].check();	// �ڰ�����
				int rst = frg[cntFrg].analysis();	// �ڰ����� ��� ���
				if(rst == 2) danger++;
				else if(rst == 3) highRisk++;
			}
		}
	}

}