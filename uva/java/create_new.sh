#!//bin/bash

PWD=`pwd`
NAME=$1
CODE_DST=$PWD/src/main/java/UVa$NAME.java
IO_DST=$PWD/src/main/resources



### Create the input and output test files
touch $IO_DST/uva${NAME}_in.txt
touch $IO_DST/uva${NAME}_out.txt


### Create the .Java File
cat > $CODE_DST << EOF
/*

UVa$NAME -

https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=16&page=show_problem&problem=1796
https://www.udebug.com/UVa/$NAME

Runtime 

*/

package uva$NAME;

// Copy-paste from here...
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Main {
    public static void main(String[] args) throws Exception {
        UVa$NAME uva = new UVa$NAME();
        //uva.runTest();
        uva.run();
    }
}


class UVa$NAME {

    private String fileName = "/home/luis/projects/competitive_programming/src/main/resources/uva${NAME}_in.txt";

    public void run() {
        //Scanner scan =readFile(fileName);
        //BufferedReader scan =readwithBuffer(); // use readLine()
        Scanner scan =read();

        while (true) {
            String dimensions = scan.nextLine();
            String[] values = dimensions.split(" ");
            int N = Integer.parseInt(values[0]);
            int n = Integer.parseInt(values[1]);
            if (N == 0) break;

            char[][] bigSquare = new char[N][N];
            for(int x = 0; x < N; x++) {
                String row = scan.nextLine();
                bigSquare[x] = row.toCharArray();
            }
            char[][] smallSquare = new char[n][n];
            for(int x = 0; x < n; x++) {
                String row = scan.nextLine();
                smallSquare[x] = row.toCharArray();
            }
            compute(smallSquare, bigSquare);
        }
    }

    private void compute(char[][] smallSquare, char[][] bigSquare) {

        for(int x = 0; x < N; x++) {
            for(int y = 0; y < N; y++) {
                String submatrix = stringMatrix(bigSquare, y, x, n);
                if (submatrix != null ) {
                    if (submatrix.equals(deg0)) c0++;
                    if (submatrix.equals(deg90)) c90++;
                    if (submatrix.equals(deg180)) c180++;
                    if (submatrix.equals(deg270)) c270++;
                }
            }
        }
        System.out.println(c0 + " " + c90 + " " + c180 + " " + c270);
    }

    ////////////////////////////////////////////////////////////////////
    // Input/Output Specific Functions
    ////////////////////////////////////////////////////////////////////
    public Scanner read() {
        Scanner scan = new Scanner(System.in);
        return scan;
    }

    public BufferedReader readwithBuffer() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        return br;
    }

    public static Scanner readFile(String fileName) {
        File file = new File(fileName);
        try {
            Scanner scan = new Scanner(file);
            return  scan;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

}
EOF

cat >> $PWD/Makefile << EOF
#######################################################
$NAME:
	--mkdir -p target/classes
	@echo "Runnning UVA${NAME}"
	javac (SRC)/UVa${NAME}.java -d (TARGET)
	java -cp (TARGET) uva$NAME.Main < (RSRC)/uva${NAME}_in.txt | diff -s -y (RSRC)/uva${NAME}_out.txt -

EOF



