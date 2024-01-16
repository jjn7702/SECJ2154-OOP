import java.util.Scanner;
import java.util.Vector;
import java.io.PrintWriter;
import java.io.IOException;

public class HospitalApp {
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

					input.nextLine();

					System.out.print("\n\nEnter full name\t: ");
					String fullname = input.nextLine();

					String[] names = fullname.split(" ");

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

					if (names.length == 2) {
						String fname = names[0];
						String lname = names[1];

					Patient patient = new Patient(fname, lname, age, phoneNum, gender, patientAddress,medicalRecord);


					patientList.add(patient);}
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
					System.out.println("-----------------------------------------------------------------------------------------------------");
					System.out.printf("%-15s| %-15s| %-5s| %-7s| %-30s| %-12s| %-10s| %-10s| %-20s\n",
            					"PatientID", "Name", "Age", "Gender", "Address", "Blood Type", "Height", "Weight", "Diagnosis");
					    for (Patient p : patientList) {


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
				System.out.println("4. Exit");
				System.out.println();

				   while(true){
						System.out.print("\nEnter your choice: ");
						int choice = input.nextInt();

					switch(choice){

					case 1:

							String AppointmentID = "A001";

							System.out.print("\n\nEnter patientID: ");
							String patientID = input.next();

							System.out.print("Enter appoinment date	\t: ");
							int date = input.nextInt();

							System.out.print("Enter appoinment time	\t: ");
							int time = input.nextInt();

							System.out.print("Assigned doctor (Doctor id)\t: ");
							String doctorId = input.next();

							displayDoctorDetails(doctorId);



							Appointment appointment = new Appointment(AppointmentID, patientID, date, time, displayDoctorDetails(doctorId));
							appointmentList.add(appointment);
							System.out.println("Appointment added successfully.");
							System.out.println("\n Patient List");
							break;

					case 2:
							System.out.print("Enter Appointment ID of the patient to remove: ");
							String appointmentIDNoToRemove = input.next();

							for (Appointment a :appointmentList)
									   if (a.getAppointmentID().equals(appointmentIDNoToRemove)) {
							appointmentList.remove(a);
							}
							System.out.println("appointment removed successfully.");


								break;

					case 3:
							System.out.println("Appointment List");
							System.out.printf("%-15s| %-15s| %-15s| %-12s| %-15s| %-12s| %-20s\n",
        						"PatientID", "Date", "Time", "DoctorID", "Name", "phoneNum", "Position");
							    for (Appointment a : appointmentList) {

									System.out.println("------------------------------------------------------------------------------------------");

							      System.out.printf("%-15s| %-15s| %-15s| %-12s| %-15s| %-12d| %-20s\n",
								          a.patientID(), a.getDate(), a.getTime(), a.getDoctorId(),
								          displayDoctorDetails(a.getDoctorId()).getName().getFullName(),
								          displayDoctorDetails(a.getDoctorId()).getPhoneNum(),
								          displayDoctorDetails(a.getDoctorId()).getSpecialization(), "Diagnosis");
		    					}
		    					break;

		    		case 4:
		    				System.exit(0);
		    				break;

					}



		}



}

private static Doctor displayDoctorDetails(String doctorId) {
        Doctor d1 = new Doctor(new Name("Dr. Amin", "Afiq"), "D001", 13456789, "General doctor");
        Doctor d2 = new Doctor(new Name("Dr. Maria", "Noor"), "D002", 123456789, "Surgery");
        Doctor d3 = new Doctor(new Name("Dr. Aslam", "Ahmad"), "D003", 1452363887, "Cardiology");

         switch (doctorId) {
		            case "D001":
		                return d1;
		            case "D002":
		                return d2;
		            case "D003":
		                return d3;
		            default:
		                System.out.println("Doctor not found with ID: " + doctorId);
		                return null;
        }

	}


}