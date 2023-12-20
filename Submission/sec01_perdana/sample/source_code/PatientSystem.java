//This is only example of the Java code
import java.util.*;

class PatientSystem {
	public static void main(String [] a) {
		Vector <Patient> pList = new Vector<Patient>();

		Address add1 = new Address("Jalan Pahlawan", "Skudai", 81300, "Johor");
		Address add2 = new Address("Jalan Flora", "Skudai", 81300, "Johor");
		Address add3 = new Address("Jalan Bakti", "Skudai", 81300, "Johor");

		Doctor d1 = new Doctor("Kumar", "Moorthy", "S0001");
		Doctor d2 = new Doctor("Stephen", "Koh", "S0001");

		pList.add(new Patient("P0001", "Male", "Akmal", "Adnan", add1, 180, 82));
		pList.add(new Patient("P0002", "Male", "Syafiq", "Yusof", add2, 186, 80));
		pList.add(new Patient("P0003", "Female", "Mei Ling", "Koh", add3, 168, 45));

		pList.get(0).attendBy(d1);
		pList.get(1).attendBy(d1);
		pList.get(2).attendBy(d2);

		displayRecord(pList);

		pList.remove(0);
		displayRecord(pList);
	}

	public static void displayRecord(Vector <Patient> v) {
		System.out.println("\nPatient Record Management System");
		System.out.println("================================");
		System.out.println("No PatientID Name Gender Address Height Weight Attend By");
		System.out.println("-- --------- ---- ------ ------- ------ ------ ---------");
		int c = 1;
		for (Patient p: v) {
			System.out.println(c + " " + p.getPatientID() + " " + p.getAddress().getAddress() + " " + p.getHeight() + " " + p.getWeight() + " " + p.getDoctor().getFullName());
			c++;
		}
		System.out.println("-------------------");
		System.out.println("Total Patients: " + v.size());
	}
}



