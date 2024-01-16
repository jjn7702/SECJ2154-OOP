import java.io.*;
import java.util.Scanner;
import java.util.Vector;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.FileNotFoundException;

public class HospitalApp {
	 public static void main(String[] args) throws IOException{
		Scanner input = new Scanner(System.in);
		  try {

		            Scanner inp = new Scanner(new File("Doctors.txt"));

		            String id, name, phoneNum, specialization;

		            System.out.println("Welcome to Hospital Sultanah Ibrahim management");

		            System.out.println("\n-------------------List of doctors-----------------------");

		            System.out.printf("\n%-9s%-17s%-15s%-2s\n","ID", "Name", "Phone Number", "Specialization");

		            while (inp.hasNext()) {
						id = inp.next();
		                name = inp.next();
		                phoneNum = inp.next();
		                specialization = inp.nextLine().trim();

		                // Print data with appropriate spacing
		                System.out.printf("%-9s%-9s%-10s%-15s\n", id, name, phoneNum, specialization);
		            }

		            inp.close();
		        } catch (IOException e) {
		            System.err.println("Error reading the file: " + e.getMessage());
		        } catch (Exception e) {
		            System.err.println("An unexpected error occurred: " + e.getMessage());
        }






		 while(true){

			System.out.println("\n1. Patient");
			System.out.println("2. Appointment");
			System.out.println("3. Exit");
			System.out.println();

				System.out.print("Enter your choice: ");

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
}

	   public static void patientMenu(){

		   Vector<Patient> patientList = new Vector<>();
		   Scanner input = new Scanner(System.in);


		   while(true){

			System.out.print("\n--- Patient Management --"); // -- patient
			System.out.println("\n1. Add patient");
		   System.out.println("2. Delete patient");
		   System.out.println("3. Display patient");
		   System.out.println("4. Exit");
		   System.out.println();

				System.out.print("\nPlease enter your choice: ");
				int choice = input.nextInt();

			switch(choice){

			case 1:

					input.nextLine();

					System.out.print("\nEnter full name	\t: ");
					String fullname = input.nextLine();

					String[] names = fullname.split(" ");

					System.out.print("Enter age	\t: ");
					int age = input.nextInt();

					System.out.print("Enter gender	\t: ");
					String gender = input.next();

					System.out.print("Enter phone Number\t: ");
					String phoneNum = input.next();

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
					int weight = input.nextInt();

					System.out.print("Enter height	\t: ");
					int height = input.nextInt();

					input.nextLine();

					System.out.print("Enter disease	\t: ");
					String disease = input.nextLine();

					System.out.println();




					if (names.length == 2) {
						String fname = names[0];
						String lname = names[1];
				Address patientAddress = new Address(Street, city);
					MedicalRecord medicalRecord = new MedicalRecord( bloodtype, weight, height, disease);
					Patient patient = new Patient(fname, lname, age, phoneNum, gender, patientAddress,medicalRecord);
					patientList.add(patient);
					}

					System.out.println("Patient added successfully.");
					break;

			case 2:
					System.out.print("Enter Patient ID of the patient to remove: ");
					String patientIDNoToRemove = input.next();

					 boolean removed = false;

					        for (int i = 0; i < patientList.size(); i++) {
					            Patient p = patientList.get(i);
					            if (p.getPatientID().equals(patientIDNoToRemove)) {
					                patientList.remove(i);
					                removed = true;
					                break;
					            }
					        }

					        if (removed) {
					            System.out.println("Patient removed successfully.");
					        } else {
					            System.out.println("Patient with ID " + patientIDNoToRemove + " not found.");
					        }

					        if (patientList.isEmpty()) {
					            System.out.println("No patient data available.");
        }


						break;

			case 3:

					if (patientList.isEmpty()) {
						    System.out.println("No patient data available.");
						} else {

					System.out.println("-------------------------------------- Patient List --------------------------------------------------------------------------------------------------");
					System.out.printf("%-15s| %-20s| %-15s| %-7s| %-30s| %-12s| %-15s| %-15s| %-20s\n",
            					"PatientID", "Name", "Age", "Gender", "Address", "Blood Type", "Height", "Weight", "Diagnosis");
            		System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------");


					    for (Patient p : patientList) {


					        System.out.printf("%-15s| %-20s| %-15s| %-7s| %-30s| %-12s| %-15s| %-15s| %-20s\n",
							                p.getPatientID(), p.getName().getFullName(), p.getAge(), p.getGender(),
							                p.getAddress().getAddress(), p.getMedicalRecord().getBloodType(),
							                p.getMedicalRecord().getHeight(), p.getMedicalRecord().getWeight(), p.getMedicalRecord().getDiagnosis());
    					}
					}
    					break;

    					case 4:

    					return;

		}
	}
}


		public static void appointmentMenu() throws FileNotFoundException{

			Vector<Appointment> appointmentList = new Vector<>();
		   	Scanner input = new Scanner(System.in);
		   	PrintWriter outputFile = new PrintWriter("Bill.txt");

		   	String doctorId;

				System.out.print("\n--- Appointment --"); // -- patient
				System.out.println("\n1. Add appointment");
				System.out.println("2. Delete appointment");
				System.out.println("3. Display appointment");
				System.out.println("4. Print bill");
				System.out.println("5. Exit");
				System.out.println();

				   while(true){
						System.out.print("\nEnter your choice: ");
						int choice = input.nextInt();

					switch(choice){

					case 1:

							String AppointmentID = "A001";

							System.out.print("\nEnter patientID		\t: ");
							String patientID = input.next();

							System.out.print("Enter appoinment date	\t: ");
							String date = input.next();

							System.out.print("Enter appoinment time	\t: ");
							String time = input.next();

							System.out.print("Assigned doctor (Doctor id)\t: ");
							doctorId = input.next();

							displayDoctorDetails(doctorId);

							Appointment appointment = new Appointment(AppointmentID, patientID, date, time, displayDoctorDetails(doctorId));
							appointmentList.add(appointment);


							System.out.println("Appointment added successfully.");
							break;

					case 2:


							System.out.print("Enter Patient ID of the patient to remove: ");
							String ptIDNoToRemove = input.next();
							boolean removed = false;

							 for (int i = 0; i < appointmentList.size(); i++) {
					            Appointment a = appointmentList.get(i);
								if (a.patientID().equals(ptIDNoToRemove)) {
									appointmentList.remove(i);
									removed = true;
									break;  // // Exit the loop once the patient is removed.
					            }
					        }

					        if (removed) {
					            System.out.println("Appointment removed successfully.");
					        } else {
					            System.out.println("Appointment patient with ID " + ptIDNoToRemove + " not found.");
					        }

					        if (appointmentList.isEmpty()) {
					            System.out.println("No patient data available.");
        }

								break;

					case 3:

					if (appointmentList.isEmpty()) {
						 System.out.println("No patient data available.");
						} else {
							System.out.println("Appointment List");
							System.out.printf("%-15s| %-15s| %-15s| %-12s| %-15s| %-12s| %-20s|\n",
        						"PatientID", "Date", "Time", "DoctorID", "Name", "phoneNum", "Specialization");
							    for (Appointment a : appointmentList) {

									System.out.println("---------------------------------------------------------------------------------------------------------------");

							      System.out.printf("%-15s| %-15s| %-15s| %-12s| %-15s| %-12s| %-20s\n",
								          a.patientID(), a.getDate(), a.getTime(), a.getDoctorId(),
								          displayDoctorDetails(a.getDoctorId()).getName().getFullName(),
								          displayDoctorDetails(a.getDoctorId()).getPhoneNum(),
								          displayDoctorDetails(a.getDoctorId()).getSpecialization(), "Diagnosis");
		    					}
							}
		    					System.out.println();
		    					break;

		    		case 4:
							System.out.print("Enter PatientID	\t: ");
							String idpesakit = input.next();

							System.out.print("Enter amount	\t: ");
							Double amount = input.nextDouble();

							System.out.printf("\n----Receipt----- " );

							for (Appointment a : appointmentList) {

								Bill bill = new Bill("B001", amount, a);
								if (a.patientID().equals(idpesakit)){
									System.out.printf("\nAppointment ID		\t: " + a.getAppointmentID());
							        System.out.printf("\nAppointment Date	\t: " + a.getDate());
							        System.out.printf("\nAppointment Time	\t: " + a.getTime());
							        System.out.printf("\nPatient ID in Appointment\t: " + a.patientID());
							        System.out.printf("\nDoctor ID in Appointment\t: " + a.getDoctorId());
									  System.out.printf("\nBill ID			\t: " + bill.getBillID());
							        System.out.printf("\nBill Amount		\t: RM" + amount);
							        System.out.println();


									outputFile.printf("\n-----------Receipt------------");
							        outputFile.printf("\nAppointment ID: " + a.getAppointmentID());
							        outputFile.printf("\nAppointment Date: " + a.getDate());
							        outputFile.printf("\nAppointment Time: " + a.getTime());
							        outputFile.printf("\nPatient ID in Appointment: " + a.patientID());
							        outputFile.printf("\nDoctor ID in Appointment: " + a.getDoctorId());

							        outputFile.printf("\nBill ID: " + bill.getBillID());
							        outputFile.printf("\nBill Amount: RM" + amount);
							        outputFile.println();  }// Separate each bill entry with a newline
							    }

   							 outputFile.close();

		    				break;

		    		case 5:

		    				return;


					}



		}



}

private static Doctor displayDoctorDetails(String doctorId) {
        Doctor d1 = new Doctor(new Name("Dr. Amin", "Afiq"), "D001", "013456789", "General doctor");
        Doctor d2 = new Doctor(new Name("Dr. Maria", "Noor"), "D002", "0123456789", "Surgeon");
        Doctor d3 = new Doctor(new Name("Dr. Aslam", "Ahmad"), "D003", "01452363887", "Cardiology");

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