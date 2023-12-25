/* utmplib.c - functions to buffer reads from utmp file
*
* function are
* 	utmp_open(filename ) - open file
*		reutrns -1 on error
* 	utmp_next()	- return pointer to next struct
*		returns NULL on eof
* 	utmp_close()	- close file
*
*    reads NRECS per read and then doles them out from the buffer
*/
# include <stdio.h>
# include <fcntl.h>
# include <sys/types.h>
# include <utmp.h>
# include <unistd.h>			/* read 함수 */

# define NRECS 16			/* num of records */
# define NULLUT ((struct utmp *) NULL)	/* UTMP의 NULL POINTER */
# define UTSIZE (sizeof(struct utmp))	/* utmp struct 하나당 size */

static char utmpbuf[NRECS * UTSIZE];	/* storage */
static int num_recs;			/* num stored */
static int cur_rec;			/* next to go */
static int fd_utmp = -1;		/* read from */

utmp_open( char *filename )
{
	fd_utmp = open(filename, O_RDONLY );	/* open it by read only */
	cur_rec = num_recs = 0;			/* no rece yet, 초기화  */
	return fd_utmp;				/* 오픈한 파일객체 반환 */
}

struct utmp *utmp_next()
{
	struct utmp *recp;			/* record pointer? */
	if ( fd_utmp == -1)			/* error ? */
		return NULLUT;
	if ( cur_rec == num_recs && utmp_reload() == 0)	/* any more ? */
		return NULLUT;
						/* get address of next record */
	recp = (struct utmp *) &utmpbuf[cur_rec * UTSIZE];
	cur_rec++;
	return recp;
}

int utmp_reload()
/* read next bunch of records into buffer */
{
	int amt_read;				/* read them in */
	amt_read = read( fd_utmp, utmpbuf, NRECS * UTSIZE) ;
	num_recs = amt_read/UTSIZE;		/* reset pointer */
	cur_rec = 0;
		return num_recs;
}

utmp_close()
{
	if(fd_utmp != -1)		/* don't close if not */
		close( fd_utmp);	/* open */
}
