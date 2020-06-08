FORMA DE USO:
-Ejecutamos el chat main el cual pondra en escucha el servidor y a continuación iniciamos en cliente telnet tantas veces queramos e iremos añadiendo nuevos usuarios al 
chat.

-El primero texto que enviemos será nuestro nombre

-A partir de ahí todo lo que enviemos será difundido entre todos los chats

-Si escribimos la palabra adios nos saldremos del chat.


EXPLICACION DEL FUNCIONAMIENTO:

El servidor se pone en funcionamiento y crea una lista enlazada donde ira guardado los clientes que se conecten, ponemos en escucha el server socket  y cuando acepte un cliente creamos un hilo ManejadorPeticionChat que manejará al cliente y sus acciones.

La clase ChatMain cuenta con los metodos estáticos difundir y eliminar para manejar los mensajes que se envían y borrar los usuarios que se salgan.

Mediante dos hilos uno de entrada y otro de salida en cada cliente, creados al instanciarse estos clientes, podremos controlar la entrada y salida del mensajes desde y hacia el servidor.

La ventana esta definida en la clase VistaChat y su controlador en la clase ControladorVentanaChat.








