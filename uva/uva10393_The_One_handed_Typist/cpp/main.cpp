/*

    https://www.udebug.com/UVa/10393


*/

// ________________________________________________________________________________
//  INCLUDE
// ________________________________________________________________________________
#include <bits/stdc++.h>

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

template <typename T>
std::ostream& operator<< (std::ostream& out, const std::set<T>& v) {
  if ( !v.empty() ) {
    out << '[';
    std::copy (v.begin(), v.end(), std::ostream_iterator<T>(out, ", "));
    out << "\b\b]";
  }
  return out;
}



string vector_to_string(const vector<string> &v) {
    string s;
    for (const auto &piece : v) s += piece;
    return s;
}
// ________________________________________________________________________________
// SOLUTION
// ________________________________________________________________________________
vector<string> fingerTbl {"qaz", "wsx", "edc", "rfvtgb", 
    " ", " ", "yhnujm", "ik,", "ol.", "p;/"};


bool contains(string check, string find) {
    for(char letter: find) {
        if(check.find(letter) == std::string::npos) {
            return false;
        } 
    }
    return true;
}



// ________________________________________________________________________________
// MAIN
// ________________________________________________________________________________

#if !defined(IS_TEST)

int main() {
    initialize();

    int F, N, a;
    string word;
    vector<int> fingersCannotUse;

    while(cin >> F >> N) {
        fingersCannotUse.clear();

        while(F--) {
            cin>>a;
            fingersCannotUse.push_back(a);
        }
        vector<string> fingerTblCopy = fingerTbl;
        std::reverse(fingersCannotUse.begin(),fingersCannotUse.end());
        for(auto i : fingersCannotUse) {
            fingerTblCopy.erase(fingerTblCopy.begin() + i - 1);
        }
        string validChars = vector_to_string(fingerTblCopy);
        // cout << "valid chars= " << validChars << "\n";
        set<string> results;
        unsigned int maximum = 0;
        for(int w = 0; w < N; w++) {
            cin >> word;
            if(contains(validChars, word)) {
                if(word.size() > maximum) {
                    maximum = word.length();
                    results.clear();
                    results.insert(word);
                } else if (word.size() == maximum) {
                    results.insert(word);
                }
            }
        }

        cout << results.size() << "\n";
        for(string word: results) {
            cout << word << "\n";
        }
    }


    return 0;
}

#endif