/*

    LFM00000

    Prove that if you have a list of numbers in sorted order
    but with gaps, the fastest way to search through it is 
    using a divide in half method.

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

template <typename T>
std::ostream& operator<< (std::ostream& out, const std::vector<T>& v) {
  if ( !v.empty() ) {
    out << '[';
    std::copy (v.begin(), v.end(), std::ostream_iterator<T>(out, ", "));
    out << "\b\b]";
  }
  return out;
}



// ________________________________________________________________________________
// SOLUTION
// ________________________________________________________________________________

vector<uint> number_list;


uint random_uint() {
    return rand();
}


uint find_number_half(vector<uint> &numbers, uint find, uint start, uint end) {
    if(end < start) return -1;
    uint middle = start + (end - start) / 2;
    if(numbers[middle] == find) return middle;
    if(numbers[middle] > find) {
        return find_number_half(numbers, find, start, middle-1);
    }
    return find_number_half(numbers, find, middle+1, end);

}

// ________________________________________________________________________________
// MAIN
// ________________________________________________________________________________
const uint SIZE = 1000000;


#if !defined(IS_TEST)

int main() {
    initialize();
    // vector<unsigned int> numbers{1,2,3,4,5};
    // cout <<    find_number_half(numbers, 4, 0, 4)  << endl;

    for(int i = 0; i < SIZE; i++) {
        number_list.push_back(random_uint());
    }

    sort(number_list.begin(), number_list.end());

    unsigned int random_index = rand() % (SIZE);
    unsigned int random_number = number_list[random_index];

    // cout << number_list << endl;

    uint found_index = find_number_half(number_list, random_number, 0, SIZE-1);

    cout << found_index << "==" << random_index << endl;

    return 0;
}

#endif