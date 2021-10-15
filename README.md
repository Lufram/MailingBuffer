# Hilos

Crear un proceso en un ordenador implica los siguientes cambios:

- La reserva de una determinada memoria de trabajo.b>hilo</b>
- Carga de trabajo para el procesador, que tendrá que ir ejecutando las instrucciones incluidas en el proceso.
- Cambios de estado del proceso, que se reflejan en los valores de los registros de la CPU.

## Sistemas multitarea 

Estos sistemas tienen una serie de características:

- Varios hilos en ejecución dentro del mismo proceso.

- Todos los hilos comparten los recurso que el sistema operativo haya asignado al proceso. La incorporación de un hilo más no supone la asignación de más recursos del sistema. 
