#include<stdio.h>
int main(){
	int idadedias,anos=0,meses=0,dias=0; 
	scanf("%d",&idadedias);
	while(idadedias>=365){
		idadedias=idadedias-365;
		anos++;
	}
	meses=0;
	while(idadedias>=30){
		idadedias=idadedias-30;
		meses++;
	}
		while(idadedias>=1){
		idadedias=idadedias-1;
		dias++;
	}	
	printf("%d ano(s)\n%d mes(es)\n%d dia(s)\n",anos,meses,dias);
}
