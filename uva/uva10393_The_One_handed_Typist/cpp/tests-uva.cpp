
#include "../../../_lib/cpp/catch.hpp"
#include "main.cpp"



TEST_CASE( "contains", "[uva]" ) {
    REQUIRE( contains("123456", "12") == true);
    REQUIRE( contains("123456", "13") == true);
    REQUIRE( contains("123456", " ") == false);
    REQUIRE( contains("123456", "6") == true);
    REQUIRE( contains("123456", "8") == false);
    REQUIRE( contains("123456", "18") == false);
}


