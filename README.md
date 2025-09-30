# Laboratorio I II-2025: Patrones de Software y Programación

***
## Enunciado 

Usted como ingeniero de software ha sido contratado para mejorar un aplicativo de comercio electrónico de celulares. El sistema actualmente permite a los clientes realizar compras de productos, en este caso celulares, pero se ha identificado la necesidad de introducir mejoras al código. Actualmente el stock de productos lo mantiene el proveedor ACME, que ha tenido una capacidad limitada de abastecer el stock actual por causa del gran crecimiento que ha tenido la empresa en el último tiempo. Estos proveedores cuentan con sus sistemas y en particular, interfaces propias para la adquisición de productos. Por ejemplo, para adquirir celulares de PCFactory se requiere hacer una llamada de método **getPCFactoryCelularAnho(int anho)** por año y en el caso del proveedor Afel, se solicitan por el tamaño de la pantalla del celular, **getAfelCelularTamanho(int pulgadas)**. 

Por lo tanto, se le ha encomendado la tarea de mejorarlo, utilizando el **patrón Adapter**, teniendo en cuenta los siguientes requisitos:


1. Debe implementa un mecanismo que permita que todos los proveedores de productos se comuniquen de manera uniforme con el sistema de compras;
2. Debe mantener la flexibilidad para agregar nuevos proveedores en el futuro sin cambiar el código existente;
3. No se debe modificar la clase del proveedor existente.


***
# Diagrama de Clases


![Diagrama de Clases!](1.png "Diagrama de Clases")

---

# Solución

## 📌 Versión Original

- Existía una sola clase `Proveedor` que contenía lógica para diferentes proveedores (Acme, Afel, PCFactory).
- Cada método estaba especializado, por ejemplo:
    - `getAcmeCelularesMarca(...)`
    - `getAfelCelularTamanho(...)`
    - `getPCFactoryCelularAnho(...)`
- Los clientes del sistema debían **conocer qué método específico invocar**, dependiendo del proveedor.

**Problemas:**
- **Alta dependencia:** el cliente está fuertemente acoplado a las clases concretas.
- **Baja cohesión:** una clase con múltiples responsabilidades.
- **Dificultad de extensión:** agregar un nuevo proveedor implica modificar la clase existente.

---

## 📌 Versión Refactorada

La versión refactorada introduce varias mejoras estructurales:

1. **División en proveedores concretos**
    - Ahora existen `ProveedorAcme`, `ProveedorAfel` y `ProveedorPCFactory`.
    - Cada clase se encarga de su propia lógica de consulta.

2. **Interfaz común: `Adaptador`**
    - Define un método genérico:
      ```java
      List<Celular> getCelulares(String marca, int anho, int pulgadas);
      ```
    - Los clientes solo necesitan esta interfaz para trabajar con cualquier proveedor.

3. **Patrón Adapter**
    - Clases como `AdaptadorProveedorAcme` implementan la interfaz y traducen la llamada unificada al método concreto del proveedor.
    - Para agregar un nuevo proveedor, basta con crear:
        - La clase del nuevo proveedor.
        - Su correspondiente adaptador.

4. **Organización por paquetes**
    - `modelo`: define las entidades (ej. `Celular`).
    - `presentacion`: contiene la aplicación principal.
    - `adapter`: concentra las implementaciones del patrón Adapter.

---

## 🚀 Beneficios del Refactor

- **Single Responsibility Principle (SRP):** cada clase cumple un único propósito.
