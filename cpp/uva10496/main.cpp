/*

    https://www.udebug.com/UVa/10496


*/

// ________________________________________________________________________________
//  INCLUDE
// ________________________________________________________________________________
#include <bits/stdc++.h>

using namespace std;

//  http://www.cplusplus.com/reference/algorithm/min_element/
#define PI 3.1415926535897932384626433832795

typedef pair<int, int> PII;
typedef vector<int> VI;
typedef vector<vector<int>> VIVI;
typedef vector<string> VS;
typedef vector<PII> VII;
typedef vector<VI> VVI;
typedef map<int,int> MPII;
typedef set<int> SETI;
typedef multiset<int> MSETI;

typedef long int int32;
typedef unsigned long int uint32;
typedef long long int int64;
typedef unsigned long long int  uint64;

#define DEFAULT
// ________________________________________________________________________________
// DATA STRUCTURES
// ________________________________________________________________________________
class Point  {
    public:
        int x;
        int y;

    Point() {
        x = 0;
        y = 0;
    }

    Point(int _x, int _y) {
        x = _x;
        y = _y;
    }

    string toString() {
        return "";
    }
    

};

template <typename T> 
ostream& operator<<(ostream& os, const vector<T>& v) 
{ 
    os << "["; 
    for (uint32 i = 0; i < v.size(); ++i) { 
        os << v[i]; 
        if (i != v.size() - 1) 
            os << ", "; 
    } 
    os << "]\n"; 
    return os; 
} 

ostream& operator<<(ostream& os, const Point& point) 
{ 
    os << "(" << point.x << " " << point.y << ")"; 
    return os; 
} 

// ________________________________________________________________________________
// GLOBAL VARIABLES
// ________________________________________________________________________________
uint32 minOfVector = INT_MAX;

// ________________________________________________________________________________
// HELPER METHODS
// ________________________________________________________________________________
uint32 distance(Point pA, Point pB) {
    uint32 distanceA = abs(pA.x - pB.x);
    uint32 distanceB = abs(pA.y - pB.y);
    return distanceA + distanceB;
}

uint32 total_distance(vector<Point> pVector) {
    uint32 total = 0;
    for(uint32 i = 0; i < pVector.size() - 1; i++) {
        total += distance(pVector[i], pVector[i+1]);
    }
    return total;
}


vector<Point> copyAndSwap(vector<Point> a_vector, uint32 idx_A, uint32 idx_B) {
    int vector_length =  a_vector.size();
    vector<Point> new_vector (vector_length);
    copy(a_vector.begin(), a_vector.end(), new_vector.begin());
    Point temp = new_vector[idx_A];
    new_vector[idx_A] =  new_vector[idx_B] ;
    new_vector[idx_B] = temp;
    return new_vector;
}

void permutation(vector<Point> a_vector, uint32 idx) {
    if(idx == a_vector.size()) {
        uint32 distanceToStart = distance(a_vector.back(), a_vector.front());
        minOfVector = std::min(minOfVector, total_distance(a_vector) + distanceToStart);
        // cout << a_vector;
        return;
    }
    for(uint32 i = idx; i < a_vector.size(); i++) {
        vector<Point> p_vector = copyAndSwap(a_vector, idx, i);
        permutation(p_vector, idx+1);
    }
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


// ________________________________________________________________________________
// MAIN
// ________________________________________________________________________________

int main() {
    initialize();
    uint32 S, Wx, Wy, Kx, Ky, B, Bx, By;
    cin >> S; // Scenarios
    for(uint32 scenario = 0; scenario < S; scenario++) {
        cin >> Wx >> Wy; // World size
        cin >> Kx >> Ky; // Karel starting position
        cin >> B; // Number of beepers
        vector<Point> beeperVector(B+1);
         beeperVector[0] = Point(Kx, Ky);
        for(uint32 beeper=1; beeper < B+1; beeper++) {
            cin >> Bx >> By;
            beeperVector[beeper] = Point(Bx, By);
        }
        permutation(beeperVector, 1);
        cout << "The shortest path has length " << minOfVector << "\n";
        minOfVector = INT_MAX;
        beeperVector.clear();
    }

    // cout << vec_points << "\n";


    return 0;
}


