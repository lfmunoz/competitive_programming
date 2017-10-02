##########################################
# Configuration
##########################################
SRC=src/main/java
RSRC=src/main/resources
TARGET=target/classes


########################################################
.PHONY: default

default:
	@echo "10038 Jolly Jumper"
	@echo "11340 Newspaper"
	@echo "10855 Rotated squares"
	@echo "10920 Spiral Tap"
	@echo "11581 Grid Successors"
	@echo "00146 ID Codes"
	@echo "10107 What is the Median"
	@echo "10258 Contest Scoreboard"

########################################################
10038: 
	--mkdir -p target/classes
	@echo "Runnning UVA10038"
	javac $(SRC)/UVa10038.java $(SRC)/UVaBase.java -d $(TARGET)
	java -cp $(TARGET) Main < $(RSRC)/uva10038_in.txt | diff -s -y $(RSRC)/uva10038_out.txt -
    
########################################################
11340: 
	--mkdir -p target/classes
	@echo "Runnning UVA11340"
	javac $(SRC)/UVa11340.java $(SRC)/UVaBase.java -d $(TARGET)
	java -cp $(TARGET) uva11340.Main < $(RSRC)/uva11340_in.txt | diff -s -y $(RSRC)/uva11340_out.txt -
    
#######################################################

10855: 
	--mkdir -p target/classes
	@echo "Runnning UVA10855"
	javac $(SRC)/UVa10855.java $(SRC)/UVaBase.java -d $(TARGET)
	java -cp $(TARGET) uva10855.Main < $(RSRC)/uva10855_in.txt | diff -s -y $(RSRC)/uva10855_out.txt -

