# Tarea 3 — Programación de Dispositivos Móviles

App Android que simula un pedido de comida. Parte de la Tarea 2 y agrega
una pantalla con el menú del restaurante en un `ListView`. Por el momento
**solo se muestra una pantalla a la vez**.

## Pantallas

- `pedido.xml` — formulario para armar el pedido (Tarea 2).
- `confirmacion.xml` — pantalla de confirmación (Tarea 2).
- `menu.xml` — menú de platillos en un `ListView` (Tarea 3). Cada fila usa
  `item_platillo.xml` y muestra imagen, nombre, descripción y precio. Al tocar
  un platillo, `setOnItemClickListener` muestra un `Toast` con lo elegido.


## Cómo elegir qué pantalla se muestra

En `app/src/main/java/com/example/tarea3/MainActivity.java`, dentro de
`onCreate()`, solo una de las pantallas debe estar **sin comentar**:

```java
// Pantalla 1: pedido
// setContentView(R.layout.pedido);
// setupPedido();

// Pantalla 2: confirmacion
// setContentView(R.layout.confirmacion);
// setupConfirmacion();

// Pantalla 3: menu (ListView)
setContentView(R.layout.menu);
setupMenu();
```

Para revisar otra pantalla:
1. Comenta las dos líneas de la pantalla activa.
2. Descomenta las dos líneas de la pantalla que quieres ver.
3. Vuelve a compilar y ejecutar.

## Créditos

Íconos de los platillos (`res/drawable/*.png`) descargados de
[Flaticon](https://www.flaticon.com/):

- [skyclick](https://www.flaticon.es/autores/skyclick)
- [Magnific](https://www.flaticon.es/autores/magnific)
