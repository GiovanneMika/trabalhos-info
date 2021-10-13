#include <iostream>
using namespace std;
class Calculadora{
	private:
		float x,y;
	public:
		void getValores(){
			cin >> x;
			cin >> y;
		};
		float somaValores(void){
			return x+y;
		};
		float subtraiValores(void){
			return x-y;
		};
		float multiplicaValores(void){
			return x*y;
		};
		float divideValores(void){
			if(y!=0){
				return x/y;
			}else{
				cout << "Não é possível dividir por zero!";
			};
		};
		
};
int main(void){
	Calculadora calc;
	float x,y;
	cout << "Digite o primeiro valor:";
	cin >> x;
	cout << "Digite o segundo valor:";
	cin >> y;
	
	calc.getValores(x,y);
	
	cout << x << "+" << y << "=" << calc.somaValores()<< "\n";
	cout << x << "-" << y << "=" << calc.subtraiValores()<< "\n";
	cout << x << "*" << y << "=" << calc.multiplicaValores()<< "\n";
	if (y!=0){
	cout << x << "/" << y << "=" << calc.divideValores()<< "\n";
}else{
	cout << "Não é possível dividir por zero!";
};
	
};
