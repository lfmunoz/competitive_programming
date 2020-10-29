/*

    https://www.udebug.com/UVa/00012


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
const int M_SIZE  = 120; 
string buffer[M_SIZE][M_SIZE];

// trim from end (in place)
static inline void rtrim(std::string &s) {
    s.erase(std::find_if(s.rbegin(), s.rend(), [](unsigned char ch) {
        return !std::isspace(ch);
    }).base(), s.end());
}

void clear_buffer() {
    for(int x = 0; x < M_SIZE; x++) {
        for(int y = 0; y < M_SIZE; y++) {
            buffer[x][y] = " ";
        }
    }
}

void draw_axis(int x_origin, int y_origin, int y_max, int x_min) {
    // draw x-axis
    for(int y = 0; y < y_max; y++) {
        buffer[x_origin][y] = "-";
    }

    // draw y-axis
    for(int x = x_origin+1; x >= x_min; x--) {
        buffer[x][0] = "|";
    }
    buffer[x_origin][y_origin] = "+";
}

void draw_buffer(int x_origin, int y_max, int x_min) {
    for(int x = x_min; x <= x_origin; x++) {
        string line = "";
        for(int y = 0; y < y_max; y++) {
            line += buffer[x][y];
        }
        rtrim(line);
        cout << line << "\n";
    }
}



// ________________________________________________________________________________
// MAIN
// ________________________________________________________________________________

#if !defined(IS_TEST)

int main() {
    initialize();

    string line;
    int N;

    
    cin >> N >> ws;
    for(int n = 0; n < N; n++) {
        cout << "Case #" << n+1 << ":" << "\n";
        getline(cin, line);
        clear_buffer();

        int x = M_SIZE/2 -1;
        int y = 2;
        int y_max;
        int x_min = M_SIZE/2;
        int x_max = M_SIZE/2;

        y_max = line.length() + 3; 


        for(char &c : line) {
        // cout << "(" << x << "," << y << ")" << endl;
            if(c == 'R') {
                buffer[x][y] = '/';
                x -= 1;
                y += 1;
                x_min = min(x_min, x+1);
            } else if( c == 'F') {
                x += 1;
                buffer[x][y] = '\\';
                y += 1;
                x_max = max(x_max, x+1);
            } else if( c == 'C') {
                buffer[x][y] = '_';
                y += 1;
                x_min = min(x_min, x);
            }

            // adjust origin

        }
        // cout << "y_max " << y_max << endl;
        // cout << "x_max " << x_max << endl;
        // cout << "x_min " << x_min << endl;
        draw_axis(x_max, 0, y_max, x_min);
        draw_buffer(x_max, y_max, x_min);
        cout << "\n";
    }


    return 0;
}

#endif