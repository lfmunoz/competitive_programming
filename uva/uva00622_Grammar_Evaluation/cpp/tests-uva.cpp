
#include "../../../_lib/cpp/catch.hpp"
#include "main.cpp"



TEST_CASE( "parse integer ", "[uva]" ) {
    string input = "123_123";
    string::iterator itr = input.begin();
    REQUIRE( parse_integer(itr, input.end()) == 123);
    REQUIRE( *itr == '_');
    itr +=1 ;
    REQUIRE( parse_integer(itr, input.end()) == 123);
}

TEST_CASE( "parse factor", "[uva]" ) {
    string factorA = "123";
    string::iterator itr = factorA.begin();
    REQUIRE( parse_factor(itr, factorA.end()) == 123);

    factorA = "(123)";
    itr = factorA.begin();
    REQUIRE( parse_factor(itr, factorA.end()) == 123);

}


TEST_CASE( "parse component", "[uva]" ) {
    string factorA = "123";
    string::iterator itr = factorA.begin();
    REQUIRE( parse_component(itr, factorA.end()) == 123);

    factorA = "(123)";
    itr = factorA.begin();
    REQUIRE( parse_component(itr, factorA.end()) == 123);

    factorA = "3*4";
    itr = factorA.begin();
    REQUIRE( parse_component(itr, factorA.end()) == 12);

}
