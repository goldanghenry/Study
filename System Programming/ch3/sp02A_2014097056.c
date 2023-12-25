/* sp02A_2014097056 Sung Hyun Woo
 * A program that prints information about a file when a file name is entered on the program's command line.
 * Usage : sp02A_2014097056 file1 ...
 */

#include <stdio.h>
#include <stdlib.h>
#include <sys/stat.h>

void print_file_info(char *filename);	/* function prototype */

int main(int arg_num, char *arg_arr[]) 
{
    if (arg_num < 2) {			/* The first argument is the executable file name */
        fprintf(stderr, "Usage: %s file1 ...\n", arg_arr[0]);	/* print correct usage */
        return 1;
    }
	

    /* outputs information corresponding to the name of the file 
     * entered as an argument through a loop. */
    for (int i = 1; i < arg_num; i++) {
        print_file_info(arg_arr[i]);
    }

    return 0;		/* shutdown normally */
}


void print_file_info(char *filename) 
{
    struct stat temp_stat;	    /* stat structure declaration defined in the <sys/stat.h> header file 
       				       struct stat contains various file properties */

    /* stat() : system call to obtain file information 
       return -1 == call failed                         */
    if (stat(filename, &temp_stat) == -1) {
        perror("call failed stat");
        return;
    }

    /* The path name is the file name */
    printf("pathname: \"%s\"\n", filename);

    /* Check the type of file through the function defined in the <sys/stat.h> header file.
     * S_ISREG : Is it a regular file?
     * S_ISDIR : Is it a directory file?
     * S_ISLNK : Is it a symbolic link?
     */
    if (S_ISREG(temp_stat.st_mode)) {
        printf("type: regular file\n");
    } else if (S_ISDIR(temp_stat.st_mode)) {
        printf("type: directory\n");
    } else if (S_ISLNK(temp_stat.st_mode)) {
        printf("type: symbolic link\n");
    } else {
        printf("type: other file\n");
    }

    printf("mode: %o\n", temp_stat.st_mode & 0777);	/* AND works bitwise to get file permissions */
    printf("inode #: %ld\n", (long)temp_stat.st_ino);	/* i-node number */
    printf("number of links = %ld\n", (long)temp_stat.st_nlink);
    printf("uid: %d\n", temp_stat.st_uid);
    printf("gid = %d\n", temp_stat.st_gid);
    printf("size = %ld\n", (long)temp_stat.st_size);
    printf("preferred I/O block size = %ld\n", (long)temp_stat.st_blksize);
    printf("number of 512-byte blocks = %ld\n", (long)temp_stat.st_blocks);

    printf("-----------------------------------------\n");
}

