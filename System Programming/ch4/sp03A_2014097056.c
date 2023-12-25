/* 2014097056 Seong Hyun Woo */
/* Program similar to unix's ls */
#include <stdio.h>
#include <sys/types.h>
#include <sys/stat.h>   /* To use the stat function, file mode, and file mode bit macros */
#include <string.h>     /* To use the strcpy function */
#include <dirent.h>     /* Struct for directory entry */
#include <pwd.h>        /* Username lookup */
#include <grp.h>        /* Group lookup */

/* Function prototypes */
void do_ls(char dirname[]);                  /* List files in directory called dirname */
void list_file_info(char *path);             /* Get file information using stat/stat.h */
void mode_to_letters(int mode, char str[]);  /* Convert file type and user permissions to 10 characters */
char *uid_to_name(uid_t);                    /* Returns pointer to username associated with uid, using getpw() */
char *gid_to_name(gid_t);                    /* Returns pointer to group name associated with gid */

/* Main function */
void main(int ac, char *av[]) {             
    /* If only the file name is entered, list all entries */
    if(ac == 1)
        do_ls(".");
    else {
        for (int i = 1; i < ac; i++) {
            do_ls(av[i]);
            if (i != ac - 1){
                printf("\n");
            }
        }
    }
}

/* List files in directory called filemame */
void do_ls(char dirname[]) {
    struct stat st;
    if (stat(dirname, &st) == -1) {
        perror(dirname);
        return;
    }

    if (S_ISDIR(st.st_mode)) {
        printf("%s:\n", dirname);
        DIR *dir_ptr;               // Directory pointer
        struct dirent *direntp;     // Directory entry structure
        char path[1024];            // Buffer to store the path string

        // Temporary array declaration for recursive
        char subdirs[1024][1024];
        int subdir_count = 0;

        // Attempt to open the directory
        if ((dir_ptr = opendir(dirname)) == NULL) {
            fprintf(stderr, "ls: cannot access \'%s\' : No such file or directory\n", dirname);
            return;

        } else {
            // Process entries within the directory
            while ((direntp = readdir(dir_ptr)) != NULL) {

                // Generate the path of the current entry
                snprintf(path, sizeof(path), "%s/%s", dirname, direntp->d_name);

                // Display information of the current entry
                list_file_info(path);

                // Get information of the current entry
                struct stat info;
                if (stat(path, &info) == -1) {
                    perror(path);
                    continue;
                }
                // If the current entry is a directory, store it in subdirs array
                 if (S_ISDIR(info.st_mode)) {
                    strcpy(subdirs[subdir_count++], path);
                }
            }
        }
        closedir(dir_ptr);  // Close the directory pointer

        // Process subdirectories recursively
        for (int i = 0; i < subdir_count; i++) {
            // Process only if the name of the current entry does not start with . or ..
            if (subdirs[i][strlen(subdirs[i])-1] != '.' && subdirs[i][strlen(subdirs[i])-2] != '.') {
                printf("\n");
                do_ls(subdirs[i]);
            }
        }
    }
    else {
        list_file_info(dirname);
    }
}

void list_file_info(char *path) {
    // Get file information
    struct stat info;
    if (stat(path, &info) == -1) {
        perror(path);
        return;
    }
    char *uid_to_name(), *ctime(), *gid_to_name(), *filemod();
    void mode_to_letters();
    char modestr[11];

    mode_to_letters( info.st_mode, modestr );          /* Convert mode to letters */

    printf( "%s ", modestr);                           /* Print file mode */
    printf("%d ", (int)info.st_nlink);                 /* Print number of links */
    printf("%-6s", uid_to_name( info.st_uid ));        /* Print user name */
    printf("%-6s", gid_to_name( info.st_gid ));        /* Print group name */
    printf("%6ld ", (long)info.st_size );              /* Print file size */
    printf("%.12s ", 4+ctime( &info.st_mtime ));       /* Print last modification time */
    char *filename = strrchr(path, '/');               /* Extract file name from the file path */
    if (filename != NULL) {
        filename++;  /* The file name starts after the slash */
    } else {
        filename = path;  /* If there is no slash, the whole path is the file name */
    }

    printf("%s\n", filename);  /* Print the file name */
}
/* Convert file mode to string */
void mode_to_letters(int mode, char str[]) {
    strcpy(str, "----------");

    if (S_ISDIR(mode)) str[0] = 'd';
    if (S_ISCHR(mode)) str[0] = 'c';
    if (S_ISBLK(mode)) str[0] = 'b';

    if (mode & S_IRUSR) str[1] = 'r';
    if (mode & S_IWUSR) str[2] = 'w';
    if (mode & S_IXUSR) str[3] = 'x';

    if (mode & S_IRGRP) str[4] = 'r';
    if (mode & S_IWGRP) str[5] = 'w';
    if (mode & S_IXGRP) str[6] = 'x';

    if (mode & S_IROTH) str[7] = 'r';
    if (mode & S_IWOTH) str[8] = 'w';
    if (mode & S_IXOTH) str[9] = 'x';
}

/* Returns pointer to username associated with uid, uses getpw() */
char *uid_to_name( uid_t uid ){
    struct passwd *getpwuid(), *pw_ptr;
    static char numstr[10];

    if( (pw_ptr = getpwuid( uid )) == NULL) {
        sprintf(numstr, "%d", uid);
        return numstr;
    }
    else
        return pw_ptr -> pw_name;
}

/* Returns pointer to group name associated with gid, uses getgrgid(3) */
char *gid_to_name( gid_t gid ) {
    struct group *getgrgid(), *grp_ptr;
    static char numstr[10];

    if( (grp_ptr = getgrgid( gid )) == NULL) {
        sprintf(numstr, "%d", gid);
        return numstr;
    }
    else
        return grp_ptr -> gr_name;
}
