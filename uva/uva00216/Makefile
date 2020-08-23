

.PHONY: default uvaB

default: main.elf
	./main.elf

main.elf: main.cpp
	g++ -std=c++11 main.cpp -o main.elf
	# ./main input.txt | diff -s -y output.txt -

uvaB: 
	g++ -D PROD -std=c++11 -O2 -Wall main.cpp -o main.elf
	./main.elf < inputB.txt |   diff -s -y outputB.txt -

clean: 
	rm main.elf

