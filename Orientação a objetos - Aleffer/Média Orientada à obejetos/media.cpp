#include <iostream>
using namespace std;
class PosMe{
	private:
		float mediaPos = 0, positivos = 0, somaPos = 0;
		int quantPos = 0;
	public:
		void media(){
			for(int x=0;x!=6;x++){
				cin >> positivos;
				if(positivos>=0){
					quantPos++;
					somaPos = somaPos + positivos;
				}
			}
			mediaPos = somaPos/quantPos;
		}
		void getPositivos(){
			cout << quantPos << " valores positivos" << endl;
		}
		void getMedia(){
			cout << mediaPos << endl;
		}
};


int main (void){
	PosMe num1;
	int x;
	
	num1.media();
	
	num1.getPositivos();
	num1.getMedia();

}




