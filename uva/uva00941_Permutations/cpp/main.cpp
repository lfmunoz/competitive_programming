/*

    https://www.udebug.com/UVa/941



https://oeis.org/wiki/Factorial_numeral_system
https://www.techtud.com/short-notes/factorial-number-system
https://en.wikipedia.org/wiki/Factorial_number_system

*/

// ________________________________________________________________________________
//  INCLUDE
// ________________________________________________________________________________
#include <bits/stdc++.h>
#include <algorithm>    // std::reverse


using namespace std;

// ________________________________________________________________________________
// GLOBAL
// ________________________________________________________________________________

// ________________________________________________________________________________
// HELPER METHODS
// ________________________________________________________________________________
void initialize() {
    ios_base::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);
    #ifdef DEFAULT
        // freopen("input.txt", "r", stdin);
        // freopen("default.txt", "r", stdin);
    #endif

    std::cout << std::fixed;
    std::cout << std::setprecision(2);

}


template <typename T>
std::ostream& operator<< (std::ostream& out, const std::vector<T>& v) {
  if ( !v.empty() ) {
    out << '[';
    std::copy (v.begin(), v.end(), std::ostream_iterator<T>(out, ", "));
    out << "\b\b]";
  }
  return out;
}


// ________________________________________________________________________________
// SOLUTION
// ________________________________________________________________________________


int currentN, targetN;
string solution;

string swap(string str, int a, int b) {
    char tmp = str[a];
    str[a] = str[b];
    str[b] = tmp;
    return str;
}

/*
Find the largest x such that P[x]<P[x+1].
(If there is no such x, P is the last permutation.)
Find the largest y such that P[x]<P[y].
Swap P[x] and P[y].
Reverse P[x+1 .. n].
*/


string next_perm(string str) {

    int largestX = -1;
    for(unsigned int x = 0; x < str.size()-1; x++) {
        if(str[x] < str[x+1]) largestX = x;
    }

    int largestY = -1;
    for(unsigned int y = 0; y < str.size(); y++) {
        if(str[largestX] < str[y]) largestY = y;
    }
    str = swap(str, largestX, largestY);
    std::reverse(str.begin()+largestX+1, str.end());

    return str;
}


void n_perm(string str, int left, int right) {
    if(left == right) {
        currentN += 1;
        cout << str << endl;
        if(currentN == targetN) {
            // cout << str << "\n";
            // throw "Solution has been found";
        }

        return;
    }

    // for(int i = right; i >= left; i--) {
        // string temp = swap(str, i, left);
        // n_perm(temp, left, right-1);
    // }
    for(int i = left; i <= right; i++) {
        string temp = swap(str, i, left);
        n_perm(temp, left+1, right);
    }
}




vector<int> change_to_factoradic(unsigned long int num) {
    if(num == 0) return vector<int> {0}; 
    vector<int> factoradic{};
    int divider = 1;
    while(num != 0) {
        factoradic.push_back(num % divider);
        num = num /  divider;
        divider += 1;
    }
    reverse(factoradic.begin(), factoradic.end());
    return factoradic;
}

string permutation(vector<int> factoradic, string str) {
    string result = "";
    while(factoradic.size() < str.length()) {
        factoradic.insert(factoradic.begin(), 0);
    }
    for(int digit: factoradic) {
        result += str[digit];
        str.erase(digit, 1);
    }
    return result;
}


// ________________________________________________________________________________
// MAIN
// ________________________________________________________________________________



#if !defined(IS_TEST)

int main() {
    initialize();
    string line; 
    int cases; 
    unsigned long int target;


    cin >> cases >> ws;
    for(int c = 0; c < cases; c++) {
        cin >> line >> ws;
        cin >> target >> ws;
        sort(line.begin(), line.end());
        cout << permutation(change_to_factoradic(target), line) << "\n";
    }

    return 0;
}

#endif