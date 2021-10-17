# UF1-HILOS


## 1-REQUERIMIENTO  -  PRIME CHEKER
<div style="text-align: justify,
  text-justify: inter-word"> 
Simulacion de un programa que solicita 4 numeros por pantalla y comprueba de forma simultanea si son primos y nos devuelve la información por consola.

El programa pide por consola que se introduzca un número, así hasta en cuatro ocasiones. Mediante un bucle “for” que almacena en un array el número.
Creamos cuatro hilos, uno por número introducido. Cada uno de ellos determinará si el número introducido es primo o no utilizando el método “isPrime” que almacenara el tiempo inicial y el final del proceso para calcular el tiempo que ha tardado en ejecutarlo.
Como resultado, nos devuelve por consola el número analizado, el hilo que lo ha ejecutado, el tiempo que tarda en realizarlo y la conclusión de si el número a deliberar es primo o no.</div>


## 2-REQUERIMIENTO  -  MAILING BUFFER

Simulacion de un programa de automatización de mailing publicitario. Queremos implementar un sistema que automatice la salida de correos electronicos de una campaña a una pila de correos utilizando como remitente los correos de los miembros del Dpto. Comercial. Para ello hemos creado 3 hilos productores, los cuales accederán a una lista de remitentes almacenados en un documento externo que leeremos mediante un bucle “for” que recorrerá el documento y añadirá cada línea a un “arrayList” y una lista de 4 coreos salientes que almacenaremos en un “array” de “Strings”, cada hilo creara un nuevo objeto de la clase Email mediante el método sincronizado “addEmail” pasando como paramentos el remitente que seleccionara de la posición del array ( cuando llegue al último volverá a empezar) y un remitente que extraerá de la lista para evitar que se envíe dos veces al mismo. Cada hilo generará 10 Emails que sumaran un total de 30 emails producidos. 

Cada email al crearse generara automáticamente el método constructor que llamara a otra función que creara un id correlativo tambien simularemos la creación de emails personalizados generando un asunto y un cuerpo del correo con un método de concatenación de caracteres aleatorios. Estos Emails serán almacenados por los hilos en un buffer dentro de un “arrayList” con una capacidad máxima de 5 correos de manera que una vez llegado al máximo los hilos quedarán en espera de espacio. 

Por otro lado, crearemos 2 hilo con la función de extraer los Emails del buffer e imprimirlos por consola simulando su envió con el método sincronizado “getEmail”.


## 3-REQUERIMIENTO  -  MAILING BUFFER++

Añadimos un sistema de comprobación que nos permita añadir correos a una lista negra que no queremos que se les envie el correo publicitario. Implantamos la estructura de control do while() en el buffer, de este modo conseguimos que todo correo con ese nombre quede descartado. 
