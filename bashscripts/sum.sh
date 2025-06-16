#! /bin/bash

sum(){
	return $(( $1 + $2 ))
	}
	
sum 4 5
echo $?

