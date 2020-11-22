
#include "../../../_lib/cpp/catch.hpp"
#include "main.cpp"



TEST_CASE( "clean string", "[uva]" ) {
    string input = "| oooo.ooo|"; 
    REQUIRE( clean_string(input).compare("ooooooo") == 0);
    input = "|    o.o o|"; 
    REQUIRE( clean_string(input).compare("   oo o") == 0);
}



TEST_CASE( "decode string to integer", "[uva]" ) {
    string aLine = "| oooo.ooo|"; 
    REQUIRE( string_to_int(aLine) == 127);
    aLine = "|     .  o|"; 
    REQUIRE( string_to_int(aLine) == 1);
    aLine = "|     . o |"; 
    REQUIRE( string_to_int(aLine) == 2);
    aLine = "|     .o  |"; 
    REQUIRE( string_to_int(aLine) == 4);

}

