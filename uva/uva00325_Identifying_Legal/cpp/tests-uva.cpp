
#include "../../../_lib/cpp/catch.hpp"
#include "main.cpp"



TEST_CASE( "split ", "[uva]" ) {
    string input = "one two three"; 
    REQUIRE( split(input) == std::vector<string>{"one", "two", "three"});
}


