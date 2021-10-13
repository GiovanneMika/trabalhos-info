#include <iostream>

using namespace std;
class MinhaClasse{
	private:
		int x;
	public:
		void receberValor(int d){
			x = d;
		}
		
		void mostravalor(void){
			cout << "Valor = " << x << endl;
		}
};

int main (void){
	MinhaClasse obj1, obj2;
	
	obj1.receberValor(51);
	obj2.receberValor(22);
	obj1.mostravalor();
	
	obj2.mostravalor();
	return 0;
}
