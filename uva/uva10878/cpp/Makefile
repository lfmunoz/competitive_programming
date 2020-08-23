
# ________________________________________________________________________________
# GLOBAL
# ________________________________________________________________________________
.PHONY: clean

# ________________________________________________________________________________
#DEVELOPMENT 
# ________________________________________________________________________________
default: main.elf
	./main.elf < ../input.txt 

watch: main.cpp main.elf
	while true; do inotifywait -e close_write main.cpp; make; done


main.elf: main.cpp 
	g++ -std=c++11 main.cpp -o main.elf

# ________________________________________________________________________________
# PRODUCTION
# ________________________________________________________________________________
uva: main.cpp
	g++ -std=c++11 -O2 -Wall main.cpp -o main.elf
	./main.elf < ../input.txt |  diff -s -y ../output.txt -

# ________________________________________________________________________________
# TEST
# ________________________________________________________________________________
LIB_DIR=../../../_lib/cpp

test: tests-uva.elf
	./tests-uva.elf -s

tests-uva.elf: ${LIB_DIR}/tests-main.o tests-uva.cpp main.cpp
	g++ -D IS_TEST=1 -std=c++11 -Wall ${LIB_DIR}/tests-main.o tests-uva.cpp -o tests-uva.elf

${LIB_DIR}/tests-main.o: ${LIB_DIR}/tests-main.cpp
	g++ ${LIB_DIR}/tests-main.cpp -c -o ${LIB_DIR}/tests-main.o


# ________________________________________________________________________________
#CLEAN
# ________________________________________________________________________________
clean: 
	-rm -f *.elf
	-rm -f *.o

