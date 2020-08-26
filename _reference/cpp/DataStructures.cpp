
// ________________________________________________________________________________
// MAP
// ________________________________________________________________________________
// https ://thispointer.com/stdmap-tutorial-part-1-usage-detail-with-examples/
// http ://cs.brown.edu/courses/cs123/docs/java_to_cpp.shtml
// https : //linuxconfig.org/c-understanding-pointers

// ________________________________________________________________________________
//  INCLUDE
// ________________________________________________________________________________
#include <iostream>
#include <map>
#include <string>
#include <iterator>

using namespace std;

// ________________________________________________________________________________
// VECTOR
// ________________________________________________________________________________

// ________________________________________________________________________________
// MAP
// ________________________________________________________________________________

int map()
{

    // DECLARE
    std::map<std::string, int> mapOfWords;

    // INSERT
    // insert will not replace already added key
    mapOfWords.insert(std::make_pair("earth", 1));
    mapOfWords.insert(std::make_pair("moon", 2));

    // We can also insert data in std::map using operator []
    // NOTE: Will replace the value of already added key.
     mapOfWords["sun"] = 3;

    //ITERATE
    std::map<std::string, int>::iterator it = mapOfWords.begin();
    while(it != mapOfWords.end()) {
        std::cout<< it->first <<" :: "<< it->second << std::endl;
        it++;
    }

    // Check if insertion is successful or not
    if(mapOfWords.insert(std::make_pair("earth", 1)).second == false) {
        std::cout<<"Element with key 'earth' not inserted because already existed"<<std::endl;
    }

    // Searching element in std::map by key.
    if(mapOfWords.find("sun") != mapOfWords.end()) {
        std::cout<<"word 'sun' found"<<std::endl;
    }


    // Erasing By Key
    mapOfWords.erase("earth");
}

int getIfPresent(std::map<std::string, int> & mapOfWords, string key) {
    auto it = mapOfWords.find(key);
    if(it != mapOfWords.end()) {
        return  it->second;
    }
    return -1; // NOT SURE WHAT TO RETURN, NULL is not a valid value for an integer
}

std::map<std::string, int>::iterator serachByValue(std::map<std::string, int> & mapOfWords, int val)
{
    // Iterate through all elements in std::map and search for the passed element
    std::map<std::string, int>::iterator it = mapOfWords.begin();
    while(it != mapOfWords.end())
    {
        if(it->second == val)
        return it;
        it++;
    }
}