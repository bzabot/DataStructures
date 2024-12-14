import java.util.Scanner;

// Main class
class ED237 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // Create a RoundRobin object
        RoundRobin r = new RoundRobin(scn);
        // Get data for the RoundRobin object
        r.getData();
        // Execute the RoundRobin algorithm
        r.RR();

        // Print the result
        System.out.println(r.ans);
    }
}

// RoundRobin class
class RoundRobin {
    private Scanner s; // Scanner object to read input
    private int T; // Time quantum
    private MyQueue<Process> processQueue = new LinkedListQueue<>(); // Queue to hold processes
    String ans = ""; // String to store the result

    // Constructor
    RoundRobin(Scanner scn) {
        s = scn;
    }

    // Method to get data from input
    public void getData() {
        T = s.nextInt(); // Read time quantum
        int n_processos = s.nextInt(); // Read number of processes
        s.nextLine(); // Move to the next line
        for (int i = 0; i < n_processos; i++) {
            getProcess(); // Get each process
        }
    }

    // Method to get a process from input
    private void getProcess() {
        String[] l = s.nextLine().split(" "); // Read and split the input line
        Process p = new Process(l[0], Integer.parseInt(l[1])); // Create a new process
        processQueue.enqueue(p); // Add the process to the queue
    }

    // Method to execute the RoundRobin algorithm
    public void RR() {
        int round = 0; // Initialize round counter
        int total_time = 0; // Initialize total time counter
        // While the queue is not empty
        while (!processQueue.isEmpty()) {
            round++; // Increment round counter
            if (processQueue.first().tempo > T) { // If the process time is greater than the time quantum
                processQueue.first().tempo -= T; // Decrease the process time by the time quantum
                processQueue.enqueue(processQueue.dequeue()); // Move the process to the end of the queue
                total_time += T; // Increment total time by the time quantum
            } else if (processQueue.first().tempo <= T) { // If the process time is less than or equal to the time
                                                          // quantum
                total_time += processQueue.first().tempo; // Increment total time by the process time
                ans += processQueue.first().nome + " " + total_time + " " + round; // Add the process result to the
                                                                                   // answer
                processQueue.dequeue(); // Remove the process from the queue
                if (!processQueue.isEmpty()) { // If the queue is not empty
                    ans += "\n"; // Add a newline to the answer
                }
            }
        }
    }
}

// Process class represents a process with a name and a time
class Process {
    String nome; // Process name
    int tempo; // Process time

    // Constructor
    Process(String n, int t) {
        nome = n;
        tempo = t;
    }
}