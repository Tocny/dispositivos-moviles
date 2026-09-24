# Tarea 2 — Programación de Dispositivos Móviles

App Android que simula un pedido de comida. Tiene dos pantallas pero
por el momento **solo se muestra una a la vez**.

## Pantallas

- `pedido.xml` — formulario para armar el pedido.
- `confirmacion.xml` — pantalla de confirmación.


## Cómo elegir qué pantalla se muestra

En `app/src/main/java/com/example/tarea2/MainActivity.java`, dentro de
`onCreate()`, solo una de las dos pantallas debe estar **sin comentar**:

```java
// Pantalla 1: pedido
// setContentView(R.layout.pedido);
// setupPedido();

// Pantalla 2: confirmacion
setContentView(R.layout.confirmacion);
setupConfirmacion();
```

Para revisar la otra pantalla:
1. Comenta las dos líneas de la pantalla activa.
2. Descomenta las dos líneas de la otra pantalla.
3. Vuelve a compilar y ejecutar.
