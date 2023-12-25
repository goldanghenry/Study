/* 2014097056 Seong Hyun Woo */
/* Program similar to unix's ls */
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <dirent.h>

/* Function prototypes */
ino_t get_inode(char *);
void printpathto(ino_t);
void inum_to_name(ino_t, char *, int);

int main() {
    printpathto( get_inode("."));
    putchar('\n');
    return 0;
}

/*  return inode numver of the file */
ino_t get_inode(char *fname){
    struct stat info;
    if (stat(fname, &info)== -1) {
        fprintf(stderr, "Cannot stat ");
        perror(fname);
        exit(1);
    }
    return info.st_ino;
}

/* prints path leading down to an object with this inode kindof recursive */
void printpathto(ino_t this_inode) {
    ino_t my_inode;
    char its_name[BUFSIZ];

    if (get_inode("..") != this_inode) {                
        chdir("..");                                    /* up one dir */
        inum_to_name(this_inode, its_name, BUFSIZ);     /* get its name */
        
        my_inode = get_inode(".");      /* print head */
        printpathto( my_inode );        /* recursively */
        printf("/%s", its_name);        /* now print name of this */
    }
}
/* looks through current directory for a file with this inode 
    number and copies its name into namebuf    */
void inum_to_name(ino_t inode_to_find, char *namebuf, int buflen){
    DIR *dir_ptr;
    struct dirent *direntp;

    dir_ptr = opendir(".");

    if (dir_ptr == NULL) {
        perror(".");
        exit(1);
    }

    /*  search directory for a file with specified inum */
    while((direntp = readdir(dir_ptr))!=NULL){
        if (direntp -> d_ino == inode_to_find ){
            strncpy( namebuf, direntp-> d_name, buflen);
            namebuf[buflen-1] = '\0';   /* just in case */
            closedir(dir_ptr);
            return;
        }
    }

    fprintf(stderr, "error looking for inum %ld\n", inode_to_find);
    exit(1);
}





