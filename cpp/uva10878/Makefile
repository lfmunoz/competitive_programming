
# ________________________________________________________________________________
# GLOBAL
# ________________________________________________________________________________
.PHONY: clean

# ________________________________________________________________________________
#DEVELOPMENT 
# ________________________________________________________________________________
default: main.cpp main.elf
	./main.elf < input.txt 

watch: main.cpp main.elf
	while true; do inotifywait -e close_write main.cpp; make; done

main.elf: main.cpp 
	g++ -std=c++11 main.cpp -o main.elf

# ________________________________________________________________________________
# PRODUCTION
# ________________________________________________________________________________
uva: main.cpp
	g++ -std=c++11 -O2 -Wall main.cpp -o main.elf
	./main.elf <input.txt |  diff -s -y output.txt -

# ________________________________________________________________________________
# TEST
# ________________________________________________________________________________
test: tests-uva.elf
	./tests-uva.elf
	# ./tests-uva.elf -s

tests-uva.elf: ../_lib/tests-main.o tests-uva.cpp
	g++ -D IS_TEST=1 -std=c++11 -Wall tests-main.o tests-uva.cpp -o tests-uva.elf

../_lib/tests-main.o: ../_lib/tests-main.cpp
	g++ ../_lib/tests-main.cpp -c


# ________________________________________________________________________________
#CLEAN
# ________________________________________________________________________________
clean: 
	-rm -f tests-main.elf
	-rm -f main.elf

