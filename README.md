# Desafio-Producto-Consumidor


## Descripción General

Desarrollamos una solución al problema Productor-Consumidor en Java, en esta versión del problema tenemos dos buffers, y cuatro procesos que producen y consumen elementos en los buffers.
El proceso 1 genera números aleatorios entre 0 y 100, y los inserta en el primer buffer, es un productor puro.
El proceso 2 consume un número del primer buffer, lo eleva al cuadrado, y lo inserta nuevamente en el primer buffer.
El proceso 3 consume dos números del primer buffer, e inserta el resultado de la suma en el segundo buffer.
El proceso 4 consume un número del segundo buffer, es un consumidor puro.
Al consumir y producir elementos, se imprime en pantalla el elemento y el buffer.

## Concurrencia

Para resolver este problema, utilizamos la librería java.util.concurrent.Semaphore que nos
permitió utilizar semáforos para bloquear y desbloquear procesos, y así manejar la concurrencia de los mismos.

Para lanzar los cuatro procesos concurrentes, hicimos que estos procesos hereden de la clase Thread
de java, esta clase implementa un método llamado run, para cada uno de los procesos hicimos override
a este método run.
De esta forma, al llamar en nuestra aplicación, al método start de uno de los procesos, la máquina virtual de java inicia concurrentemente el método run de este proceso.

En los métodos run de cada proceso, programamos funciones asíncronas, que definían como generábamos los datos en los productores, y qué hacíamos con los datos consumidos en los consumidores, y también una llamada a métodos sincronizados del buffer.

## Buffer y Métodos Productor/Consumidor

Utilizamos una clase buffer que permite ingresar y extraer elementos a un array, implementando el funcionamiento de una cola circular.
En esta clase buffer programamos estos métodos sincronizados, los cuáles son producir y consumir, en el método producir pedimos un parámetro a insertar, solicitamos el semáforo que indica si está vacío y el de mútua exclusión, luego de esto estamos seguros que podemos insertar el dato en el buffer, por lo que lo hacemos, y tras esto liberamos el semáforo de mútua exclusión, y el que indica si está lleno.

El método consumir, es simétrico al producir, primero solicitamos el semáforo que indica si está lleno y el de mútua exclusión, tras esto extrae un dato de la clase buffer, y libera el semáforo de mútua exclusión y el que indica si está vacío.


Desarrollado por: Agustín Schlechter, Rodrigo Cardinal, Fernando Sánchez, Santiago Pereira, y Leandro Barral.