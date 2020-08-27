
#include "../../../_lib/cpp/catch.hpp"
#include "main.cpp"



TEST_CASE( "CipherText", "[uva]" ) {
    CipherText cText = CipherText("OUR, aTXT");
    REQUIRE( cText.next() == 'O');
    REQUIRE( cText.next() == 'U');
    REQUIRE( cText.next() == 'R');
    REQUIRE( cText.next() == 'T');
    REQUIRE( cText.next() == 'X');
    REQUIRE( cText.next() == 'T');
}



TEST_CASE( "Fibonacci", "[uva]" ) {
    Fibonacci fib = Fibonacci();
    REQUIRE( fib.next() == 1);
    REQUIRE( fib.next() == 2);
    REQUIRE( fib.next() == 3);
    REQUIRE( fib.next() == 5);
    REQUIRE( fib.next() == 8);
    REQUIRE( fib.next() == 13);
    REQUIRE( fib.next() == 21);
    REQUIRE( fib.next() == 34);
    fib.reset();
    REQUIRE( fib.next() == 1);
}
