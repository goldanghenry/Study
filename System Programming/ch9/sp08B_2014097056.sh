# 2014097056 SeongHyun Woo
# Write a shell script that outputs arguments when executed.
#!/bin/bash
# $0 : script
# basename : file name
# $# : num of arguments
# shift : next argument


# Check number of arguments
if [ "$#" -eq 0 ]; then # equals
    echo "Usage error: [arg1] [arg2]..."
    exit 1
fi

# Print
echo "script name: $(basename $0)"  # $0
echo "# of arguments: $#"
for((i=1; i<=$#+1; i++)); do 
    echo "argument $i: \"$1\""
    shift       # next arg
done