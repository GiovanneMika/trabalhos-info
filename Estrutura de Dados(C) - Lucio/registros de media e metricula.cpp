#include<stdio.h>
struct reg{
	int matricula;
	float media;
};
typedef struct reg Reg;
int main(){
	Reg lista[10];
	int c;
	for(c=0;c<10;c++){
		printf("Digite a matricula: ");
		scanf("%d",&lista[c].matricula);
		printf("Digite a nota: ");
		scanf("%f",&lista[c].media);
	}
	for(c=0;c<10;c++){
		if(lista[c].media<6){
			printf("O aluno de matricula %d esta com nota abaixo da media 6.\n",lista[c].matricula);
		}
	}
}
