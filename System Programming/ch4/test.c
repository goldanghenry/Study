#include <stdio.h>
#include <stdlib.h>

#include <stat.h>



ino_t get_inode(char *fname)
{
    struct stat info;
    if (stat(fname, &info) == -1)
    {
        fprintf(stderr, );
        perror(fname);
        exit(1);
    }
    return info.st_ino;
}