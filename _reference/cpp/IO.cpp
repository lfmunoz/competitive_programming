

//  include the standard template library (STL)
#include <bits/stdc++.h>

using namespace std;




Reference
https://abitofcs.blogspot.com/search/label/UVa
http://www.cplusplus.com/reference/vector/vector/size/

## Common input patterns

```

//  include the standard template library (STL)
#include <bits/stdc++.h>

using namespace std;




int n, k, t; 
int cnt = 0; 
cin >> n >> k; 
for (int i=0; i<n; i++) { 
  cin >> t; 
  if (t % k == 0) cnt++; 
} 



int length; cin >> length;
vector<int> sequence; sequence.reserve(length);
copy_n(istream_iterator<int>(cin), length, back_inserter(sequence));


int rows, cols; cin >> rows >> cols; 
vector<vector<int>> matrix; matrix.resize(rows); 
for (auto& row : matrix)
{    
   row.reserve(cols); 
   copy_n(istream_iterator<int>(cin), cols, back_inserter(row)); 
}



cin >> N >> std::ws;
getline(cin, line);



int N, T, t; cin >> N >> T;
vector<int> arr; arr.reserve(N);
copy_n(istream_iterator<int>(cin), N, back_inserter(arr));
// pre-process here
while (T--) 
{
  cin >> t;
  // solve here
}



```

## Common output patterns

```

cout << ans1 << " " << ans2 << "\n";


cout << fixed << setprecision(2) << num1 << " " << num2;


```


Reference

```
#include <vector>
#include <set>
#include <algorithm>
#include <iostream>

using namespace std;


int main() {

  // VECTOR
  vector<int> A = {1,3,4,5};
  // O(NlogN)
  sort(A.begin(), A.end()); 

  // O(logN)
  bool present = binary_search(A.begin(), A.end(), 3);

  A.push_back(100); 
  A.push_back(100); 

  // find first occurrence of 100
  vector<int>::iterator it = lower_bound(A.begin(), A.end(), 100);

  for(int &x : A) // reference 
  {
    x++;
  }

  for(int x : A) {
    count << x << " ";
  }
  cout << "\n";


  // SET


  // kept in ascending order
  // insert LogN 
  set<int> S;
  S.insert(1);
  S.insert(2);
  s.insert(-1);

  auto it = S.find(-1);
  if( it == S.end()) // not present


}


```


// ________________________________________________________________________________
// INPUT
// ________________________________________________________________________________
void read_line_by_line_until_x() {
    const string END_OF_IO = "___________";
    int N;
    string line;

    getline(cin, line);
    while(true) {
        getline(cin, line);
        if(line.compare(END_OF_IO) == 0) break;
        cout << line << "\n";
    }
}

void read_line_by_line_until_eof() {
    string line;

    // cin.getline() stops at the character designated by third argument . default \n
    while(getline(cin, line)) {
    }
     cout << n << ": " << s << endl;  // last line
}



void number_then_lines() {
    int N;
    string line;

    cin >> N; 
    // istream& ignore (streamsize n = 1, int delim = EOF);
    cin.ignore(); // eat new line

    for(int n = 0; n < N; n++) {
        getline(cin, line);  /// START ROW
    }
}

// ________________________________________________________________________________
// OUTPUT
// ________________________________________________________________________________