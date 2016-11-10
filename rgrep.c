#include <stdio.h>
#define MAXSIZE 4096

/**
 * You can use this recommended helper function
 * Returns true if partial_line matches pattern, starting from
 * the first char of partial_line.
 */
int matches_leading(char *partial_line, char *pattern) {
  // Implement if desire

return 0;
}

/**
 * You may assume that all strings are properly null terminated
 * and will not overrun the buffer set by MAXSIZE
 *
 * Implementation of the rgrep matcher function
 */
int rgrep_matches(char *line, char *pattern) {
int i = 0;  //pattern
int j = 0;  //line

while (1){
    
    

    if (pattern[i] == line[j])  //increments up 1 if they match
    {
        i++;
        j++;
    
    if (pattern[i] == '.' )  //wildcard!
    {
        i++;
        j++;
    }
    if (pattern[i] == 0){
            return 1;
        }
    }    

    if (pattern[i] != line[j])  //continues through the line if they do not match
    {
        i = 0;
        j += 1;
     
        if (line[j] == 0)
        {
        return 0;
        }
    }
    
    
    }





}

int main(int argc, char **argv) {
    if (argc != 2) {
        fprintf(stderr, "Usage: %s <PATTERN>\n", argv[0]);
        return 2;
    }

    //we're not going to worry about long lines 
    char buf[MAXSIZE];

    while (!feof(stdin) && !ferror(stdin)) {
        if (!fgets(buf, sizeof(buf), stdin)) {
            break;
        }
        if (rgrep_matches(buf, argv[1])) {
            fputs(buf, stdout);
            fflush(stdout);
        }
    }

    if (ferror(stdin)) {
        perror(argv[0]);
        return 1;
    }

    return 0;
}
