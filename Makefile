##########################################
# Configuration
##########################################
SRC=src/main/java
RSRC=src/main/resources
TARGET=target/classes



################################################################################
# Performance Testing
################################################################################
perf:
	./gradlew jmh

########################################################
.PHONY: default count

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
	@echo " 10226 - Hardwood Species - [Done]"
	@echo " 11286 - Conformity - [Done]"
	@echo "---- Java TreeSet ----"
	@echo " 00978 - Lemmings Battle (use multiset) - [DONE]"
	@echo " 11136 - Hoax or what (use multiset) - [DONE]"
	@echo " 11849 - CD (set or hashing) -[DONE]"
	@echo "---- Java PriorityQueue ----"
	@echo " 01203 - Argus - [DONE]"
	@echo " 10954 - Add all - [DONE]"
	@echo " 11995 - I can Guess...[RTE]"
	@echo " "
	@echo "---- Graph Data Structures ----"
	@echo " 00599 - The Forrest for the Trees [DONE]"
	@echo " 10895 - Matrix Tranpose [DONE]"
	@echo " 11991 - Easy Problem from...[DONE]"
	@echo "---- Union-Find Disjint Sets ----"
	@echo " 00793 - Network Connections* [DONE]"
	@echo " 10507 - Waking up brain* [DONE]"
	@echo " 11503 - Virtual Friends* [DONE]"
	@echo "---- Tree-related Data Structures ----"
	@echo " 11235 - Frequent Values* (Sparse Table)[DONE] "
	@echo " 11402 - Ahoy, Pirates (SegmentTree) [SKIP]"
	@echo " "
	@echo "---- Complete Search ----"
	@echo "---- Iterative (One Loop, Linear Scan) ----"
	@echo " 00927 - Integer Sequence From ... [DONE]"
	@echo " 01237 - Expert Enough - [DONE]"
	@echo " 10976 - Fractions Again? -[ DONE]"
	@echo "---- Iterative (Two Nested Loops) ----"
	@echo " 01260 - Sales * [DONE]"
	@echo " 10487 - Closest Sums * [DONE]"
	@echo " 11242 - Tour de France *[DONE]"
	@echo "---- Iterative (Three or More Nested Loops, Easier) ----"
	@echo " 00441 - Lotto *[DONE]"
	@echo " 00725 - Dart-a-Mania*[DONE]"
	@echo " 10102 - The Path in the ...*[DONE]"
	@echo "---- Iterative (Three-or-More Nested Loops, Harder) ----"
	@echo " 10660 - Citizen attention ... * [DONE]"
	@echo " 11565 - Simple Equations *[DONE]"
	@echo "---- Fancy Techniques ----"
	@echo " 11553 - Grid Game *"
	@echo "---- Backtracking (Easy) ----"
	@echo " 00624 - CD * "
	@echo " 10576 - Y2K Accounting Bug"
	@echo " 11085 - Back to the 8-Queens"

count:
	ls -l src/main/resources/*_out.txt | wc -l

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

#######################################################
11286:
	--mkdir -p target/classes
	@echo "Runnning UVA11286"
	javac $(SRC)/UVa11286.java -d $(TARGET)
	java -cp $(TARGET) uva11286.Main < $(RSRC)/uva11286_in.txt | diff -s -y $(RSRC)/uva11286_out.txt -

#######################################################
00978:
	--mkdir -p target/classes
	@echo "Runnning UVA00978"
	javac $(SRC)/UVa00978.java -d $(TARGET)
	java -cp $(TARGET) uva00978.Main < $(RSRC)/uva00978_in.txt | diff -s -y $(RSRC)/uva00978_out.txt -

#######################################################
11136:
	--mkdir -p target/classes
	@echo "Runnning UVA11136"
	javac $(SRC)/UVa11136.java -d $(TARGET)
	java -cp $(TARGET) uva11136.Main < $(RSRC)/uva11136_in.txt | diff -s -y $(RSRC)/uva11136_out.txt -

#######################################################
11849:
	--mkdir -p target/classes
	@echo "Runnning UVA11849"
	javac $(SRC)/UVa11849.java -d $(TARGET)
	java -cp $(TARGET) uva11849.Main < $(RSRC)/uva11849_in.txt | diff -s -y $(RSRC)/uva11849_out.txt -

#######################################################
01203:
	--mkdir -p target/classes
	@echo "Runnning UVA01203"
	javac $(SRC)/UVa01203.java -d $(TARGET)
	java -cp $(TARGET) uva01203.Main < $(RSRC)/uva01203_in.txt | diff -s -y $(RSRC)/uva01203_out.txt -

#######################################################
10954:
	--mkdir -p target/classes
	@echo "Runnning UVA10954"
	javac $(SRC)/UVa10954.java -d $(TARGET)
	java -cp $(TARGET) uva10954.Main < $(RSRC)/uva10954_in.txt | diff -s -y $(RSRC)/uva10954_out.txt -

#######################################################
11995:
	--mkdir -p target/classes
	@echo "Runnning UVA11995"
	javac $(SRC)/UVa11995.java -d $(TARGET)
	java -cp $(TARGET) uva11995.Main < $(RSRC)/uva11995_in.txt | diff -s -y $(RSRC)/uva11995_out.txt -

#######################################################
00599:
	--mkdir -p target/classes
	@echo "Runnning UVA00599"
	javac $(SRC)/UVa00599.java -d $(TARGET)
	java -cp $(TARGET) uva00599.Main < $(RSRC)/uva00599_in.txt | diff -s -y $(RSRC)/uva00599_out.txt -

#######################################################
10895:
	--mkdir -p target/classes
	@echo "Runnning UVA10895"
	javac $(SRC)/UVa10895.java -d $(TARGET)
	java -cp $(TARGET) uva10895.Main < $(RSRC)/uva10895_in.txt | diff -s -y $(RSRC)/uva10895_out.txt -

#######################################################
11991:
	--mkdir -p target/classes
	@echo "Runnning UVA11991"
	javac $(SRC)/UVa11991.java -d $(TARGET)
	java -cp $(TARGET) uva11991.Main < $(RSRC)/uva11991_in.txt | diff -s -y $(RSRC)/uva11991_out.txt -

#######################################################
00793:
	--mkdir -p target/classes
	@echo "Runnning UVA00793"
	javac $(SRC)/UVa00793.java -d $(TARGET)
	java -cp $(TARGET) uva00793.Main < $(RSRC)/uva00793_in.txt | diff -s -y $(RSRC)/uva00793_out.txt -

#######################################################
10507:
	--mkdir -p target/classes
	@echo "Runnning UVA10507"
	javac $(SRC)/UVa10507.java -d $(TARGET)
	java -cp $(TARGET) uva10507.Main < $(RSRC)/uva10507_in.txt | diff -s -y $(RSRC)/uva10507_out.txt -

#######################################################
11503:
	--mkdir -p target/classes
	@echo "Runnning UVA11503"
	javac $(SRC)/UVa11503.java -d $(TARGET)
	java -cp $(TARGET) uva11503.Main < $(RSRC)/uva11503_in.txt | diff -s -y $(RSRC)/uva11503_out.txt -

#######################################################
11235:
	--mkdir -p target/classes
	@echo "Runnning UVA11235"
	javac $(SRC)/UVa11235.java -d $(TARGET)
	java -cp $(TARGET) uva11235.Main < $(RSRC)/uva11235_in.txt | diff -s -y $(RSRC)/uva11235_out.txt -

#######################################################
11402:
	--mkdir -p target/classes
	@echo "Runnning UVA11402"
	javac $(SRC)/UVa11402.java -d $(TARGET)
	java -cp $(TARGET) uva11402.Main < $(RSRC)/uva11402_in.txt | diff -s -y $(RSRC)/uva11402_out.txt -

#######################################################
00927:
	--mkdir -p target/classes
	@echo "Runnning UVA00927"
	javac $(SRC)/UVa00927.java -d $(TARGET)
	java -cp $(TARGET) uva00927.Main < $(RSRC)/uva00927_in.txt | diff -s -y $(RSRC)/uva00927_out.txt -

#######################################################
01237:
	--mkdir -p target/classes
	@echo "Runnning UVA01237"
	javac $(SRC)/UVa01237.java -d $(TARGET)
	java -cp $(TARGET) uva01237.Main < $(RSRC)/uva01237_in.txt | diff -s -y $(RSRC)/uva01237_out.txt -

#######################################################
10976:
	--mkdir -p target/classes
	@echo "Runnning UVA10976"
	javac $(SRC)/UVa10976.java -d $(TARGET)
	java -cp $(TARGET) uva10976.Main < $(RSRC)/uva10976_in.txt | diff -s -y $(RSRC)/uva10976_out.txt -

#######################################################
01260:
	--mkdir -p target/classes
	@echo "Runnning UVA01260"
	javac $(SRC)/UVa01260.java -d $(TARGET)
	java -cp $(TARGET) uva01260.Main < $(RSRC)/uva01260_in.txt | diff -s -y $(RSRC)/uva01260_out.txt -

#######################################################
10487:
	--mkdir -p target/classes
	@echo "Runnning UVA10487"
	javac $(SRC)/UVa10487.java -d $(TARGET)
	java -cp $(TARGET) uva10487.Main < $(RSRC)/uva10487_in.txt | diff -s -y $(RSRC)/uva10487_out.txt -

#######################################################
11242:
	--mkdir -p target/classes
	@echo "Runnning UVA11242"
	javac $(SRC)/UVa11242.java -d $(TARGET)
	java -cp $(TARGET) uva11242.Main < $(RSRC)/uva11242_in.txt | diff -s -y $(RSRC)/uva11242_out.txt -

#######################################################
00441:
	--mkdir -p target/classes
	@echo "Runnning UVA00441"
	javac $(SRC)/UVa00441.java -d $(TARGET)
	java -cp $(TARGET) uva00441.Main < $(RSRC)/uva00441_in.txt | diff -s -y $(RSRC)/uva00441_out.txt -

#######################################################
00735:
	--mkdir -p target/classes
	@echo "Runnning UVA00735"
	javac $(SRC)/UVa00735.java -d $(TARGET)
	java -cp $(TARGET) uva00735.Main < $(RSRC)/uva00735_in.txt | diff -s -y $(RSRC)/uva00735_out.txt -

#######################################################
10102:
	--mkdir -p target/classes
	@echo "Runnning UVA10102"
	javac $(SRC)/UVa10102.java -d $(TARGET)
	java -cp $(TARGET) uva10102.Main < $(RSRC)/uva10102_in.txt | diff -s -y $(RSRC)/uva10102_out.txt -

#######################################################
10660:
	--mkdir -p target/classes
	@echo "Runnning UVA10660"
	javac $(SRC)/UVa10660.java -d $(TARGET)
	java -cp $(TARGET) uva10660.Main < $(RSRC)/uva10660_in.txt | diff -s -y $(RSRC)/uva10660_out.txt -

#######################################################
11565:
	--mkdir -p target/classes
	@echo "Runnning UVA11565"
	javac $(SRC)/UVa11565.java -d $(TARGET)
	java -cp $(TARGET) uva11565.Main < $(RSRC)/uva11565_in.txt | diff -s -y $(RSRC)/uva11565_out.txt -

#######################################################
11553:
	--mkdir -p target/classes
	@echo "Runnning UVA11553"
	javac $(SRC)/UVa11553.java -d $(TARGET)
	java -cp $(TARGET) uva11553.Main < $(RSRC)/uva11553_in.txt | diff -s -y $(RSRC)/uva11553_out.txt -

