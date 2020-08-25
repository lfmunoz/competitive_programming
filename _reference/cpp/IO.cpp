

//  include the standard template library (STL)
#include <bits/stdc++.h>

using namespace std;

// ________________________________________________________________________________
// INPUT
// ________________________________________________________________________________
void read_line_by_line() {
    const string END_OF_IO = "___________";
    int N;
    string line;

    getline(cin, line);
    while(true) {
        getline(cin, line);
        if(line.compare(END_OF_IO) == 0) break;
        cout << line << "\n";
    }
}


void number_then_lines() {
    int N;
    string line;

    cin >> N; 
    // istream& ignore (streamsize n = 1, int delim = EOF);
    cin.ignore(); // eat new line

    for(int n = 0; n < N; n++) {
        getline(cin, line);  /// START ROW
    }
}

// ________________________________________________________________________________
// OUTPUT
// ________________________________________________________________________________