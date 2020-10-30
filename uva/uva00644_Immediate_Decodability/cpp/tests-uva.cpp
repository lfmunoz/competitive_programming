
#include "../../../_lib/cpp/catch.hpp"
#include "main.cpp"



TEST_CASE( "clean string", "[uva]" ) {
    REQUIRE( isPrefix("0001", "00") == true);
    REQUIRE( isPrefix("0001", "01") == false);
    REQUIRE( isPrefix("0001", "1") == false);
    REQUIRE( isPrefix("0001", "10") == false);
    REQUIRE( isPrefix("0001", "0000") == false);

    REQUIRE( isPrefix("10", "0010") == false);
    REQUIRE( isPrefix("0010", "10") == false);
}


