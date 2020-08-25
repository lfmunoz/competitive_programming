


int main() {

    int i = 0;

    int x[3][4] = {0, 1 ,2 ,3 ,4 , 5 , 6 , 7 , 8 , 9 , 10 , 11};
    int x[3][4] = {{0,1,2,3}, {4,5,6,7}, {8,9,10,11}};


}


//With the only difference that with multidimensional arrays 
//the compiler remembers the depth of each imaginary dimension for us.



// Specify the size of columns of 2D array
void processArr(int a[][10]) {
   // Do something
}

// Pass array containing pointers
// When callingint *array[10];
for(int i = 0; i < 10; i++)
   array[i] = new int[10];
processArr(array);

void processArr(int *a[10]) {
   // Do Something
}



// Pass a pointer to a pointer
int x() {
    int **array;
    array = new int *[10];
    for(int i = 0; i <10; i++)
       array[i] = new int[10];
    processArr(array);
}
void processArr(int **a) {
   // Do Something
}

void printMatrix(int matrix[], int r, int c){
     for(int i=0;i<r;i++)
    {
         for(int j=0;j<c;j++)
         {
              cout<<matrix[i*c+j]<<" ";   
         }   
         cout<<endl;
    }   
}

void printMatrix(int *matrix, int r, int c){
     for(int i=0;i<r;i++) {
         for(int j=0;j<c;j++) {
             cout << *(arr+i*c+j);
         }   
         cout<<endl;
    }   
}

printMatrix((int*)arr, 2,2)


// pass only column
// | 1 | 2 | 3 | 4 |
// c tells it how many to skip
void fun(int arr[][c], int r) {
    for(int i = 0; i < r; i++) {
        for(int j = 0; j < c; j++) {
            cout << arr[i][j];
        }
        cout << endl;
    }
}

int main() {
    int arr[2][2] = {
        {1,2}, {3,4}
    };
    fun(arr, 2);
    return 0;
}

