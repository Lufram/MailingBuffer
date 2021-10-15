# UF1-HILOS


## 1-REQUERIMIENTO  -  PRIME CHEKER

Simulacion de un programa que solicita 4 numeros por pantalla y comprueba de forma simultanea si son primos y nos devuelve la información por consola.


## 2-REQUERIMIENTO  -  MAILING BUFFER

Simulacion de un programa de automatización de mailing publicitario. Queremos implementar un sistema que automatice la salida de correos electronicos de una campaña a una pila de correos utilizando como remitente los correos de los miembros del Dpto. Comercial.

### 2.2-HILOS 

El sistema de mailing funciona mediante el uso de hilos para creacion y envio de emails, simultaneamente 3 procesos generan los emails añadiendo el remitente (comercial) y el destinatario (cliente) y los añade a un buffer que almacena hasta 4 emails, otros dos procesos se encargan de sacar los email del buffer y enviarlos.

## 3-REQUERIMIENTO  -  MAILING BUFFER++

Añadimos un sistema de comprobación que nos permita añadir correos a una lista negra que no queremos que se les envie el correo publicitario.
