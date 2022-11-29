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
    body: Container(
      color: Color.fromARGB(255, 206, 63, 63),
      height: double.infinity,
      width: double.infinity,
      child: Column(
        mainAxisAlignment: MainAxisAlignment.start,
        crossAxisAlignment: CrossAxisAlignment.center,
        children: [
          const Text(
            "PARTIDO SOCIAL PROGRAMADOR",
            style: TextStyle(
                color: Color.fromARGB(255, 0, 0, 0),
                fontSize: 48,
                fontWeight: FontWeight.bold,
                fontStyle: FontStyle.italic),
          ),
          Row(
            mainAxisAlignment: MainAxisAlignment.center,
            crossAxisAlignment: CrossAxisAlignment.center,
            children: [
              Image.asset(
                "pengu.png",
                height: 150,
                width: 150,
              ),
              Image.asset(
                "globo.png",
                height: 150,
                width: 150,
              ),
              Image.asset(
                "pengu.png",
                height: 150,
                width: 150,
              ),
            ],
          ),
          const Text(
            "por um código livre e para todos ",
            style: TextStyle(
                color: Color.fromARGB(255, 255, 255, 255),
                fontSize: 48,
                fontWeight: FontWeight.bold,
                fontStyle: FontStyle.italic),
          ),
          Row(
            mainAxisAlignment: MainAxisAlignment.center,
            crossAxisAlignment: CrossAxisAlignment.center,
            children: [
              Image.asset(
                "pengu.png",
                height: 150,
                width: 150,
              ),
              Image.asset(
                "pengu.png",
                height: 150,
                width: 150,
              ),
            ],
          ),
        ],
      ),
    ),
    drawer: Container(
      color: Colors.lightGreenAccent,
    ),
    floatingActionButton: FloatingActionButton(
      onPressed: () {},
      backgroundColor: Colors.deepPurple,
      hoverColor: Colors.lightBlueAccent,
      hoverElevation: 32,
    ),
  );
}
