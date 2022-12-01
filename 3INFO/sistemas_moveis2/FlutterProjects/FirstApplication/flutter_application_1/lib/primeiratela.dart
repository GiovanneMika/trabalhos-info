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
Widget home(){
  return Scaffold(
    appBar:AppBar(
      title: Text("Olá Mundo"),
      ),
      body: Container(
    color: Colors.teal,
    height: double.infinity,
    width: double.infinity,
    child: Row(
      mainAxisAlignment: MainAxisAlignment.center,
      crossAxisAlignment: CrossAxisAlignment.start,
      children: [
        const Text(
          "Hello World",
          style: TextStyle(
            color: Color.fromARGB(255, 148, 3, 245),
            fontSize: 48,
            fontWeight: FontWeight.bold,
            fontStyle: FontStyle.italic
          ),
        ),
        Image.asset("Coding.png",
        height: 150,
        width: 150,
        ),
       const Text(
          "Hello 44423343",
          style: TextStyle(
            color: Color.fromARGB(255, 148, 3, 245),
            fontSize: 48,
            fontWeight: FontWeight.bold,
            fontStyle: FontStyle.italic
          ),
        ),
      ],
    ),
      ),
      drawer: Container(
        color: Colors.lightGreenAccent,
      ),
      floatingActionButton: FloatingActionButton(onPressed: (){}, backgroundColor: Colors.deepPurple, hoverColor: Colors.lightBlueAccent, hoverElevation: 32,), 
  );
}