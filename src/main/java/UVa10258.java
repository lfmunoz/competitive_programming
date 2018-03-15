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
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

class Main {
    public static void main(String[] args) throws Exception {
        UVa10258 uva = new UVa10258();
        uva.run();
    }
}

class Contestant {
    private int contestantId;
    public int problemsSolved;
    public int penalty;

    private Set<Integer> solvedSet = new HashSet<>();
    private Map<Integer, Integer> solveTax = new HashMap<>();


    // new correct entry
    Contestant(int contestant, int problem, int penalty) {
        this.contestantId = contestant;
        this.problemsSolved = 1;
        this.penalty = penalty;
        this.solvedSet.add(problem);
    }

    // new incorrect entry
    Contestant(int contestant, int problem) {
        this.contestantId = contestant;
        this.problemsSolved = 0;
        solveTax.put(problem, 20);
        this.penalty = 0;
    }


    Contestant(int contestant) {
        this.contestantId = contestant;
        this.problemsSolved = 0;
        this.penalty = 0;
    }

    public void add_correct(int problem, int penalty) {
        if (!solvedSet.contains(problem)) {
            this.problemsSolved += 1;
            this.penalty += penalty;
            if (solveTax.containsKey(problem)) {
                this.penalty += solveTax.get(problem);
            }
            this.solvedSet.add(problem);
        }
    }

    public void add_incorrect(int problem, int penalty) {
        // if we haven't solved problem
        if (!solvedSet.contains(problem)) {
            // if we no entry for this problem add an entry
            if (!solveTax.containsKey(problem)) {
                solveTax.put(problem, 20);
                // if we have an entry increment entry
            } else {
                int updatePenalty = solveTax.get(problem);
                solveTax.put(problem, updatePenalty + 20);
            }
        }
    }

    public void display() {
        System.out.println(Integer.toString(contestantId) + " " +
                Integer.toString(problemsSolved) + " " +
                Integer.toString(penalty));
    }
}


class UVa10258 {

    private String fileName = "/home/luis/projects/competitive_programming/src/main/resources/uva10258_in.txt";


    //Map<Integer, Map<Integer, Integer>> scoreBoard = new HashMap<>();
    List<Contestant> scoreBoard = Arrays.asList(new Contestant[101]);

    public void run() {
        //Scanner scan = readFile(fileName);
        Scanner scan = read();

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
                } else {
                    neither(contestant, problem, penalty);
                }
            } else {
                compute();
                scoreBoard = Arrays.asList(new Contestant[101]);
                System.out.println("");
            }
        } // end of while
        compute();
    } // end of run

    private void correct(int contestant, int problem, int penalty) {
        // System.out.println(Integer.toString(contestant));
        // contestant is not known
        if (scoreBoard.get(contestant) == null) {
            scoreBoard.set(contestant, new Contestant(contestant, problem, penalty));
            // contestant is known
        } else {
            scoreBoard.get(contestant).add_correct(problem, penalty);
        }
    }

    private void incorrect(int contestant, int problem, int penalty) {
        // contestant is not known
        if (scoreBoard.get(contestant) == null) {
            scoreBoard.set(contestant, new Contestant(contestant, problem ));
            // contestant is known
        } else {
            scoreBoard.get(contestant).add_incorrect(problem, penalty);
        }
    }

    private void neither(int contestant, int problem, int penalty) {
        // contestant is not known
        if (scoreBoard.get(contestant) == null) {
            scoreBoard.set(contestant, new Contestant(contestant));
        }
    }

    private void compute() {
        Collections.sort(scoreBoard, new Comparator<Contestant>() {
            @Override
            public int compare(Contestant o1, Contestant o2) {
                if (o1 == null && o2 == null) {
                    return 0;
                }
                if (o1 == null) {
                    return 1;
                }
                if (o2 == null) {
                    return -1;
                }
                if (o1.problemsSolved > o2.problemsSolved) {
                    return -1;
                } else if (o1.problemsSolved < o2.problemsSolved) {
                    return 1;
                } else {
                    //return 0;

                    if (o1.penalty > o2.penalty) {
                        return 1;
                    } else if (o1.penalty < o2.penalty) {
                        return -1;
                    } else {
                        return 0;
                    }

                }
            }
        });

        for (int c = 0; c < scoreBoard.size(); c++) {
            if (scoreBoard.get(c) != null) {
                scoreBoard.get(c).display();
            }
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
