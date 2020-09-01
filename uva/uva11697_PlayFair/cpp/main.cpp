/*

    Playfair Cipher *
    https://www.udebug.com/UVa/11697


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
class Point{
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


    static Point next(Point aPoint) {
        if(aPoint.y >= 4) {
            aPoint.x += 1;
            aPoint.y = 0;
        } else {
            aPoint.y += 1;
        }
        return aPoint;
    }

    static Point nextOnRow(Point aPoint) {
        aPoint.x = (aPoint.x + 1) % 5;
        return aPoint;
    }

    static Point nextOnCol(Point aPoint) {
        aPoint.y = (aPoint.y + 1) % 5;
        return aPoint;
    }


};

map<char, Point> pointTbl;

ostream& operator<<(ostream& os, const Point& obj) { 
    os << "(" << obj.x << "," << obj.y << ")"; 
    return os; 
} 

void mapIterate(std::map<char, Point> &ourMap) {
    std::map<char, Point>::iterator it = ourMap.begin();
    while(it != ourMap.end()) {
        std::cout<< it->first <<" :: "<< it->second << std::endl;
        it++;
    }
}

std::map<char, Point>::iterator searchByValue(Point aPoint) {
    // Iterate through all elements in std::map and search for the passed element
    map<char, Point>::iterator it = pointTbl.begin();
        //    mapIterate(pointTbl); 
    while(it != pointTbl.end()) {
        if( it->second.x == aPoint.x && it->second.y == aPoint.y)  {
            // cout << " found " << aPoint << it->first << " ";
            return it;
        }
        it++;
    }
    return pointTbl.end();
}


void encoded(Point A, Point B) {
    // cout << A << " " << B << "   | ";
    // same row
    if(A.x == B.x) {
        A = Point::nextOnCol(A);
        B = Point::nextOnCol(B);
    } else if(A.y == B.y) {
        A = Point::nextOnRow(A);
        B = Point::nextOnRow(B);
    } else {
        int temp = A.y;
        A = Point(A.x, B.y);
        B = Point(B.x, temp);
    }
    // cout << A << " " << B << "   |";
    cout << (char) toupper(searchByValue(A)->first) << (char) toupper(searchByValue(B)->first); // << endl; 
    // return make_pair(A, B);

}

// ________________________________________________________________________________
// MAIN
// ________________________________________________________________________________

#if !defined(IS_TEST)

// WON'T START OR END WITH SPACE
// ALL LINES HAVE BETWEEN 1 AND 1000 CHARACTERS INCLUSIVE
// ALL LINES WILL BE LOWER CASE
int main() {
    initialize();

    int N;
    string keyText, messageText;
    cin >> N >> ws;
    for(int n = 0; n < N; n++) {
        // read cipher key  phrase
        getline(cin, keyText);
        // read the message phrase
        getline(cin, messageText); 

        pointTbl.clear();
        Point aPoint(0,0);
        

        // for each letter of the key phrase, we put into table
        // we if already in table and we only consider [a-z]
        for(unsigned int k = 0; k < keyText.length(); k++) {
            if(keyText[k] < 'a' || keyText[k] > 'z' ) continue;
            auto it = pointTbl.find(keyText[k]);
            if(it == pointTbl.end()) {
                pointTbl.insert(make_pair(keyText[k], aPoint));
                aPoint = Point::next(aPoint);
            }
        }

        // loop through the alphabet to complete the table
        for(char c = 'a'; c <= 'z'; c++) {
            if ( c == 'q') continue; // skip q
            auto it = pointTbl.find(c);
            if(it == pointTbl.end()) {
                pointTbl.insert(make_pair(c, aPoint));
                aPoint = Point::next(aPoint);
            }
        }
        // mapIterate(pointTbl);

        // loop through the text message and encrypt it using the table
        // cout << "size " << messageText.length() << "\n";
        map<char, Point>::iterator pointA;
        map<char, Point>::iterator pointB;
        for(int idx = 0 ; idx < (int) messageText.length(); idx++) {
            while(!isalpha(messageText[idx]))  idx++; 
            pointA = pointTbl.find(messageText[idx]);
            if(idx == messageText.length() - 1 || messageText[idx] == messageText[idx+1]) {
                pointB = pointTbl.find('x');
            } else {
                idx+=1;
                while(!isalpha(messageText[idx]))  idx++; 
                // while(messageText[idx] < 'a' || messageText[idx] > 'z' )  idx++; 
                pointB = pointTbl.find(messageText[idx]);
            }
            // cout << idx << " " << pointA->first << " " << pointB->first << "\n";
            encoded(pointA->second, pointB->second);
        }
        // if(n != N - 1) 
        cout << "\n";


        // cout << keyText << endl;
        // cout << messageText << endl;

    } // end of problem

    return 0;
} // end of main

#endif