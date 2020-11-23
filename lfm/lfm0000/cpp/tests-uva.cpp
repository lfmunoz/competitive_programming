
#include "../../../_lib/cpp/catch.hpp"
#include "main.cpp"



TEST_CASE( "find_number_half", "[lfm]" ) {
    vector<unsigned int> numbers = {1};
    REQUIRE( find_number_half(numbers, 1, 0, 0) == 0);

    numbers = {1,2};
    REQUIRE( find_number_half(numbers, 1, 0, 1) == 0);
    REQUIRE( find_number_half(numbers, 2, 0, 1) == 1);

    numbers = {1,2,3};
    REQUIRE( find_number_half(numbers, 1, 0, 2) == 0);
    REQUIRE( find_number_half(numbers, 2, 0, 2) == 1);
    REQUIRE( find_number_half(numbers, 3, 0, 2) == 2);

    numbers = {1,2,3, 4};
    REQUIRE( find_number_half(numbers, 1, 0, 3) == 0);
    REQUIRE( find_number_half(numbers, 2, 0, 3) == 1);
    REQUIRE( find_number_half(numbers, 3, 0, 3) == 2);
    REQUIRE( find_number_half(numbers, 4, 0, 3) == 3);

    numbers = {1,2,3,4,5};
    REQUIRE( find_number_half(numbers, 1, 0, 4) == 0);
    REQUIRE( find_number_half(numbers, 2, 0, 4) == 1);
    REQUIRE( find_number_half(numbers, 3, 0, 4) == 2);
    REQUIRE( find_number_half(numbers, 4, 0, 4) == 3);
    REQUIRE( find_number_half(numbers, 5, 0, 4) == 4);



}


