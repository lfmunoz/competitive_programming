
#include "../_lib/catch.hpp"
#include "main.cpp"


TEST_CASE( "decode string to integer", "[uva]" ) {
    string aLine = "| oooo.ooo|";
    // REQUIRE( stringToInt(aLine) == 64);
    REQUIRE( stringToInt(aLine) == 1);
}

