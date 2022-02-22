// Munaimah Khan
// COP 3502, Spring 2022
// Assignment 1
#include <ctype.h>
#include <stdio.h>
#include <string.h>

void printNumeronym(char *str);
void printShortenedSentence(char *str);
double difficultyRating(void);
double hoursSpent(void);

// Function takes in pointer to string array
// and converts it to a numeronym based on its evaluation of string length.
// Words longer than 9 lettes are converted into numeronym form.
void printNumeronym(char *str)
{
  int length;

  length = strlen(str);

    if (length >= 9)
    {
      printf("%s -> %c%d%c\n", str, *str, (length - 2), str[length-1]);
    }
    else
    {
      printf("%s (no change)\n", str);
    }
}

// Utilizes the index behavior of a character string array to
// evaluate the Numeronym condition for each word in the string input.
// Words less than 9 letters are printed as is; the rest are converted to numeronyms.
void printShortenedSentence(char *str)
{
  int i, j;
  int indxWordEnd = 0;
  int indxWordBeg = 0;
  int wordLen = 0;
  int length = strlen(str);

// loops through each index of the char array
  for (i = 0; i < length; i++)
  {
    indxWordEnd = i - 1;
    indxWordBeg = -wordLen + 1 + indxWordEnd;

// Creates cutoff points for words within the multi-word string.
    if (str[i] == ' '|| str[i] == '.' || str[i] == '?' || str[i] == '!')
    {
       if (wordLen >= 9)
       {
         printf("%c%d%c", str[indxWordBeg], (wordLen - 2), str[indxWordEnd]);
       }

       else
        {
         for (j = indxWordBeg; j < (indxWordEnd + 1); j++)
         {
          printf("%c", str[j]);
         }
        }

        wordLen = 0;
        printf("%c", str[i]);
      }
    else
    {
      wordLen++;
    }
  }
printf("\n");
}

double difficultyRating(void)
{
  return 2.8;
}

double hoursSpent(void)
{

  return 16;
}


int main(int argc, char **argv)
{
  int i;

  for (i = 1; i < argc; i++)
  {
  printNumeronym(argv[i]);
  }

  return 0;
}
