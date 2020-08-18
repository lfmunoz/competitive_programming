

.PHONY: default 

default: main.elf
	./main.elf < input.txt

main.elf: main.cpp
	g++ -std=c++11 main.cpp -o main.elf
	# ./main input.txt | diff -s -y output.txt -

uva: main.elf
	g++ -D PROD -std=c++11 -O2 -Wall main.cpp -o main.elf
	./main.elf < input.txt |  diff -s -y output.txt -

clean: 
	rm main.elf