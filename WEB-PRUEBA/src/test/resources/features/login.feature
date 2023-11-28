#language: es
@testfeature
Característica: Login y Carrito de Compras

  @test
  Escenario: Iniciar sesión y validar datos
    Dado que me encuentro en la página principal de platanitos
    Cuando hago clic en Cuenta
    Y inicio sesión con las credenciales usuario: "gianfranco62211@gmail.com" y contraseña: "Prueba2211!"
    Entonces valido que deberia aparecer el nombre de usuario "Gianfranco Alfaro MariÑo"
    Y hago clic en el menu de Ofertas
    Y doy clic en la ofertas calzado y selecciono la primera opcion
    Y doy clic en agregar al carrito
    Cuando doy clic en el menu de carrito de compras
    Entonces valido que deberia aparecer el producto con nombre "Sandalias Dama Sb 0724" en el carrito
