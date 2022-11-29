import 'package:clienteapi/filme.dart';
import 'package:http/http.dart' as http;
import 'dart:convert';

class FilmeService {
  static const url = "http://192.168.198.112:3333";
  static Future<int> insere(Filme filme) async {
    try {
      final response = await http.post(
        Uri.parse(url),
        headers: <String, String>{
          'Content-Type': 'application/json; charset=UTF-8',
        },
        body: jsonEncode(filme),
      );
      return response.statusCode == 200 ? 0 : 1;
    } catch (e) {
      throw Exception("Erro ao carregar inserir " + e.toString());
    }
  }

  static Future<int> atualiza(Filme filme) async {
    try {
      String? id = filme.id;
      final response = await http.put(
        Uri.parse("$url/$id"),
        headers: <String, String>{
          'Content-Type': 'application/json; charset=UTF-8',
        },
        body: jsonEncode(filme),
      );
      return response.statusCode == 200 ? 0 : 1;
    } catch (e) {
      throw Exception("Erro ao carregar alteração");
    }
  }

  static Future<int> exclui(int id) async {
    try {
      final response = await http.delete(Uri.parse('$url/$id'));
      return response.statusCode == 200 ? 0 : 1;
    } catch (e) {
      throw Exception("Erro ao processar exclusão");
    }
  }

  static Future<List<Filme>> listaFilmes() async {
    try {
      List<Filme> listaFilme = [];
      final response = await http.get(Uri.parse(url));
      if (response.statusCode == 200) {
        var decodeJson = jsonDecode(response.body);
        decodeJson.forEach((item) => listaFilme.add(Filme.fromJson(item)));
        return listaFilme;
      } else {
        throw Exception("Erro ao carregar filmes 1");
      }
    } catch (e) {
      throw Exception("Erro ao carregar filmes 2 " + e.toString());
    }
  }

  static Future<Filme> filme(int id) async {
    try {
      Filme filme = Filme("", 0);
      final response = await http.get(Uri.parse("$url/$id"));
      if (response.statusCode == 200) {
        var decodeJson = jsonDecode(response.body);
        filme = Filme.fromJson(decodeJson);
        return filme;
      } else {
        throw Exception("Erro ao carregar dados 1");
      }
    } catch (e) {
      throw Exception("Erro ao carregar dados 2");
    }
  }
}
