import 'package:flutter/material.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({Key? key}) : super(key: key);

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Demo',
      debugShowCheckedModeBanner: false,
      theme: ThemeData(
        primarySwatch: Colors.red,
      ),
      home: const MyHomePage(title: 'Aplicação com Estado'),
    );
  }
}

class MyHomePage extends StatefulWidget {
  const MyHomePage({Key? key, required this.title}) : super(key: key);

  final String title;

  @override
  State<MyHomePage> createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {
  String login = "", senha = "", result = "";
  final _tH = TextEditingController();
  final _tL = TextEditingController();

  void _verificaUser() {
    setState(() {
      login = _tH.text;
      senha = _tL.text;
      result = login == "crispintinho" && senha == "crispintinho12212"
          ? "Deu boa patrão"
          : "Algo deu errado e não esta certo";
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text(widget.title),
      ),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: <Widget>[
            TextFormField(
              decoration: const InputDecoration(labelText: "Digite o user:"),
              controller: _tH,
            ),
            TextFormField(
              decoration:
                  const InputDecoration(labelText: "Digite a password:"),
              controller: _tL,
            ),
            ElevatedButton(
              onPressed: _verificaUser,
              child: const Text('Enter'),
            ),
            Text(
              result,
            ),
          ],
        ),
      ), // This trailing comma makes auto-formatting nicer for build methods.
    );
  }
}
