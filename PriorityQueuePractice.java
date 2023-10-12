import java.util.PriorityQueue;

class Student implements Comparable<Student> {
    public String name;
    public int rank;

    public Student() {
        this.name = "";
        this.rank = 0;
    }

    public Student(String name, int rank) {
        this.name = name;
        this.rank = rank;
    }

    @Override
    public int compareTo(Student s) {
        return this.rank - s.rank;
    }
}

public class PriorityQueuePractice {
    public static void main(String[] args) {
        // PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

        // pq.add(3);
        // pq.add(4);
        // pq.add(1);
        // pq.add(7);

        // while(!pq.isEmpty()) {
        // System.out.print(pq.remove() + " ");
        // }

        PriorityQueue<Student> pq = new PriorityQueue<Student>();

        pq.add(new Student("A", 3));
        pq.add(new Student("B", 6));
        pq.add(new Student("N", 1));
        pq.add(new Student("O", 4));

        while (!pq.isEmpty()) {
            Student s = pq.remove();
            System.out.println("Name: " + s.name + ", Rank: " + s.rank);
        }
    }
}
