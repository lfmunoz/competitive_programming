/*

UVa10258 -

https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=16&page=show_problem&problem=1796
https://www.udebug.com/UVa/10258

Runtime 

*/

package uva10258;

// Copy-paste from here...

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

class Main {
    public static void main(String[] args) throws Exception {
        UVa10258 uva = new UVa10258();
        //uva.runTest();
        uva.run();
    }
}

class Contestant {
    private int contestantId;
    private int problemsSolved;
    private int penalty;


    public void display() {
        System.out.println( Integer.toString(contestantId) + " " +
                            Integer.toString(problemsSolved) + " " +
                            Integer.toString(penalty));
    }
}


class UVa10258 {

    private String fileName = "/home/luis/projects/competitive_programming/src/main/resources/uva10258_in.txt";


    //Map<Integer, Map<Integer, Integer>> scoreBoard = new HashMap<>();
    List<Contestant> scoreBoard = new ArrayList<>();

    public void run() {
        Scanner scan = readFile(fileName);
        //Scanner scan =read();

        int num = Integer.parseInt(scan.nextLine()); // number of sets
        String blank = scan.nextLine(); // blank line

        while (scan.hasNext()) {
            String score = scan.nextLine();
            if (!score.isEmpty()) {
                //System.out.println(score);
                String[] fields = score.split(" ");
                int contestant = Integer.parseInt(fields[0]);
                int problem = Integer.parseInt(fields[1]);
                int penalty = Integer.parseInt(fields[2]);
                String outcome = fields[3];

                if (outcome.equals("C")) {
                    correct(contestant, problem, penalty);
                } else if (outcome.equals("I")) {
                    incorrect(contestant, problem, penalty);
                }
            }
        } // end of while
        compute();
    } // end of run

    private void correct(int contestant, int problem, int penalty) {

        // contestant is not known
        if (!scoreBoard.containsKey(contestant)) {
        if (!scoreBoard.containsKey(contestant)) {
            Map<Integer, Integer> problem_entry = new HashMap<>();
            problem_entry.put(problem, penalty);
            scoreBoard.put(contestant, problem_entry);
        // contestant is known
        } else {
            Map<Integer, Integer> contestant_entry = scoreBoard.get(contestant);
            if (!contestant_entry.containsKey(problem)) {
                contestant_entry.put(problem, penalty);
            }
        }
    }

    /* possible problem here where we might have a bunch of incorrect solutions and
    no correct solutions. this would count for a problem solved when it really shouldn't
    i'll hack this and make it so if 20 then or some rare number is choosen then we
    know it is an incomplete
     */
    private void incorrect(int contestant, int problem, int penalty) {
        // contestant is not known
        if (!scoreBoard.containsKey(contestant)) {
            Map<Integer, Integer> problem_entry = new HashMap<>();
            problem_entry.put(problem, 20);
            scoreBoard.put(contestant, problem_entry);
        // contestant is known
        } else {
            Map<Integer, Integer> contestant_entry = scoreBoard.get(contestant);
            if (!contestant_entry.containsKey(problem)) {
                contestant_entry.put(problem, penalty);
            } else {
               Integer penalty_entry = contestant_entry.get(problem);
               contestant_entry.put(problem, 20+penalty_entry);
            }
        }

    }

    private void compute() {
        for (Integer contestantKey : scoreBoard.keySet()) {
            Map<Integer, Integer> problem = scoreBoard.get(contestantKey);
            Integer totalProblems = 0;
            Integer totalPenalty = 0;
            for (Integer problemKey: problem.keySet()) {
                totalProblems++;
                totalPenalty += problem.get(problemKey);
            }
            System.out.println(Integer.toString(contestantKey) + " " +
            Integer.toString(totalProblems) + " " +
                    Integer.toString(totalPenalty));
        }
    }

    ////////////////////////////////////////////////////////////////////
    // Input/Output Specific Functions
    ////////////////////////////////////////////////////////////////////
    public Scanner read() {
        Scanner scan = new Scanner(System.in);
        return scan;
    }

    public static Scanner readFile(String fileName) {
        File file = new File(fileName);
        try {
            Scanner scan = new Scanner(file);
            return scan;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

}
