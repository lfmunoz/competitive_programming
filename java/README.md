Competitive Programming
=====



Build
-----


Binary Indexed(Fenwick) Tree
Segment Tree



Skipped SegmentTree
UVa11402


    $ rebar3 compile

 while (scan.hasNext()) {
 
 
int a = scn.nextInt();
String b = scn.nextLine();
scan.hasNext()

My favourite way, how to read input is to use BufferedReader:

BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
number of test cases defined
if number of test cases is defines (typically first line in input file), I'm doing...

int T = Integer.parseInt( br.readLine() )
while ( T-- > 0 ) {
    // for each test case
    String[] tmp = br.readLine().split( " " ); // typically separated by 1 space
    // in your case, there are 2 integers in line
    int i1 = Integer.parseInt( tmp[0] );
    int i2 = Integer.parseInt( tmp[1] );
    solve( i1, i2 ); // solve() method solves one test case
}
special end case
Sometimes there is special case that simply defines end of test file, for example in your case it could be "0 0", in such case I'd do:

String line = br.readLine();
while ( ! "0 0".equals( line ) ) {
    // for each test case, very similar to the previous code
    String[] tmp = line.split( " " );
    int i1 = Integer.parseInt( tmp[0] );
    int i2 = Integer.parseInt( tmp[1] );
    solve( i1, i2 );
    line = br.readLine(); // do not forget to read next line !
}
no special end case
In this case you simply stop when you reach the end of file. It's very similar to the previous one again:

String line = br.readLine();
while ( line != null ) {
    // for each test case, very similar to the previous code
    String[] tmp = line.split( " " );
    int i1 = Integer.parseInt( tmp[0] );
    int i2 = Integer.parseInt( tmp[1] );
    solve( i1, i2 );
    line = br.readLine();
}



Convert Recursion to Iteration
http://blog.moertel.com/archive.html




Recursive Backtracking


    String display(Pair[] result) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < result.length-1; i++) {
            sb.append(result[i]);
            sb.append(" ");
        }
        sb.append(result[result.length-1]);
        return sb.toString();
    }

    void swap(int[] result, int a, int b) {
        int tmp = result[a];
        result[a] = result[b];
        result[b] = tmp;
    }
    void indent(int n) {
        for(int i =0; i < n; i++) {
            System.out.printf(" ");
        }

    }