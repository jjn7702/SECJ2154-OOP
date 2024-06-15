public class Kursus {
    private String kursusID;
    private String time;
    private String date;
    private String kursusPlace;
    private String nameUstaz;

    public Kursus(String kursusID, String time, String date, String kursusPlace, String nameUstaz) {
        this.kursusID = kursusID;
        this.time = time;
        this.date = date;
        this.kursusPlace = kursusPlace;
        this.nameUstaz = nameUstaz;
    }

    public void Display_Kursus_info() {
        System.out.printf("%-5s %-8s %-12s %-30s %-15s\n", kursusID, time, date, kursusPlace, nameUstaz);
    }
}
