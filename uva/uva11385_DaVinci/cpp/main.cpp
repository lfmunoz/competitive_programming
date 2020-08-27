/*
    https://www.udebug.com/UVa/11385
*/

// ________________________________________________________________________________
//  INCLUDE
// ________________________________________________________________________________
#include <bits/stdc++.h>

using namespace std;

// ________________________________________________________________________________
// GLOBAL
// ________________________________________________________________________________
template <typename T> 
ostream& operator<<(ostream& os, const vector<T>& v) 
{ 
    os << "["; 
    for (unsigned int i = 0; i < v.size(); ++i) { 
        os << v[i]; 
        if (i != v.size() - 1) 
            os << ", "; 
    } 
    os << "]"; 
    return os; 
} 

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
class CipherText {
    unsigned int idx = 0;

    public:
        string m_text;

    CipherText(string text) {
        m_text = text;
    }

    char next() {
        char letter = m_text[idx];
        while( letter < 'A' || letter > 'Z') {
            letter = m_text[++idx];
        }
        idx += 1;
        return letter;
    }
};

class Fibonacci {
    unsigned int idx = 0;
    vector<int> numbers = {1,2,3,5,8,13};
    public:
        Fibonacci() { }

        int next() {
            if(idx == numbers.size()) {
                numbers.push_back(numbers[idx-2] + numbers[idx-1]);
            }
            return numbers[idx++];
        }

        void reset() {
            idx = 0;
        }
};


// ________________________________________________________________________________
// MAIN
// ________________________________________________________________________________

#if !defined(IS_TEST)

int main() {
    initialize();

    Fibonacci fib = Fibonacci();

    int T, N;
    string cipherText;
    cin >> T >> ws;
    // cout << "T=" << T << "\n";
    for(int t = 0; t < T; t++) {
        fib.reset();
        cin >> N >> ws; // number of cipher text
        // cout << "N=" << N << "\n";
        vector<int> fibonacciVector; 
        fibonacciVector.reserve(N);
        copy_n(istream_iterator<int>(cin), N, back_inserter(fibonacciVector));
        cin >> ws;
        // cout << fibonacciVector << "\n";
        getline(cin, cipherText);
        CipherText cText = CipherText(cipherText);
        // cout << cipherText << "\n";
        map<int, char> decoderTable;

        for(int n = 0; n < N; n++) {
            int key = fibonacciVector[n];
            decoderTable[key] = cText.next();
        }

        for(int n = 0; n < N; n++) {
            int key = fib.next();
            auto it = decoderTable.find(key);
            while(it == decoderTable.end()) {
                cout << " "; 
                key =  fib.next();
                it = decoderTable.find(key);
            }
            cout << it->second;
        }
        cout << "\n";

    }
    return 0;
}
#endif