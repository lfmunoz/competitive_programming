/*

    https://www.udebug.com/UVa/216

    https://stackoverflow.com/questions/58352944/how-to-run-program-in-a-pop-out-console-window-using-vs-code

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
    os << "(" << point.x << "," << point.y << ")"; 
    return os; 
} 

template<typename T>
std::vector<T> create_copy(std::vector<T> const &vec)
{
	std::vector<T> v(vec);
	return v;
}


double minOfVector;
vector<Point> minPointsVector;
vector<Point> currentPointsVector;

map<string, Point> memomizeMap; 


// ________________________________________________________________________________
// HELPER METHODS
// ________________________________________________________________________________
double distance(Point pA, Point pB) {
    double distance = sqrt( pow(pA.x - pB.x, 2 ) + pow(pA.y - pB.y, 2)) + 16;
    return distance;
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


void permutation(const vector<Point> a_vector, uint32 idx) {
    if(idx == a_vector.size()) {
        // cout << idx << endl;
        double distance = total_distance(a_vector);
        if( distance <  minOfVector) {
            // cout << distance << " is smaller than " << minOfVector << endl;
            // cout << "set to " << a_vector << endl;
            minOfVector = distance;
            minPointsVector = create_copy(a_vector);
        }
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
    cin.tie(0); 
    // cout.tie(0);
    #ifdef DEFAULT
        // printf("DEFAULT is defined \n");
        // freopen("input.txt", "r", stdin);
        // freopen("inputB.txt", "r", stdin);
    #endif

    std::cout << std::fixed;
    std::cout << std::setprecision(2);
}

// ________________________________________________________________________________
// MAIN
// ________________________________________________________________________________


int main() {
    initialize();
    // uint32 X, Y, N;
    uint32 N;
    uint32 problemNumber = 1;
    while(true) {
        minOfVector = DBL_MAX;
        minPointsVector.clear();
        currentPointsVector.clear();
        cin >> N;
        if(N == 0) break;
        for(uint32 i = 0; i < N;  i++) {
            Point aPoint;
            cin >> aPoint.x >> aPoint.y;
            currentPointsVector.push_back(aPoint);
        }
        permutation(currentPointsVector, 0);

        // cout << minOfVector << endl;
        // cout << minPointsVector << endl;
        // cout << currentPointsVector << endl;

        double total = 0;
        cout << "**********************************************************" << endl;
        cout << "Network #" << problemNumber++ << "\n";
        for(uint32 i = 0; i < minPointsVector.size() - 1; i++) {
            double dist = distance(minPointsVector[i], minPointsVector[i+1]);
            cout << "Cable requirement to connect " << minPointsVector[i]
                 << " to " << minPointsVector[i+1] << " is " << dist 
                 << " feet." << "\n";
            total += dist;
        }
        cout << "Number of feet of cable required is " << total << ".\n";

    }


    return 0;
}


