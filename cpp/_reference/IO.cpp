

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




// ________________________________________________________________________________
// OUTPUT
// ________________________________________________________________________________