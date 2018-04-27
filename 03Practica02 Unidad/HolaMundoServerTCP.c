#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <errno.h>
#include <string.h>
#include <sys/types.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <arpa/inet.h>
#include <sys/wait.h>
#include <signal.h>
#define MAXDATASIZE 200
#define MYPORT 4950     // numero de puerto para recibir conexiones
#define BACKLOG 10      // numero de conexiones pendientes


int main(void)
{
    int sockfd, new_fd, numbytes, a = 0, suma = 0, n = 0;
    struct sockaddr_in my_addr;  // direccion del servidor
    struct sockaddr_in their_addr; // direccion remota
    socklen_t sin_size;
    int yes=1;
    char buf[MAXDATASIZE];

    // se crea el socket
    if ((sockfd = socket(PF_INET, SOCK_STREAM, 0)) == -1) {
        perror("socket");
        exit(1);
    }

    // se define el comportamiento del socket
    if (setsockopt(sockfd,SOL_SOCKET,SO_REUSEADDR,&yes,sizeof(int)) == -1) {
        perror("setsockopt");
        exit(1);
    }

    my_addr.sin_family = AF_INET;          // familia de direcciones de sockets (TCP/IP v4)
    my_addr.sin_port = htons(MYPORT);      // se convierte a  network byte order
    my_addr.sin_addr.s_addr = INADDR_ANY;  // se obtiene direccion local
    memset(&(my_addr.sin_zero), '\0',8);   //  se ponen 0's en el resto de la estructura
    if (bind(sockfd, (struct sockaddr *)&my_addr, sizeof(struct sockaddr))
                                                                    == -1) {
        perror("bind");
        exit(1);
    }

    // se habilita el puerto para recibir conexiones
    if (listen(sockfd, BACKLOG) == -1) {
        perror("listen");
        exit(1);
    }

    while(1) { // ciclo infinito del servidor, en el que se reciben conexiones de clientes
        sin_size = sizeof(struct sockaddr_in);

	// se espera una nueva conexion
        if ((new_fd = accept(sockfd, (struct sockaddr *)&their_addr,
                                                        &sin_size)) == -1) {
            perror("accept");
            continue;
        }

	// ha llegado una conexion! se imprimen los datos de la misma
        printf("\nServidor: teniendo conexion desde %s\n",
                                            inet_ntoa(their_addr.sin_addr));
        if (send(new_fd, "Hola Mundo desde un Servidor!\n", 30, 0) == -1)
            perror("send");
	buf [numbytes]= '\0';   
	//el servidor le enviara un mensaje al cliente solicitando un numero  
        if (send(new_fd, "\nIngrese numero: ", 18, 0) == -1)
            perror("send");
	//recibe el numero ingresado por el cliente
	buf [numbytes]= '\0';

	if ((numbytes=recv(new_fd, buf, MAXDATASIZE-1, 0)) == -1) {
            perror("recv");
            exit(1);
         }
	// se limpia el buffer
	buf [numbytes]= '\0';
	fflush(stdin);
        buf [numbytes]= 0;
	//imprime numero recibido
	printf("\nNumero recibido: %s",buf);
        // se limpia el buffer
	buf [numbytes]= '\0';
	fflush(stdin);
        buf [numbytes]= 0;
        n = atoi(buf);
	//se calcula la sumatoria
	for(a = n; a > 0; a--){//determinar sumatoria de 1 hasta n
       suma += a;
        }
	printf("\nSumatoria %d",suma);

	//el servidor le enviara la sumatoria al cliente   
        if (send(new_fd, "\nSumatoria: %d ", 18, 0) == -1)
            perror("send");
	
        close(new_fd); // se cierra la conexion
    }

  return 0;
}
