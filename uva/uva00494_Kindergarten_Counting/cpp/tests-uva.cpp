
#include "../../../_lib/cpp/catch.hpp"
#include "main.cpp"


TEST_CASE( "split ", "[uva]" ) {
    string input = "one two three"; 
    REQUIRE( split(input) == std::vector<string>{"one", "two", "three"});
}


TEST_CASE( "countMatchInRegex ", "[uva]" ) {
    string input = "one two three"; 
    REQUIRE( countMatchInRegex(input, "\\w+") == 3);
    input = "She   \\\\outl///ived disposed. ";
    REQUIRE( countMatchInRegex(input, "\\w+") == 4);
}


