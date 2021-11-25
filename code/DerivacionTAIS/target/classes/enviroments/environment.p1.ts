export const environment = {
  production: false,
  url_api: 'http://apigateway-env.eba-32fcsrbi.us-east-1.elasticbeanstalk.com/',
  Version: 'P1',
  programacion: {
    //autenticacion 
    RegistroUsuario:true,
    GestionPerfil: true,
    InicioSesion: true,
    //catalogo
    VisualizacionProductos:true,
    BuscarProducto:true,
    ComprarProducto:false,
    //administracion
    AnadirProducto:true,
    ActualizarProducto:true,
    EliminarProducto:true,
    GenerarFactura:false,
    CrearPromocion:false,
    AdministrarUsuariosRegistrados:false,
    AdministrarPedidos:false,
    //pago electronico
    GestionarPagos:false,
    //reporte
    GestionarReportes:false
  }  
};
