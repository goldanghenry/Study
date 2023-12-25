/* 2014097056 Seong Hyun Woo */
/* sp04A : Program similar to unix's chmod */
#include <stdio.h>
#include <stdlib.h>
#include <string.h>     // for use strcmp() function
#include <sys/types.h>
#include <sys/stat.h>
#include <unistd.h>
#include <dirent.h>

/* Function prototypes */
void change_mode(char *name, mode_t mode);
void change_mode_subfiles(char *dirname, mode_t mode);

int main(int ac, char *av[]) {
    // Usage output if incorrect input
    if (ac < 3) {
        fprintf(stderr, "Usage: %s [mode] [filename or directory]\n", av[0]);
        return 1;
    }
    else {
        // strtol(target, pointer, base) : Convert string to integer
        // av[1] is mode number
        // ex) "755" -> 755
        mode_t mode = strtol(av[1], NULL, 8);

        for (int i = 2; i < ac; i++) {
            // Check the status of a file or directory
            struct stat st;
            if (stat(av[i], &st) == -1) {
                perror(av[i]);
                continue;
            }
            // Directory -> Change subfiles
            if (S_ISDIR(st.st_mode)) {
                change_mode_subfiles(av[i], mode);
            // File -> Chnage permissions
            } else {
                change_mode(av[i], mode);
            }
        }
        return 0;
    }
}

void change_mode(char *name, mode_t mode) {
    if (chmod(name, mode) == -1) {
        perror(name);
    }
}

void change_mode_subfiles(char *dirname, mode_t mode) {
    DIR *dir_ptr;               // Directory pointer
    struct dirent *direntp;     // Directory entry structure
    char path[1024];            // Buffer to store the path string

    // open directory
    dir_ptr = opendir(dirname);
    if (dir_ptr == NULL) {
        perror(dirname);
        return;
    }
    
    // Traverse all subfiles in the current directory
    while ((direntp = readdir(dir_ptr))) {
        // Directory -> (recursive)Change subfiles    
        // 'DT_DIR' is a directory constant
        if (direntp->d_type == DT_DIR) {

            // Change directory access permissions
            if (chmod(dirname, mode) == -1) {
                perror(dirname);
            }

            // Visit a directory only if it is not the current directory or its parent directory
            if (strcmp(direntp->d_name, ".") != 0 && strcmp(direntp->d_name, "..") != 0) {
                snprintf(path, sizeof(path), "%s/%s", dirname, direntp->d_name);
                change_mode_subfiles(path, mode);
            }
        // File -> Chnage permissions
        } else {
            snprintf(path, sizeof(path), "%s/%s", dirname, direntp->d_name);
            change_mode(path, mode);
        }
    }
    closedir(dir_ptr);
}