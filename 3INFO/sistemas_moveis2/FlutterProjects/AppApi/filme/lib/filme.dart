class Filme {
  String? id;
  String? nome;
  int? ano;
  Filme(
    this.nome,
    this.ano,
  );
  Filme.fromJson(Map<String, dynamic> json) {
    id = json['id'];
    nome = json['name'];
    ano = json['ano'];
  }
  Map<String, dynamic> toJson() {
    return <String, dynamic>{
      "name": nome,
      "ano": ano,
    };
  }
}
