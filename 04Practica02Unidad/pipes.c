#include <unistd.h>
#include <stdlib.h>
#include <stdio.h>
#include <string.h>

int main()
{
   int data_processed, n, primo = 0, i = 2;
   int fd[2];
   const char some_data[] = "";
   char buffer[BUFSIZ + 1];
   pid_t fork_result;

   memset(buffer, '\0', sizeof(buffer));


   if (pipe(fd) == 0) {
      fork_result = fork();
      if (fork_result == -1) {
	 fprintf(stderr, "Error en fork()");
	 exit(EXIT_FAILURE);
      }
      if (fork_result == 0) {//proceso hijo

	 data_processed = read(fd[0], buffer, BUFSIZ);
	 printf("[Hijo] El numero ");
	n = atoi(buffer);

	//determinar si es primo
	while(i <= n/2 && primo == 0){//determinar si es primo
           if(n%i == 0){
             primo = 1;
             }
             i++;
             }

	// termina ciclo

	if(primo == 0 && n != 1){
   
          printf("%s es primo\n",buffer);
          }else{
          printf("%s no es primo\n",buffer);
          } 

         exit(EXIT_SUCCESS);
      }
      else {//proceso padre
	printf("[Padre] Escribe un numero: ");
	 scanf("%s",&some_data);

	 data_processed = write(fd[1], some_data, strlen(some_data));
	 
      }
   }
   exit(EXIT_SUCCESS);
}
