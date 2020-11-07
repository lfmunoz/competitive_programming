
#include "../../../_lib/cpp/catch.hpp"
#include "main.cpp"



TEST_CASE( "check_missing_or_extra_letter", "[uva]" ) {
    REQUIRE( check_missing_or_extra_letter("a", "su") == false);
    // extra letter
    REQUIRE( check_missing_or_extra_letter("word", "wword") == true);
    REQUIRE( check_missing_or_extra_letter("wword", "word") == true);
    REQUIRE( check_missing_or_extra_letter("wwword", "word") == false);
    REQUIRE( check_missing_or_extra_letter("word", "worddd") == false);
    REQUIRE( check_missing_or_extra_letter("will", "willl") == true);
    // same size
    REQUIRE( check_missing_or_extra_letter("asdb", "aaab") == false);
    // missing letter
    REQUIRE( check_missing_or_extra_letter("wrd", "word") == true);
    REQUIRE( check_missing_or_extra_letter("word", "wrd") == true);
}


TEST_CASE( "check_order_is_wrong", "[uva]" ) {
    REQUIRE( check_order_is_wrong("is", "su") == false);
    REQUIRE( check_order_is_wrong("wr", "rw") == true);
    REQUIRE( check_order_is_wrong("house", "housea") == false);
    REQUIRE( check_order_is_wrong("house", "houes") == true);
    REQUIRE( check_order_is_wrong("housese", "houeses") == false);
}


TEST_CASE( "check_one_letter_wrong", "[uva]" ) {
    REQUIRE( check_one_letter_wrong("is", "as") == true);
    REQUIRE( check_one_letter_wrong("apple", "jpple") == true);
    REQUIRE( check_one_letter_wrong("house", "houses") == false);
    REQUIRE( check_one_letter_wrong("apple", "jpplo") == false);
    REQUIRE( check_one_letter_wrong("killer", "k1ller") == true);
}


