
#include "../../../_lib/cpp/catch.hpp"
#include "main.cpp"


TEST_CASE( "set bit", "[uva]" ) {
    unsigned char ourByte = 0; 
    REQUIRE( set_bit(&ourByte, 0) == 1);
    ourByte = 0;
    REQUIRE( set_bit(&ourByte, 1) == 2);
    ourByte = 0;
    REQUIRE( set_bit(&ourByte, 2) == 4);
}

