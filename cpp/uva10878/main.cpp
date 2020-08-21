/*

    https://www.udebug.com/UVa/10851


*/

// ________________________________________________________________________________
//  INCLUDE
// ________________________________________________________________________________
#include <bits/stdc++.h>

using namespace std;

#if defined(IS_TEST)

#endif

typedef long int int32;
typedef unsigned long int uint32;
typedef long long int int64;
typedef unsigned long long int  uint64;

// ________________________________________________________________________________
// CODE 
// ________________________________________________________________________________

class Symbol  {
    public:
    string encoded;
    string decoded;
    int frequency = 0;

    Symbol(string _encoded) {
        encoded = _encoded;
    }


};

ostream& operator<<(ostream& os, const Symbol& point) 
{ 
    os << "(" << point.encoded << "=" << point.decoded << ")"; 
    return os; 
} 



// ________________________________________________________________________________
// HELPER METHODS
// ________________________________________________________________________________
Symbol* mapContainsKey(std::map<string, Symbol>& map, string key) {
  auto it = map.find(key);
  if ( map.end() != it ) { 
      return &it->second;
  }
  return NULL;
}

// ________________________________________________________________________________
// SOLUTION
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


int intToAscii(int number) {
   return '0' + number;
}

// 0123456789A
// | oo o.ooo|
int stringToInt(string& aLine) {
    aLine.erase(10, 1);
    aLine.erase(6, 1);
    aLine.erase(1, 1);
    aLine.erase(0, 1);

    cout << "size " << aLine.size() << endl;

    int decodedValue = 0;
    for (std::string::size_type i = 0; i < aLine.size(); i++) {
        if(aLine[i] == 'o') {
            decodedValue = (64 >> i + decodedValue);
        } 
    }
    return decodedValue;
}

// ________________________________________________________________________________
// MAIN
// ________________________________________________________________________________
string START_END = "___________";
map<string, Symbol> symbolVector;
map<string, int> mapStringInt;

#if !defined(IS_TEST)

int main() {
    initialize();
    string line;
    getline(cin, line);
    int x = 0;
    while(true) {
        getline(cin, line);
        if(line.compare(START_END) == 0) break;
        // cout <<  ( char )stringToInt(line);
        cout <<  stringToInt(line);
        cout << endl;
        x++;

        if(x == 4) break;
    }
    cout << "\n";

    return 0;
}

#endif