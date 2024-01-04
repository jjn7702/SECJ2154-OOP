package Project.job.joblist;

import java.util.*;
import java.io.*;


class Job {
    private String title, description;
    private double pay;
    Company company;

    public Job(String title, double pay){
        this.title = title;
        this.pay = pay;
    }

    String getTitle(){return title;}
    double getPay(){return pay;}
    String getDescription(){return description;}

}

class JobReader {
    public List<Job> readJob(String jobList.txt) {
        List<Job> jobList = new ArrayList<>();

        try (BufferedReadr br = new BufferedReader (new FileReader(jobList.txt))){
            String line;
            String jobTitle = "";
            double pay = 0.0;

            while ((line = br.readline()) != null) {
                if (!line.trim().isEmpty()) {
                    if (jobTitle.isEmpty()) {
                        jobTItle = line.trim();
                    } else {
                        pay = parsePayFromString(line.trim());
                        if (pay != -1) {
                            Job job = new Job(jobTitle, pay);
                            jobList.add(job);
                            jobTitle = "";
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStactTrace();
        }
        return jobList;
    }

    private double parsePay(String payString) {
        try{
            String payValue = payString.substring(3).trim();
            return Double.parseDouble(payValue);
        } catch (NumberFormatException | StringIndexOutOfBoundsException e) {
            System.out.println("Invalid pay");
        }
        return -1;
    }
}

