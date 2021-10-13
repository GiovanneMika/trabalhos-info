//Num cenário onde torna-se necessário desenhar figuras geométricas, a classe abstrata poliedros serve como base para a formação das classes tetraedro, hexaedro e octaedro, fornecendo como herança os métodos getArestas() e desenhaPoliedro(). 

abstract class Poliedro{        
    abstract Int getArestas();

    public desenhaPoliedro();
}

class Tetraedro extends Poliedro{
    public String getArestas(){
        return "6";
    }
    public desenhaPoliedro();
}

class Hexaedro extends Poliedro{
    public String getArestas(){
        return "12";
    }
    public desenhaPoliedro();
}
class Octaedro extends Poliedro{
    public String getArestas(){
        return "16";
    }
    public desenhaPoliedro();
}

int main(void){
	Tetraedro giovannelindo;
	return 0;
}
