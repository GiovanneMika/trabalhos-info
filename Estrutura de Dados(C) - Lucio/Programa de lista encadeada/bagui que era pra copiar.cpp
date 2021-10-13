#include <malloc.h>
#include <stdio.h>
struct lista
{
	int info;
	struct lista* prox; //prox é do tipo struct list que aponta para outro estruct list
};
typedef struct lista Lista; //é criado um alias, ou seja, quando é escrito Lista é referido a struct lista	

/*inicialização*/
Lista* inicializa(void) //função inicializa devolve um ponteiro de Lista, ou seja, devolve uma flecha que aponta para uma estrutura
{
	return NULL; //nesse caso a flecha esta apontando para nulo ou null, sendo um aterramento
}

/*inserção no inicio*/
Lista* insere(Lista* l, int i) //a função insere é a mais facil de implementar  devolve dentro recebe como parametro e i é a informação  ser inserida
{	
	Lista*novo=(Lista*) malloc(sizeof(Lista)); // é quase um poema, esta declarando umna variavel chamada noivo é esta variavel é um ponteiro pra uma lista
	novo->info=i; // novo é uma variavel ponteiro que precisa ser apontada para algum lugar, esta
	novo->prox=l; // o L aponta para lista, ou seja, para o começo da lista quado uma info i é adicionada
	return novo;
}
/* mostra*/
void mostra (Lista* l) //diz qual lista mostrar
{
	Lista* p; // p é o tipo o l da função anterior
	for(p=l;p!=NULL;p=p->prox); // mas agora com esse for o p caminha pelos mvalores guardados na lista
	printf("info - %d\n",p->info);
}
/* busca */
Lista* busca(Lista* l, int i) //
{
	Lista* p; //P É O PONTEIRO DA LISTA
	for(p=l;p!=NULL;p=p->prox) //P APONTA PARA L E VAI REPETI ATÉ CHGAR NO FINAL DA LISTA
	if(p->info==i) //AQUI ELE VERIFICA SE O P É IGUAL AO NUMERO QUE TU DIGITO
	return p; //AQUI ELE RETORNA SE ELE ACHO E SE NÃO ACHAR
	return NULL; //ELE VAI APONTAR PRO NULO
}
/* destroi */
void destroi (Lista* l) // o l aponta para a lista
{
	Lista* p=l; //o p aponta para onde o l aponta, ou seja, para o primeiro termo
	while(p!=NULL); //enquanto 
	{
		Lista* t=p->prox;
		free(p);
		p=t;	
	}
}
/* exclui */
Lista* exclui(Lista* l, int v)
{
	Lista* ant=NULL; //ant começa apontando pra null
	Lista* p=l;
	while (p!=NULL && p->info!=v) // vai repetir até que p seja nulo ou até que seja igual o numero a ser excluido
	{
		ant=p;
		p=p->prox;
	}
	if(p==NULL) //pra quando o elemento nao existe
		return l;
	if(ant==NULL) //pra quando o elemento a excluir é o proprio elemento
		l=p->prox;
	else
		ant->prox=p->prox; //aqui ele muda a rota pra exluir o elemento
	free(p); //aqui ele faz com que o elemento que antes estava excluido do encdeamento deixe de existir
	return l;
}
int main (void)
{
	lista* 	l;
		Lista* b;
	int elem,opcao=-1;
	l=inicializa();
		b=inicializa();
	while(opcao!=0)
	{
		printf("\n1-Insere elemento no início");
		printf("\n2-Mostra lista\n3-Busca elemento");
		printf("\n4-Exclui elemento\n0-Sair\n");
		printf("Digite sua opção");
		scanf("%d",&opcao);
		switch(opcao)
		{
		case 1:printf("Digite o elemento a inserir"); //se o user digitar 1 
			scanf("%d",&elem);
			l=insere(l,elem);
			printf("Elemento incluído!\n");
			break;
		case 2: mostra(l); break;
		case 3:printf("Digite o elemento a buscar");
			scanf("%d",&elem);
			b=busca(l,elem);
			if(b!=NULL) printf("Elemento existente!!!\n");
			else printf("Elemento não existe!!!\n");
			break;
		case 4: printf("Digite o elemento a excluir ");
			scanf("%d",&elem);
			l=exclui(l,elem);
			
			printf("Elemento excluído!\n");
			break;
			
		case 0:break;
		default: printf("Opção inválida\n");
		}
	}
	destroi(l);
}




















