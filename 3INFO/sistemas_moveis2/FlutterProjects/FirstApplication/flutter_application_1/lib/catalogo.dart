import 'package:flutter/material.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      theme: ThemeData(primaryColor: Colors.green),
      home: home(),
    );
  }
}

Widget home() {
  return Scaffold(
    appBar: AppBar(
      title: Text("Partido Cachaceiro Comunista"),
    ),
    body: ListView(
      padding: const EdgeInsets.all(1),
      children: <Widget>[
        SingleChildScrollView(
          scrollDirection: Axis.vertical,
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            crossAxisAlignment: CrossAxisAlignment.center,
            children: [
              Row(
                  mainAxisAlignment: MainAxisAlignment.center,
                  crossAxisAlignment: CrossAxisAlignment.center,
                  children: [
                    Padding(
                      padding: const EdgeInsets.all(3.0),
                      child: Image.asset(
                        "erva-doce1.jpeg.png",
                        height: 250,
                        width: 250,
                      ),
                    ),
                  ]),
              Row(
                mainAxisAlignment: MainAxisAlignment.center,
                crossAxisAlignment: CrossAxisAlignment.center,
                children: [Text("Erva Doce")],
              ),
              Row(
                  mainAxisAlignment: MainAxisAlignment.center,
                  crossAxisAlignment: CrossAxisAlignment.center,
                  children: [
                    Padding(
                      padding: const EdgeInsets.all(45.0),
                      child: Image.asset(
                        "erva-cidreira-emp.png",
                        height: 150,
                        width: 150,
                      ),
                    ),
                  ]),
              Row(
                mainAxisAlignment: MainAxisAlignment.center,
                crossAxisAlignment: CrossAxisAlignment.center,
                children: [Text("Erva Cidreira")],
              ),
              Row(
                  mainAxisAlignment: MainAxisAlignment.center,
                  crossAxisAlignment: CrossAxisAlignment.center,
                  children: [
                    Padding(
                      padding: const EdgeInsets.all(45.0),
                      child: Image.asset(
                        "HIBISCO1--1-.png",
                        height: 150,
                        width: 150,
                      ),
                    ),
                  ]),
              Row(
                mainAxisAlignment: MainAxisAlignment.center,
                crossAxisAlignment: CrossAxisAlignment.center,
                children: [Text("Hibisco")],
              ),
              Row(
                  mainAxisAlignment: MainAxisAlignment.center,
                  crossAxisAlignment: CrossAxisAlignment.center,
                  children: [
                    Padding(
                      padding: const EdgeInsets.all(45.0),
                      child: Image.asset(
                        "Camomila-100g.png",
                        height: 150,
                        width: 150,
                      ),
                    ),
                  ]),
              Row(
                mainAxisAlignment: MainAxisAlignment.center,
                crossAxisAlignment: CrossAxisAlignment.center,
                children: [Text("Camomila")],
              ),
              Row(
                  mainAxisAlignment: MainAxisAlignment.center,
                  crossAxisAlignment: CrossAxisAlignment.center,
                  children: [
                    Padding(
                      padding: const EdgeInsets.all(45.0),
                      child: Image.asset(
                        "Matcha-100g.png",
                        height: 150,
                        width: 150,
                      ),
                    ),
                  ]),
              Row(
                mainAxisAlignment: MainAxisAlignment.center,
                crossAxisAlignment: CrossAxisAlignment.center,
                children: [Text("Matcha")],
              ),
              Row(
                  mainAxisAlignment: MainAxisAlignment.center,
                  crossAxisAlignment: CrossAxisAlignment.center,
                  children: [
                    Padding(
                      padding: const EdgeInsets.all(45.0),
                      child: Image.asset(
                        "cha-verde1.png",
                        height: 150,
                        width: 150,
                      ),
                    ),
                  ]),
              Row(
                mainAxisAlignment: MainAxisAlignment.center,
                crossAxisAlignment: CrossAxisAlignment.center,
                children: [Text("Chá Verde")],
              ),
              Row(
                  mainAxisAlignment: MainAxisAlignment.center,
                  crossAxisAlignment: CrossAxisAlignment.center,
                  children: [
                    Padding(
                      padding: const EdgeInsets.all(45.0),
                      child: Image.asset(
                        "Hortela-Desidratada-100g.png",
                        height: 150,
                        width: 150,
                      ),
                    ),
                  ]),
              Row(
                mainAxisAlignment: MainAxisAlignment.center,
                crossAxisAlignment: CrossAxisAlignment.center,
                children: [Text("Hortelã Desidratada")],
              ),
              Row(
                  mainAxisAlignment: MainAxisAlignment.center,
                  crossAxisAlignment: CrossAxisAlignment.center,
                  children: [
                    Padding(
                      padding: const EdgeInsets.all(45.0),
                      child: Image.asset(
                        "cavalinha1.png",
                        height: 150,
                        width: 150,
                      ),
                    ),
                  ]),
              Row(
                mainAxisAlignment: MainAxisAlignment.center,
                crossAxisAlignment: CrossAxisAlignment.center,
                children: [Text("Cavalinha")],
              ),
              Row(
                  mainAxisAlignment: MainAxisAlignment.center,
                  crossAxisAlignment: CrossAxisAlignment.center,
                  children: [
                    Padding(
                      padding: const EdgeInsets.all(45.0),
                      child: Image.asset(
                        "cha-dente-leao.png",
                        height: 150,
                        width: 150,
                      ),
                    ),
                  ]),
              Row(
                mainAxisAlignment: MainAxisAlignment.center,
                crossAxisAlignment: CrossAxisAlignment.center,
                children: [Text("Cha dente de leão")],
              ),
              Row(
                  mainAxisAlignment: MainAxisAlignment.center,
                  crossAxisAlignment: CrossAxisAlignment.center,
                  children: [
                    Padding(
                      padding: const EdgeInsets.all(45.0),
                      child: Image.asset(
                        "boldo-emp.png",
                        height: 150,
                        width: 150,
                      ),
                    ),
                  ]),
              Row(
                mainAxisAlignment: MainAxisAlignment.center,
                crossAxisAlignment: CrossAxisAlignment.center,
                children: [Text("Boldo")],
              ),
            ],
          ),
        ),
      ],
    ),
    drawer: Drawer(
        child: Column(
      mainAxisAlignment: MainAxisAlignment.center,
      children: [
        Text("Tabacaria e Loja de chá Mika's"),
        Image.asset(
          "green-cup-of-tea-logo-8899AF2BAF-seeklogo.com.png",
          height: 150,
          width: 150,
        ),
        Text("Fone: 4002-8922"),
        Text("Develop by Givas"),
      ],
    )),
  );
}
