#include <iostream>
using namespace std;
class Multiplica{
	private:
		float metodoUm;
		float metodoDois;
	public:
		Multiplica(){
			metodoUm = 70;
			metodoDois = 7;
		}
		float fazOperacao(){
            return metodoUm * metodoDois;
        }
};

int main (void){
	Multiplica ola;
	cout << ola.fazOperacao();
	return 0;
}
