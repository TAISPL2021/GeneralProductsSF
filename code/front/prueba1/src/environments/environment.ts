export const environment = {
  production: false,
  url_api: 'http://apigateway-env.eba-32fcsrbi.us-east-1.elasticbeanstalk.com',
  Version: 'DEV',
  programacion: {
    //autenticacion 
    RegistroUsuario:true,
    GestionPerfil: true,
    InicioSesion: true,
    //catalogo
    VisualizacionProductos:true,
    BuscarProducto:true,
    ComprarProducto:true,
    //administracion
    AnadirProducto:true,
    ActualizarProducto:true,
    EliminarProducto:true,
    GenerarFactura:true,
    CrearPromocion:true,
    AdministrarUsuariosRegistrados:true,
    AdministrarPedidos:true,
    //pago electronico
    GestionarPagos:true,
    //reporte
    GestionarReportes:true
  }  
};
