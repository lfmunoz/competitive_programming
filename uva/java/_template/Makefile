

.PHONY: uva

default: MainApp.class
	java MainApp

MainApp.class: MainApp.java
	javac MainApp.java
	# ./main input.txt | diff -s -y output.txt -

uva: MainApp.class
	javac MainApp.java
	java MainApp |  diff -s -y outputB.txt -

clean:
	rm MainApp.class