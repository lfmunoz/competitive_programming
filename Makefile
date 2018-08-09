##########################################
# Configuration
##########################################
SRC=src/main/java
RSRC=src/main/resources
TARGET=target/classes

########################################################
.PHONY: default

default:
	@echo "---- 1D Array Manipulation ----"
	@echo " 10038 Jolly Jumper - [Done]"
	@echo " 11340 Newspaper - [Done]"
	@echo "---- 2D Array Manipulation ----"
	@echo " 10855 Rotated squares - [Done]"
	@echo " 10920 Spiral Tap - [Done]"
	@echo " 11581 Grid Successors --- [Done]"
	@echo "---- Java Collections ##"
	@echo " 00146 ID Codes - [Done]"
	@echo " 10107 What is the Median - [Done]"
	@echo " 10258 Contest Scoreboard - [Done]"
	@echo "---- Bit Manipulation ---"
	@echo " 11926 Multitasking - [Done]"
	@echo " 11933 Splitting Numbers - [Done]"
	@echo "---- Java LinkedList ----"
	@echo " 11988 Broken Keyboard - [Done]"
	@echo "---- Java Stack ----"
	@echo " 00514 Rails - [Done]"
	@echo " 00732 Anagram by Stack [Done w/ TLE]"
	@echo "---- Java Queue and Deque ----"
	@echo " 10172 The Lonesome Cargo [Skipped]"
	@echo " 10901 Ferry Loading III - [Done]"
	@echo " 11034 Ferry Loading IV - [Done]"
	@echo " "
	@echo "---- Java TreeMap ----"
	@echo " 10226 - Hardwood Species"
	@echo " 10226 - Conformity"
	@echo "---- Java TreeSet ----"
	@echo " 00978 - Lemmings Battle (use multiset)"
	@echo " 11136 - Hoax or what (use multiset)"
	@echo " 11849 - CD (set or hashing)"
	@echo "---- Java PriorityQueue ----"
	@echo " 01203 - Argus "
	@echo " 10954 - Add all"
	@echo " 11995 - I can Guess..."
	@echo " "
	@echo "---- Graph Data Structures ----"
	@echo " 00599 - The Forrest for the Trees"
	@echo " 10895 - Matrix Tranpose"
	@echo " 11991 - Easy Problem from..."
	@echo "---- Union-Find Disjint Sets ----"
	@echo "---- Tree-related Data Structures ----"
	@echo "---- Tree-related Data Structures ----"
	@echo " "
	@echo "---- Iterative (One Loop, Linear Scan) ----"
	@echo "---- Iterative (Two Nested Loops) ----"
	@echo "---- Iterative (Three or More Nested Loops, Easier) ----"
	@echo "---- Iterative (Three-or-More Nested Loops, Harder) ----"

########################################################
10038: 
	--mkdir -p target/classes
	@echo "Runnning UVA10038"
	javac $(SRC)/UVa10038.java -d $(TARGET)
	java -cp $(TARGET) Main < $(RSRC)/uva10038_in.txt | diff -s -y $(RSRC)/uva10038_out.txt -

########################################################
11340: 
	--mkdir -p target/classes
	@echo "Runnning UVA11340"
	javac $(SRC)/UVa11340.java -d $(TARGET)
	java -cp $(TARGET) uva11340.Main < $(RSRC)/uva11340_in.txt | diff -s -y $(RSRC)/uva11340_out.txt -

#######################################################
10855: 
	--mkdir -p target/classes
	@echo "Runnning UVA10855"
	javac $(SRC)/UVa10855.java  -d $(TARGET)
	java -cp $(TARGET) uva10855.Main < $(RSRC)/uva10855_in.txt | diff -s -y $(RSRC)/uva10855_out.txt -

#######################################################
10920:
	--mkdir -p target/classes
	@echo "Runnning UVA10920"
	javac $(SRC)/UVa10920.java -d $(TARGET)
	java -cp $(TARGET) uva10920.Main < $(RSRC)/uva10920_in.txt | diff -s -y $(RSRC)/uva10920_out.txt -

#######################################################
11581:
	--mkdir -p target/classes
	@echo "Runnning UVA11581"
	javac $(SRC)/UVa11581.java -d $(TARGET)
	java -cp $(TARGET) uva11581.Main < $(RSRC)/uva11581_in.txt | diff -s -y $(RSRC)/uva11581_out.txt -

#######################################################
00146:
	--mkdir -p target/classes
	@echo "Runnning UVA00146"
	javac $(SRC)/UVa00146.java -d $(TARGET)
	java -cp $(TARGET) uva00146.Main < $(RSRC)/uva00146_in.txt | diff -s -y $(RSRC)/uva00146_out.txt -

#######################################################
10107:
	--mkdir -p target/classes
	@echo "Runnning UVA10107"
	javac $(SRC)/UVa10107.java -d $(TARGET)
	java -cp $(TARGET) uva10107.Main < $(RSRC)/uva10107_in.txt | diff -s -y $(RSRC)/uva10107_out.txt -

#######################################################
10258:
	--mkdir -p target/classes
	@echo "Runnning UVA10258"
	javac $(SRC)/UVa10258.java -d $(TARGET)
	java -cp $(TARGET) uva10258.Main < $(RSRC)/uva10258_in.txt | diff -s -y $(RSRC)/uva10258_out.txt -

#######################################################
11926:
	--mkdir -p target/classes
	@echo "Runnning UVA11926"
	javac $(SRC)/UVa11926.java -d $(TARGET)
	java -cp $(TARGET) uva11926.Main < $(RSRC)/uva11926_in.txt | diff -s -y $(RSRC)/uva11926_out.txt -

#######################################################
11933:
	--mkdir -p target/classes
	@echo "Runnning UVA11933"
	javac $(SRC)/UVa11933.java -d $(TARGET)
	java -cp $(TARGET) uva11933.Main < $(RSRC)/uva11933_in.txt | diff -s -y $(RSRC)/uva11933_out.txt -

#######################################################
11988:
	--mkdir -p target/classes
	@echo "Runnning UVA11988"
	javac $(SRC)/UVa11988.java -d $(TARGET)
	java -cp $(TARGET) uva11988.Main < $(RSRC)/uva11988_in.txt | diff -s -y $(RSRC)/uva11988_out.txt -

#######################################################
00514:
	--mkdir -p target/classes
	@echo "Runnning UVA00514"
	javac $(SRC)/UVa00514.java -d $(TARGET)
	java -cp $(TARGET) uva00514.Main < $(RSRC)/uva00514_in.txt | diff -s -y $(RSRC)/uva00514_out.txt -

#######################################################
00732:
	--mkdir -p target/classes
	@echo "Runnning UVA00732"
	javac $(SRC)/UVa00732.java -d $(TARGET)
	java -cp $(TARGET) uva00732.Main < $(RSRC)/uva00732_in.txt | diff -s -y $(RSRC)/uva00732_out.txt -

#######################################################
10172:
	--mkdir -p target/classes
	@echo "Runnning UVA10172"
	javac $(SRC)/UVa10172.java -d $(TARGET)
	java -cp $(TARGET) uva10172.Main < $(RSRC)/uva10172_in.txt | diff -s -y $(RSRC)/uva10172_out.txt -

#######################################################
10901:
	--mkdir -p target/classes
	@echo "Runnning UVA10901"
	javac $(SRC)/UVa10901.java -d $(TARGET)
	java -cp $(TARGET) uva10901.Main < $(RSRC)/uva10901_in.txt | diff -s -y $(RSRC)/uva10901_out.txt -

#######################################################
11034:
	--mkdir -p target/classes
	@echo "Runnning UVA11034"
	javac $(SRC)/UVa11034.java -d $(TARGET)
	java -cp $(TARGET) uva11034.Main < $(RSRC)/uva11034_in.txt | diff -s -y $(RSRC)/uva11034_out.txt -

#######################################################
10226:
	--mkdir -p target/classes
	@echo "Runnning UVA10226"
	javac $(SRC)/UVa10226.java -d $(TARGET)
	java -cp $(TARGET) uva10226.Main < $(RSRC)/uva10226_in.txt | diff -s -y $(RSRC)/uva10226_out.txt -

