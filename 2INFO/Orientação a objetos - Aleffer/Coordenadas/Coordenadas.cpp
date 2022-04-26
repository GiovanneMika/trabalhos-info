#include <iostream>

using namespace std;
class Boneco{
	private:
		int idBoneco;
		double CoordenadaX=0, CoordenadaY=0;
	public:
		void obterPosicaoHorizontal(){
			cout << "Digite a coordenada X:";
			cin >> 	CoordenadaX;
		};
		
		void obterPosicaoVertical(){
			cout << "Digite a coordenada Y:";
			cin >> 	CoordenadaY;
		};
		void mostravalorX(void){
			cout << "Coordenada X = " << CoordenadaX << endl;
		};
		void mostravalorY(void){
			cout << "Coordenada Y = " << CoordenadaY << endl;
		};
		void mostravalorXY(void){
			cout << "Coordenadas XY = (" << CoordenadaX << "," << CoordenadaY << ")" << endl;
		};
		double retornaX(void){
			return CoordenadaX;
		};
};

int main (void){
	Boneco cordx, cordy;
	cordx.mostravalorX();
	cordy.mostravalorY();
	do{	cordx.obterPosicaoHorizontal();
		cordy.obterPosicaoVertical();
		
		cordx.mostravalorX();
		cordy.mostravalorY();
		cordx,cordy.mostravalorXY();
	}while(cordx.retornaX()!=-1);
		
}
