
// ________________________________________________________________________________
//  INCLUDE
// ________________________________________________________________________________
#include <bits/stdc++.h>

using namespace std;

// ________________________________________________________________________________
// Point
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

    string to_string() {
        return "";
    }
    

};

ostream& operator<<(ostream& os, const Point& point) { 
    os << "(" << point.x << " " << point.y << ")"; 
    return os; 
} 

double distance(Point pA, Point pB) {
    return sqrt( pow(pA.x - pB.x, 2 ) + pow(pA.y - pB.y, 2)) + 16;
}

double total_distance(vector<Point> aVector) {
    double total = 0;
    for(int i = 0; i < aVector.size() - 1; i++) {
        total += distance(aVector[i], aVector[i+1]);
    }
    return total;
}





