# Proyecto de calculadora de pi con cliente y servidor
## Instrucciones generales de compilación
### Desde la carpeta root del proyecto (/hello)
1. Compilamos **todas las clases** con  -> ``javac ./*.java`` (crea un archivos nombre.class)
2. Crear los objetos **Skeleton y Stub** con ```rmic -v1.1 InerfazRemotaImpl``` (implementación de la interfaz remota compilada)
3. Meter las **clases compiladas en sus repectivas carpetas**. La interfaz remota va en las dos, el stub en cliente y el skeleton en el servidor
### Desde la carpeta (/hello/servidor)
4. Ejecutar el archivo .class del **servidor** que contenga el método main con -> ``java nombre``
### Desde la carpeta (/hello/cliente)
5.  Ejecutar el archivo .class del **cliente** que contenga el método main con -> ``java nombre``
---
## Estructura del proyecto
Habrá un total de branches:
1. **main** tendrá un proyecto basa desde donde se parte
2. **iter1** tendrá tendrá el proyecto resuelto sin hilos
3. **iter2** tendrá el proyecto resuelto con hilos

