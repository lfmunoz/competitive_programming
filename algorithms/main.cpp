
//  main.cpp
//
//

//  include the standard template library (STL)
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

// ________________________________________________________________________________
// HELPER METHODS
// ________________________________________________________________________________

/**
 *   (row 0 col 0)  (row 0 col 1)  (row 0 col 2)
 *   (row 1 col 0)  (row 1 col 1)  (row 1 col 2)
 *   (row 2 col 0)  (row 2 col 1)  (row 2 col 2)
 */ 
void print_matrix(int **arr, int row, int col)
{ 
    for (int x = 0; x < row; x++) { 
        printf("\n");
        for (int y = 0; y < col; y++) {
            printf("%d ", arr[x][y]);
        }
        printf("\n");
    }
}


void print_vector(VI &a_vector) {
    for(auto item: a_vector) {
        printf("%d ", item);
    }
    printf("\n");
}


void print_array(int arr[], uint32 size) {
    for (uint32 i = 0; i < size; i ++) {
        printf("%d ", arr[i]);
    }
    printf("\n");
}

VI copyAndSwap(VI a_vector, uint32 idx_A, uint32 idx_B) {
    int vector_length =  a_vector.size();
    VI new_vector (vector_length);
    copy(a_vector.begin(), a_vector.end(), new_vector.begin());
    int temp = new_vector[idx_A];
    new_vector[idx_A] =  new_vector[idx_B] ;
    new_vector[idx_B] = temp;
    return new_vector;
}


void permutation(VI a_vector, uint32 idx) {
    if(idx == a_vector.size()) {
        print_vector(a_vector);
    }
    for(uint32 i = idx; i < a_vector.size(); i++) {
        VI p_vector = copyAndSwap(a_vector, idx, i);
        permutation(p_vector, idx+1);
    }
}



// ________________________________________________________________________________
// MAIN
// ________________________________________________________________________________
int main() 
{

   VI my_vector = {1,2,3,4};
   permutation(my_vector, 0);
   return 0;
}


