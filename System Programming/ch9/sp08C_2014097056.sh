# 2014097056 SeongHyun Woo
# Write a program in a shell script that takes a file name as an argument and outputs whether each argument can be read/written/executed.
#!/bin/bash
# #@ : array of arguments


# Check if the number of arguments is correct
if [ "$#" -eq 0 ]; then
    echo "Usage: $0 <file1> [file2] [file3]..."
    exit 1
fi

# Iterate through each argument (file)
for file in "$@"; do
    # Check if the file exists
    if [ ! -e "$file" ]; then       # ! : not , -e : exist
        echo "Error: $file does not exist."
    else
        echo "filename : $(basename $file)"
        # Check if the file is readable
        if [ -r "$file" ]; then     # -r : readalbe
            echo "able to read"
        else
            echo "unable to read"
        fi

        # Check if the file is writable
        if [ -w "$file" ]; then
            echo "able to write"
        else
            echo "unable to write"
        fi

        # Check if the file is executable
        if [ -x "$file" ]; then
            echo "able to execute"
        else
            echo "unable to execute"
        fi
    fi

    echo ""  # space for files
done
