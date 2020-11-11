
#include "../../../_lib/cpp/catch.hpp"
#include "main.cpp"



TEST_CASE( "clean string", "[uva]" ) {
    vector<uint> pattern = find_pattern( "123123");
    REQUIRE( pattern.size() == 3);
    pattern = find_pattern( "1234123412");
    REQUIRE( pattern.size() == 4);
}



TEST_CASE( "verifyPattern", "[uva]" ) {
    vector<uint> pattern {1,2,3,1,2,3};
    REQUIRE( verifyPattern(pattern, 3) == true);
    pattern = {1,2,3,4,1,2,3,4,1,2};
    REQUIRE( verifyPattern(pattern, 4) == true);
}


