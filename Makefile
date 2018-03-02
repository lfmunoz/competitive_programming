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
	@echo " 11581 Grid Successors - [Done]"
	@echo "---- Java Collections ##"
	@echo " 00146 ID Codes - [Done]"
	@echo " 10107 What is the Median - [Done]"
	@echo " 10258 Contest Scoreboard"
	@echo "---- Bit Manipulation ##"
	@echo " 11926 Multitasking"
	@echo " 11933 Splitting Numbers"
	@echo "---- Java LinkedList ----"
	@echo " 11988 Broken Keyboard"
	@echo "---- Java Stack ### "
	@echo " 00514 Rails"
	@echo " 00732 Anagram by Stack"
	@echo "---- Java Queue and Deque ----"
	@echo " 10172 The Lonesome Cargo"
	@echo " 10901 Ferry Loading III"
	@echo " 11034 Ferry Loading IV"
	@echo "---- Java TreeMap ----"
	@echo "---- Java TreeSet ----"
	@echo "---- Java PriorityQueue ----"
	@echo "---- Graph Data Structures ----"
	@echo "---- Union-Find Disjint Sets ----"
	@echo "---- Tree-related Data Structures ----"
	@echo "---- Tree-related Data Structures ----"
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

