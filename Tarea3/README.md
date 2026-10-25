# Tarea 3 — Programación de Dispositivos Móviles

App Android que simula un pedido de comida. Se incluyen pantallas de la tarea anterior y una pantalla con el menú del restaurante en un `ListView`.

## Pantallas
Tarea2:
- `pedido.xml` — formulario para armar el pedido.
- `confirmacion.xml` — pantalla de confirmación.

Tarea3
- `menu.xml` — menú de platillos como un `ListView`. Cada fila muestra un icono, nombre, descripción y precio. Al tocar
  un platillo, muestra un `Toast` con lo elegido.


## Cómo elegir qué pantalla se muestra

En la ruta `app/src/main/java/com/example/tarea3/MainActivity.java`, dentro del método
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
1. Comente las líneas de la pantalla activa.
2. Descomente las líneas de la pantalla que se desee ver.
3. Recompilar.

## Créditos

Íconos descargados de
[Flaticon](https://www.flaticon.com/):

- [skyclick](https://www.flaticon.es/autores/skyclick)
- [Magnific](https://www.flaticon.es/autores/magnific)
