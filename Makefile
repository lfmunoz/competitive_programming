


##########################################
# Configuration
##########################################
SRC=src/main/java
RSRC=src/main/resources
TARGET=target/classes


.PHONY: default

default:
	@echo "10038 Jolly Jumper"




10038: 
	--mkdir -p target/classes
	@echo "Runnning UVA10038"
	javac $(SRC)/UVa10038.java $(SRC)/UVaBase.java -d $(TARGET)
	java -cp $(TARGET) Main < $(RSRC)/uva10038_in.txt | diff -s -y $(RSRC)/uva10038_out.txt -
    





