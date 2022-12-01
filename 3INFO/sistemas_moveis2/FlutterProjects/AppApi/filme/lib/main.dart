import 'dart:io';
import 'package:clienteapi/filme.dart';
import 'package:clienteapi/filme_service.dart';
import 'package:clienteapi/dev_http_overrides.dart';
import 'package:flutter/material.dart';

void main() {
  HttpOverrides.global = DevHttpOverrides();
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({Key? key}) : super(key: key);
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
        debugShowCheckedModeBanner: false,
        title: 'Cadastro de Filmes',
        theme: ThemeData(
          primarySwatch: Colors.blue,
        ),
        home: const HomePage());
  }
}

class HomePage extends StatefulWidget {
  const HomePage({Key? key}) : super(key: key);
  @override
  _HomePageState createState() => _HomePageState();
}

class _HomePageState extends State<HomePage> {
  List<Map<String, dynamic>> _filmes = [];
  Filme filme = Filme("", 0);
  bool _carregando = true;
  void _listaFilmes() async {
    _filmes = [];
    final data = await FilmeService.listaFilmes();
    setState(() {
      for (var e in data) {
        _filmes.add(<String, dynamic>{
          "id": e.id,
          "nome": e.nome,
          "ano": e.ano,
        });
      }
      _carregando = false;
    });
  }

  @override
  void initState() {
    super.initState();
    _listaFilmes();
  }

  final TextEditingController _nomeController = TextEditingController();
  final TextEditingController _anoController = TextEditingController();
  void _showForm(int? id) async {
    if (id != null) {
      final existente = _filmes.firstWhere((element) => element['id'] == id);
      _nomeController.text = existente['nome'];
      _anoController.text = existente['ano'].toString();
    }
    showModalBottomSheet(
        context: context,
        elevation: 5,
        isScrollControlled: true,
        builder: (_) => Container(
              padding: EdgeInsets.only(
                top: 15,
                left: 15,
                right: 15,
                bottom: MediaQuery.of(context).viewInsets.bottom + 120,
              ),
              child: Column(
                mainAxisSize: MainAxisSize.min,
                crossAxisAlignment: CrossAxisAlignment.end,
                children: [
                  TextField(
                    controller: _nomeController,
                    decoration: const InputDecoration(hintText: 'Nome'),
                  ),
                  const SizedBox(
                    height: 10,
                  ),
                  TextField(
                    controller: _anoController,
                    decoration: const InputDecoration(hintText: 'Ano'),
                  ),
                  const SizedBox(
                    height: 20,
                  ),
                ],
              ),
            ));
  }

  void telaToContato() {
    filme = Filme(_nomeController.text, int.parse(_anoController.text));
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Visualização de Filmes'),
      ),
      body: _carregando
          ? const Center(
              child: CircularProgressIndicator(),
            )
          : ListView.builder(
              itemCount: _filmes.length,
              itemBuilder: (context, index) => Card(
                color: Colors.red[200],
                margin: const EdgeInsets.all(15),
                child: ListTile(
                    title: Text(_filmes[index]['nome']),
                    subtitle: Column(
                      crossAxisAlignment: CrossAxisAlignment.start,
                      children: [
                        Text(_filmes[index]['ano'].toString()),
                      ],
                    ),
                    trailing: SizedBox(
                      width: 100,
                      child: Row(),
                    )),
              ),
            ),
    );
  }
}
