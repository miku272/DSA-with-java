/* Given an array of jobs where every job has a deadline and profit if the job is finished before deadline. It is also given that every job takes a single unit of time, so the minimum possible deadline for any job is 1. Maximize the total profit if only one job can be scheduled at a time.
 * 
 * Job A = 4, 20
 * Job B = 1, 10
 * Job C = 1, 40
 * Job D = 1, 30
 * 
 * and = C, A
 */

import java.util.ArrayList;
import java.util.Collections;

class Job {
    int id; // 0 (A), 1 (B), 2 (C), 3(D), ...
    int deadLine;
    int profit;

    public Job(int id, int deadLine, int profit) {
        this.id = id;
        this.deadLine = deadLine;
        this.profit = profit;
    }
}

public class JobSequencing {
    public static void main(String[] args) {
        int[][] jobsInfo = { { 4, 20 }, { 1, 10 }, { 1, 40 }, { 1, 30 } };
        ArrayList<Job> jobs = new ArrayList<Job>();

        for (int i = 0; i < jobsInfo.length; i++) {
            jobs.add(new Job(i, jobsInfo[i][0], jobsInfo[i][1]));
        }

        Collections.sort(jobs, (a, b) -> b.profit - a.profit); // In descending order according to profit

        ArrayList<Integer> sequence = new ArrayList<Integer>();
        int time = 0;
        int maxProfit = 0;

        for (int i = 0; i < jobs.size(); i++) {
            Job currentJob = jobs.get(i);

            if (currentJob.deadLine > time) {
                sequence.add(currentJob.id);
                time++;
                maxProfit += currentJob.profit;
            }
        }

        System.out.println("Max jobs: " + sequence.size());
        System.out.println("Max profit: " + maxProfit);

        System.out.print("Sequence: ");
        for (int i = 0; i < sequence.size(); i++) {
            System.out.print(sequence.get(i) + " ");
        }
    }
}
