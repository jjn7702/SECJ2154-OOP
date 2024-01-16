public class MedicalRecord {
    private String bloodType;
    private int weight;
    private int height;
    private String diagnosis;

    public MedicalRecord(String bloodType, int weight, int height, String diagnosis) {
        this.bloodType = bloodType;
        this.weight = weight;
        this.height = height;
        this.diagnosis = diagnosis;
    }

    public String getBloodType() {
        return bloodType;
    }

    public int getWeight() {
        return weight;
    }

    public int getHeight() {
        return height;
    }

    public String getDiagnosis() {
	        return diagnosis;
    }

}