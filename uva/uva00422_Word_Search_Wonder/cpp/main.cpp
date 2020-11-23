/*

    https://www.udebug.com/UVa/00422


*/

// ________________________________________________________________________________
//  INCLUDE
// ________________________________________________________________________________
#include <bits/stdc++.h>

typedef unsigned int uint;

using namespace std;

// ________________________________________________________________________________
// GLOBAL
// ________________________________________________________________________________

// ________________________________________________________________________________
// HELPER METHODS
// ________________________________________________________________________________
void initialize()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);
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
int matrix[100][100];
int size;


void show(int x1, int y1, int x2, int y2) {
    cout << x1 << "," << y1 << " " << x2 << "," << y2 << "\n";
}

bool findHorizontal(const string& word, int x, int y) {
    int end = word.length() + y;
    if(end > size) return false;
    for(int i = 0; i < word.length(); i++) {
        if(matrix[x][y+i] != word[i]) return false;
    }
    cout << x+1 << "," << y+1 << " " << x+1 << "," << y + word.length() << "\n";
    return true;
}

bool findHorizontalBackwards(const string& word, int x, int y) {
    int end = word.length() + y;
    if(end > size) return false;
    for(int i = 0; i < word.length(); i++) {
        if(matrix[x][y+i] != word[word.length() - i - 1]) return false;
    }
    show(x+1, y + word.length(), x+1, y+1);
    return true;
}

bool findVertical(const string& word, int x, int y) {
    int end = word.length() + x;
    if(end > size) return false;
    for(int i = 0; i < word.length(); i++) {
        if(matrix[x+i][y] != word[i]) return false;
    }
    cout << x+1 << "," << y+1 << " " << x + word.length() << "," << y+1 << "\n";
    return true;

}

bool findDiagonalDownRight(const string& word, int x, int y) {
    if(word.length() + x > size || word.length() + y > size) return false;
    for(int i = 0; i < word.length(); i++) {
        if(matrix[x+i][y+i] != word[i]) return false;
    }
    cout << x+1 << "," << y+1 << " " << x + word.length() << "," << y + word.length() << "\n";
    return true;
}

bool findDiagonalLeftUp(const string& word, int x, int y) {
    if(word.length() + x > size || word.length() + y > size) return false;
    for(int i = 0; i < word.length(); i++) {
        if(matrix[x+i][y+i] != word[word.length() - i - 1]) return false;
    }
    show(x+word.length(), y + word.length(), x+1, y+1);
    return true;
}


bool findDiagonalDownLeft(const string& word, int x, int y) {
    if(word.length() + x > size || word.length() - y > 0 ) return false;
    for(int i = 0; i < word.length(); i++) {
        if(matrix[x+i][y-i] != word[i]) return false;
    }
    cout << x+1 << "," << y+1 << " " << x + word.length() << "," << y - (word.length()-2) << "\n";
    return true;
}

bool findDiagonalUpRight(const string& word, int x, int y) {
    if(word.length() + x > size || word.length() - y > 0 ) return false;
    for(int i = 0; i < word.length(); i++) {
        if(matrix[x+i][y-i] != word[word.length() - i - 1]) return false;
    }
    show(x+word.length(), y - (word.length()-2), x+1, y+1);
    return true;
}







void scanMatrix(const string& line) {
    for(int i = 0; i < size; i++) {
        for(int j = 0; j < size; j++) {
            if(
                findHorizontal(line, i, j) || 
                findHorizontalBackwards(line, i, j) || 
                findVertical(line, i, j) || 
                findDiagonalDownRight(line, i, j) || 
                findDiagonalLeftUp(line, i, j) || 
                findDiagonalDownLeft(line, i, j) || 
                findDiagonalUpRight(line, i, j)
            ) return;
        }
    }
    cout << "Not found" << "\n";
}

// ________________________________________________________________________________
// MAIN
// ________________________________________________________________________________

#if !defined(IS_TEST)

int main() {
    initialize();

    string line;
    cin >> size;

    for(int i = 0; i < size; i++) {
        cin >> line;
        for (int j = 0; j < line.size(); j++) {
            matrix[i][j] = line[j];
        }
    }

    while(true) {
        cin >> line;
        if(line == "0") break;
        scanMatrix(line);
    }

    return 0;
}

#endif