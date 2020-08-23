/*

    https://www.udebug.com/UVa/00000


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
// CODE 
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


vector<Point> vec_points;
double minOfVector = DBL_MAX;


// ________________________________________________________________________________
// HELPER METHODS
// ________________________________________________________________________________
double distance(Point pA, Point pB) {
    return sqrt( pow(pA.x - pB.x, 2 ) + pow(pA.y - pB.y, 2)) + 16;
}

double total_distance(vector<Point> pVector) {
    double total = 0;
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
        minOfVector = std::min(minOfVector,total_distance(a_vector));
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
        freopen("input.txt", "r", stdin);
        // freopen("default.txt", "r", stdin);
    #endif

    std::cout << std::fixed;
    std::cout << std::setprecision(2);
}

void compute(const vector<Point> &aVector ) {
    int N = aVector.size() - 1;
    permutation(aVector, 0);
}

// ________________________________________________________________________________
// MAIN
// ________________________________________________________________________________

int main() {
    initialize();
    // uint32 X, Y, N;
    uint32 N;
    while(true) {
        cin >> N;
        if(N == 0) break;
        for(uint32 i = 0; i < N;  i++) {
            Point aPoint;
            cin >> aPoint.x >> aPoint.y;
            vec_points.push_back(aPoint);
        }
        compute(vec_points);
        cout << minOfVector << "\n";
    }

    // cout << vec_points << "\n";


    return 0;
}


