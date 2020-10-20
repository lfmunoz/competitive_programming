
#include "../../../_lib/cpp/catch.hpp"
#include "main.cpp"



TEST_CASE( "parse_line", "[uva]" ) {

    string problem = "1+2=3";
    HwProblem hw = parse_line(problem);
    REQUIRE( hw.isCorrect() == true);

    problem = "1+2=30";
    hw = parse_line(problem);
    REQUIRE( hw.isCorrect() == false);

    problem = "10-2=8";
    hw = parse_line(problem);
    REQUIRE( hw.isCorrect() == true);

    problem = "100-20=79";
    hw = parse_line(problem);
    REQUIRE( hw.isCorrect() == false);

    problem = "100-20=?";
    hw = parse_line(problem);
    REQUIRE( hw.isCorrect() == false);
}
