# 2014097056 SeongHyun Woo
# $0, $#, $HOME, $PATH, and $PS1 are variables that have special meanings, so write a program to output each meaning.

#!/bin/bash

# Check number of arguments
if [ "$#" -ne 0 ]; then         
    echo "Usage error: This program has no arguments"
    exit 1
fi

# Print the meanings
echo "\$0 is the name of the shell script"
echo "\$# is the number of arguments"
echo "\$HOME is the user's home directory"
echo "\$PATH is the search path for executables"
echo "\$PS1 is the primary prompt string"
