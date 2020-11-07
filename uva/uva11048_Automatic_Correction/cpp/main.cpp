/*

    https://www.udebug.com/UVa/11048

    Easy just gotta be careful with each case.
    Tricky part is that the order of evaluation is important, you must
    the dict words in the order they are provided.

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

// ________________________________________________________________________________
// SOLUTION
// ________________________________________________________________________________
vector<string> dict;

bool check_missing_or_extra_letter(string dict, string word) {
    string smallest;
    string largest;
    if(dict.length() == word.length() + 1 ) {
        // extra letter
        largest = dict;
        smallest = word;
    } else if(dict.length() + 1 == word.length()) {
        // missing letter
        largest = word;
        smallest = dict;
    } else {
        return false;
    }

    bool flag = false;
    auto sItr = smallest.begin();
    auto lItr = largest.begin();
    while(sItr != smallest.end()) {
        if(*sItr != *lItr) {
            if(flag) return false;
            flag = true;
            lItr++;
            continue;
        }
        sItr++;
        lItr++;
    }
    cout << word << " is a misspelling of " << dict << "\n";
    return true;
}


bool check_order_is_wrong(string dict, string word) {
    if(dict.length() != word.length())  return false;
    auto dItr = dict.begin();
    auto wItr = word.begin();
    bool errorFlag = false;
    while(wItr != word.end()) {
            if(*dItr != *wItr) {
                if(errorFlag) return false;
                errorFlag = true;
                if(*dItr == *(wItr+1) && *(dItr+1) == *(wItr)) {
                    dItr += 1;
                    wItr += 1;
                } else {
                    return false;
                }
            } 
            dItr += 1;
            wItr += 1;
    }
    cout << word << " is a misspelling of " << dict << "\n";
    return true;
}

bool check_one_letter_wrong(string dict, string word) {
    if(dict.length() != word.length())  return false;
    auto dItr = dict.begin();
    auto wItr = word.begin();
    bool errorFlag = false;
    while(wItr != word.end()) {
            if(*dItr != *wItr) {
                if(errorFlag) return false;
                errorFlag = true;
            } 
            dItr += 1;
            wItr += 1;
    }
    cout << word << " is a misspelling of " << dict << "\n";
    return true;
}

bool check_misspelling(string query) {
     for(const string word : dict) {
            if( check_missing_or_extra_letter(word, query) ||
                check_one_letter_wrong(word, query) ||
                check_order_is_wrong(word, query) 
              ) {
                return true;
            }
     }
     return false;
}


bool vector_find(string query) {
    for(string word: dict) {
        if(word == query) {
            cout << query << " is correct" << "\n";
            return true;
        } 
    }
    return false;
}

// ________________________________________________________________________________
// MAIN
// ________________________________________________________________________________

#if !defined(IS_TEST)

int main() {
    initialize();
    int N, Q;
    string word, query;

check_missing_or_extra_letter("a", "su");

    cin >> N;
    while(N--) { 
        cin >> word;
        dict.push_back(word);
    }
    cin >> Q;
    while(Q--) {
        cin >> query;

        if(vector_find(query)) {
            continue;
        }
        
        if(check_misspelling(query)) {
            continue;
        }
        cout << query << " is unknown" << "\n";
    }

    return 0;
}

#endif