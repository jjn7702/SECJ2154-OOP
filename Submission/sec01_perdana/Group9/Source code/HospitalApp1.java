import java.util.Scanner;
import java.util.Vector;
import java.io.PrintWriter;
import java.io.IOException;

public class HospitalApp1 {
	 public static void main(String[] args) throws IOException{

		Vector<Patient> patientList = new Vector<>();
		PrintWriter outputFile = new PrintWriter("Bill.txt");
		Scanner input = new Scanner(System.in);

		System.out.println("Welcome to Hospital Sultanah Ibrahim management");

		System.out.println("\n1. Patient");
		System.out.println("2. Appointment");
		System.out.println("3. Exit");
		System.out.println();


		 while(true){
				System.out.print("\nEnter your choice: ");

		 		int choice = input.nextInt();
				switch(choice){

			case 1:
					patientMenu();
					break;

			case 2:
					appointmentMenu();
					break;
		}
	}


		           //patient.displayInfo();
				  // doctor.displayInfo();
				  // appointment.displayInfo();
				  // medicalRecord.displayInfo();
				  // bill.displayInfo();




        			/*outputFile.printf("\nAppointment ID: " + appointment.getAppointmentID());
					outputFile.printf("\nAppointment Date: " + appointment.getDate());
					outputFile.printf("\nAppointment Time: " + appointment.getTime());
					outputFile.printf("\nPatient ID in Appointment: " + appointment.getPatientID());
					outputFile.printf("\nDoctor Name in Appointment: " + appointment.getName());

					outputFile.printf("\n\nMedical Record Details:");
					outputFile.printf("\nBlood Type: " + medicalRecord.getBloodType());
					outputFile.printf("\nWeight: " + medicalRecord.getWeight() + "KG");
					outputFile.printf("\nHeight: " + medicalRecord.getHeight() + "CM");

					outputFile.printf("\nBill ID: " + bill.getBillID());
        			outputFile.printf("\nBill Amount: RM" + bill.getAmount());*/

        			//outputFile.close();
	    }

	   public static void patientMenu(){

		   Vector<Patient> patientList = new Vector<>();
		   Scanner input = new Scanner(System.in);


		   System.out.print("--- Patient details --"); // -- patient

		   System.out.println("\n1. Add patient");
		   System.out.println("2. Delete patient");
		   System.out.println("3. Display patient");
		   System.out.println("4. Exit");
		   System.out.println();

		   while(true){
				System.out.print("\nEnter your choice: ");
				int choice = input.nextInt();

			switch(choice){

			case 1:

					System.out.print("\n\nEnter first name\t: ");
					String fname = input.next();

					System.out.print("Enter last name	\t: ");
					String lname = input.next();

					System.out.print("Enter age	\t: ");
					int age = input.nextInt();

					System.out.print("Enter gender	\t: ");
					String gender = input.next();

					System.out.print("Enter phone Number\t: ");
					int phoneNum = input.nextInt();

					input.nextLine();

					System.out.print("Enter Street	\t: ");
					String Street = input.nextLine();

					System.out.print("Enter city	\t: ");
					String city = input.nextLine();
 					System.out.println();

 					System.out.print("--- Please insert medical record patient --"); // -- medical record

					System.out.print("\n\nEnter blood type\t: ");
					String bloodtype = input.next();

					System.out.print("Enter weight	\t: ");
					double weight = input.nextDouble();

					System.out.print("Enter height	\t: ");
					double height = input.nextDouble();

					input.nextLine();

					System.out.print("Enter disease	\t: ");
					String disease = input.nextLine();

					System.out.println();


					Address patientAddress = new Address(Street, city);
					MedicalRecord medicalRecord = new MedicalRecord( bloodtype, weight, height, disease);
					Patient patient = new Patient(firstName, lastName, phoneNum, age, gender,  address, medicalRecord);


					patientList.add(patient);
					System.out.println("Patient added successfully.");
					System.out.println("\n Patient List");
					break;

			case 2:
					System.out.print("Enter Patient ID of the patient to remove: ");
					String patientIDNoToRemove = input.next();

					for (Patient p : patientList)
							   if (p.getPatientID().equals(patientIDNoToRemove)) {
					patientList.remove(p);
					}
					System.out.println("patient removed successfully.");


						break;

			case 3:
					System.out.println("Patient List");
					System.out.printf("%-15s| %-15s| %-5s| %-7s| %-30s| %-12s| %-10s| %-10s| %-20s\n",
            					"PatientID", "Name", "Age", "Gender", "Address", "Blood Type", "Height", "Weight", "Diagnosis");
					    for (Patient p : patientList) {
							System.out.println("------------------------------------------------------------------------------------------");

					        System.out.printf("%-15s| %-15s| %-5d| %-7s| %-30s| %-12s| %-10.2f| %-10.2f| %-20s\n",
							                p.getPatientID(), p.getName().getFullName(), p.getAge(), p.getGender(),
							                p.getAddress().getAddress(), p.getMedicalRecord().getBloodType(),
							                p.getMedicalRecord().getHeight(), p.getMedicalRecord().getWeight(),
                p.getMedicalRecord().getDiagnosis());
    					}

		}
	}
}

		public static void appointmentMenu(){

			Vector<Appointment> appointmentList = new Vector<>();
		   Scanner input = new Scanner(System.in);
		System.out.println("\n1. Add appointment");
		System.out.println("2. Delete appointment");
		System.out.println("3. Update appointment");
		System.out.println("4. Display appointment");
		System.out.println();

				   while(true){
						System.out.print("\nEnter your choice: ");
						int choice = input.nextInt();

					switch(choice){

					case 1:

							System.out.print("\n\nEnter patientID: ");
							String patientID = input.next();

							System.out.print("Enter appoinment date	\t: ");
							int date = input.nextInt();

							System.out.print("Enter appoinment time	\t: ");
							int time = input.nextInt();

							System.out.print("Enter doctor id	\t: ");
							String doctorid = input.next();

							Doctor doctor = new Doctor(new Name("Dr.", "afiq"), doctorid,987654321,  "Cardiology");
							//Doctor doctor = new Doctor(n, 987654321, "Cardiology");

							Appointment appointment = new Appointment(patientID, date, time, doctor);
							appointmentList.add(appointment);
							System.out.println("Appointment added successfully.");
							System.out.println("\n Patient List");
							break;

					case 2:
							/*System.out.print("Enter Patient ID of the patient to remove: ");
							String patientIDNoToRemove = input.next();

							for (Patient p : patientList)
									   if (p.getPatientID().equals(patientIDNoToRemove)) {
							patientList.remove(p);
							}
							System.out.println("patient removed successfully.");*/


								break;

					case 3:
							/*System.out.println("Patient List");
							System.out.printf("%-15s| %-15s| %-5s| %-7s| %-30s| %-12s| %-10s| %-10s| %-20s\n",
		            					"PatientID", "Name", "Age", "Gender", "Address", "Blood Type", "Height", "Weight", "Diagnosis");
							    for (Patient p : patientList) {
									System.out.println("------------------------------------------------------------------------------------------");

							        System.out.printf("%-15s| %-15s| %-5d| %-7s| %-30s| %-12s| %-10.2f| %-10.2f| %-20s\n",
									                p.getPatientID(), p.getName().getFullName(), p.getAge(), p.getGender(),
									                p.getAddress().getAddress(), p.getMedicalRecord().getBloodType(),
									                p.getMedicalRecord().getHeight(), p.getMedicalRecord().getWeight(),
		                p.getMedicalRecord().getDiagnosis());
		    					}*/

		}

		}

}

}