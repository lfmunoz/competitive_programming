
#include "../../../_lib/cpp/catch.hpp"
#include "main.cpp"



TEST_CASE( "Point next", "[uva]" ) {
    Point aPoint(0,0);
    REQUIRE( aPoint.x == 0);
    REQUIRE( aPoint.y == 0);
    aPoint = Point::next(aPoint);
    REQUIRE( aPoint.x == 0);
    REQUIRE( aPoint.y == 1);
    aPoint = Point::next(aPoint);
    REQUIRE( aPoint.x == 0);
    REQUIRE( aPoint.y == 2);
    aPoint = Point::next(aPoint);
    REQUIRE( aPoint.x == 0);
    REQUIRE( aPoint.y == 3);
    aPoint = Point::next(aPoint);
    REQUIRE( aPoint.x == 0);
    REQUIRE( aPoint.y == 4);
    aPoint = Point::next(aPoint);
    REQUIRE( aPoint.x == 1);
    REQUIRE( aPoint.y == 0);
    aPoint = Point::next(aPoint);
    REQUIRE( aPoint.x == 1);
    REQUIRE( aPoint.y == 1);
}


TEST_CASE( "Point nextOnRow", "[uva]" ) {
    Point aPoint(3,0);
    REQUIRE( aPoint.x == 3);
    aPoint = Point::nextOnRow(aPoint);
    REQUIRE( aPoint.x == 4);
    aPoint = Point::nextOnRow(aPoint);
    REQUIRE( aPoint.x == 0);
}

TEST_CASE( "Point nextOnCol", "[uva]" ) {
    Point aPoint(0,3);
    REQUIRE( aPoint.y == 3);
    aPoint = Point::nextOnCol(aPoint);
    REQUIRE( aPoint.y == 4);
    aPoint = Point::nextOnCol(aPoint);
    REQUIRE( aPoint.y == 0);
}

TEST_CASE( "Point stdout_encoded", "[uva]" ) {
    // same row
    Point pointA(0,3);
    Point pointB(0,4);
    encoded(pointA, pointB);
    REQUIRE( pointA.x == 0);
    REQUIRE( pointA.y == 4);
    REQUIRE( pointB.x == 0);
    REQUIRE( pointB.y == 0);
    // same col
    pointA = Point(1, 0);
    pointB = Point(2, 0);
    encoded(pointA, pointB);
    REQUIRE( pointA.x == 2);
    REQUIRE( pointA.y == 0);
    REQUIRE( pointB.x == 3);
    REQUIRE( pointB.y == 0);
    // else
    pointA = Point(0, 0);
    pointB = Point(2, 2);
    encoded(pointA, pointB);
    REQUIRE( pointA.x == 0);
    REQUIRE( pointA.y == 2);
    REQUIRE( pointB.x == 2);
    REQUIRE( pointB.y == 0);

    pointA = Point(0, 2);
    pointB = Point(2, 0);
    encoded(pointA, pointB);
    REQUIRE( pointA.x == 0);
    REQUIRE( pointA.y == 0);
    REQUIRE( pointB.x == 2);
    REQUIRE( pointB.y == 2);

}

