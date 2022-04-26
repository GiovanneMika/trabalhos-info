#include <iostream>
using namespace std;
//    |
//    | forma do bolo
//    v
class Conta{
	private:
		//cobertura e a cor do bolo
		float saldo=0;
	public:
		//coloca a massa do bolo da forma
		void creditar(int x){
			saldo=saldo+x;
		}
		//tira a massa do bolo da forma
		void getSaldo(){
			cout << saldo << endl;
		}
};


int main (void){
	
	//inicia os bolos
	Conta c1, c2;
	int x;
	
	//coloca valores nas contas 1 e 2
	c1.creditar(121);
	c2.creditar(999);
	
	//mostra o saudo
	cout << "Conta 1:";
	c1.getSaldo();
	cout << "Conta 2:";
	c2.getSaldo();
	
	//credita saudo no caixa 2
	cout << "Digite o deposito da conta 2: ";
	cin >> x;
	c2.creditar(x);
	c2.getSaldo();
}
