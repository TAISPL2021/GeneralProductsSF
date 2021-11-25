export const environment = {
  production: true,
  url_api: 'http://apigateway-env.eba-32fcsrbi.us-east-1.elasticbeanstalk.com',
  Version: 'PROD',
  programacion: {
    //autenticacion 
    RegistroUsuario:false,
    GestionPerfil: false,
    InicioSesion: false,
    //catalogo
    VisualizacionProductos:false,
    BuscarProducto:false,
    ComprarProducto:false,
    //administracion
    AnadirProducto:false,
    ActualizarProducto:false,
    EliminarProducto:false,
    GenerarFactura:false,
    CrearPromocion:false,
    AdministrarUsuariosRegistrados:false,
    //pago electronico
    GestionarPagos:false,
    //reporte
    GestionarReportes:false
  }  
};
