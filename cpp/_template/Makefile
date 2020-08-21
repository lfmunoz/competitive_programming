

.PHONY: default 

default: main.elf
	./main.elf < input.txt 

watch: main.elf
	while true; do inotifywait -e close_write main.cpp; make; done

uva: main.elf
	g++ -D PROD -std=c++11 -O2 -Wall main.cpp -o main.elf
	./main.elf <input.txt |  diff -s -y output.txt -

main.elf: main.cpp
	g++ -std=c++11 main.cpp -o main.elf


clean: 
	rm main.elf