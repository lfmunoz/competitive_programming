
#include "../../../_lib/cpp/catch.hpp"
#include "main.cpp"



TEST_CASE( "findElse works", "[uva]" ) {
    vector<string> stackArr;
    stackArr.push_back("IF");
    stackArr.push_back("ELSE");
    stackArr.push_back("END_IF");
    REQUIRE( findElse(stackArr,0) == 1);
    stackArr.clear();
    stackArr.push_back("IF");
    stackArr.push_back("IF");
    stackArr.push_back("ELSE");
    stackArr.push_back("END_IF");
    stackArr.push_back("ELSE");
    stackArr.push_back("END_IF");
    REQUIRE( findElse(stackArr, 0) == 4);
    stackArr.clear();
}

