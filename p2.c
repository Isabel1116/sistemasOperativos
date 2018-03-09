#include <unistd.h>
#include <stdio.h>

main(){
	int n = 0, father = 0, son = 0, return_value, suma = 0, i, factorial = 1;

	printf("Escribe un numero: ");
    scanf("%d", &n);

	return_value=fork();
	if(return_value==0){
		//printf("El pid del proceso hijo es %d\n", getpid());
        son = getpid();
        for(i = n;i > 1; i--){//factorial
            factorial = factorial * n;
	    }
		printf("Hijo  %d: El factorial de %d es: %d\n",son,n, factorial);
	}
	else{
		//printf("El pid del proceso padre es %d\n", getpid());
        father = getpid();
		for(i = n;i > 0; i--){//suma de 1 hasta n
            suma += i;
	    }
	    printf("Padre %d: La sumatoria de 1 hasta %d es: %d\n",father,n,suma);
	}    

}
