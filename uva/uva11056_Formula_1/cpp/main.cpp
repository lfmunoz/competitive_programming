/*

    https://www.udebug.com/UVa/11056


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

string toLower(string data) {
    std::transform(data.begin(), data.end(), data.begin(),
    [](unsigned char c){ return std::tolower(c); });
    return data;
}


struct Record {
	string name;
	int score;
	Record (string _name, int min, int sec, int ms) {
		name = _name;
		score = (min*60*1000)+(sec*1000)+ms;
	}
	bool operator < (const Record& r2) const {
		if (score == r2.score) {
			string s1 = toLower(name);
            string s2 = toLower(r2.name);
			return s1 < s2;
		}
		return score < r2.score;
	}
};


// ________________________________________________________________________________
// SOLUTION
// ________________________________________________________________________________

// ________________________________________________________________________________
// MAIN
// ________________________________________________________________________________

#if !defined(IS_TEST)

int main() {
    initialize();
    unsigned int N, min, sec, ms;
    string tmp, name;
    vector<Record> records;

    while(cin >> N) {
        records.clear();
        // cout << N << "\n";
        for(unsigned int n = 0; n < N; n++) {
            cin >> name;
            cin >> tmp >> min >> tmp >> sec >> tmp >> ms >> tmp;
            // cout << "name=" << name << " min=" << min << " sec=" << sec << " ms=" << ms << "\n";
            records.push_back(Record(name, min, sec, ms));
        }
        sort (records.begin(), records.end());
        auto itr = records.begin();
        int row = 1;
        while(true) {
            if(itr == records.end()) break;
            cout << "Row " << row << "\n";
            cout << itr->name << "\n";
            itr++;
            if(itr == records.end()) break;
            cout << itr->name << "\n";
            row ++;
            itr++;
        }
        cout << "\n";
    }


    return 0;
}

#endif