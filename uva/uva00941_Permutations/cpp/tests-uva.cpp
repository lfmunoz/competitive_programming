
#include "../../../_lib/cpp/catch.hpp"
#include "main.cpp"



TEST_CASE( "swap", "[uva]" ) {
    REQUIRE( swap("abc", 0,1).compare("bac") == 0);
    REQUIRE( swap("abc", 0,2).compare("cba") == 0);
}


/*
 012
 021
 102
 120
 201
 210
*/
TEST_CASE( "next_perm", "[uva]" ) {
    REQUIRE( next_perm("012").compare("021") == 0);
    REQUIRE( next_perm("021").compare("102") == 0);
    REQUIRE( next_perm("102").compare("120") == 0);
    REQUIRE( next_perm("120").compare("201") == 0);
    REQUIRE( next_perm("201").compare("210") == 0);
}

TEST_CASE( "change_to_factoradic", "[uva]" ) {
    REQUIRE( change_to_factoradic(0) == vector<int> {0} );
    REQUIRE( change_to_factoradic(1) == vector<int> {1,0} );
    REQUIRE( change_to_factoradic(2) == vector<int> {1,0,0} );
    REQUIRE( change_to_factoradic(3) == vector<int> {1,1,0} );
    REQUIRE( change_to_factoradic(4) == vector<int> {2,0,0} );
    REQUIRE( change_to_factoradic(5) == vector<int> {2,1,0} );

    REQUIRE( change_to_factoradic(6 ) == vector<int> {1,0,0,0} );
    REQUIRE( change_to_factoradic(7 ) == vector<int> {1,0,1,0} );
    REQUIRE( change_to_factoradic(8 ) == vector<int> {1,1,0,0} );
    REQUIRE( change_to_factoradic(9 ) == vector<int> {1,1,1,0} );
    REQUIRE( change_to_factoradic(10) == vector<int> {1,2,0,0} );
    REQUIRE( change_to_factoradic(11) == vector<int> {1,2,1,0} );
    REQUIRE( change_to_factoradic(12) == vector<int> {2,0,0,0} );
    REQUIRE( change_to_factoradic(89) == vector<int> {3,2,2,1,0} );
}

TEST_CASE( "permutation", "[uva]" ) {
    REQUIRE( permutation(vector<int>{0}, "012").compare("012") == 0 );
    REQUIRE( permutation(vector<int>{1,0}, "012").compare("021") == 0 );
    REQUIRE( permutation(vector<int>{1,0,0}, "012").compare("102") == 0 );
    REQUIRE( permutation(vector<int>{1,1,0}, "012").compare("120") == 0 );
}
