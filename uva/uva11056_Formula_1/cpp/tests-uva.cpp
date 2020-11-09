
#include "../../../_lib/cpp/catch.hpp"
#include "main.cpp"



TEST_CASE( "toLower", "[uva]" ) {
    string input = "AbC"; 
    REQUIRE( toLower(input) == "abc");
}


TEST_CASE( "string_score", "[uva]" ) {

    REQUIRE( string_score("aa") == string_score("aa"));

    REQUIRE( string_score("a1") > string_score("aA"));
    REQUIRE( string_score("aA") > string_score("Aa"));
    REQUIRE( string_score("Aa") > string_score("aa"));

    // REQUIRE( string_score("a1") < string_score("aA"));
    // REQUIRE( string_score("aA") < string_score("Aa"));
    // REQUIRE( string_score("Aa") < string_score("aa"));
}




