export const environment = {
  production: false,
  url_api: 'http://apigateway-env.eba-32fcsrbi.us-east-1.elasticbeanstalk.com/',
  Version: 'P2',
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
    CrearPromocion:false,
    AdministrarUsuariosRegistrados:false,
    AdministrarPedidos:false,
    //pago electronico
    GestionarPagos:false,
    //reporte
    GestionarReportes:true
  }  
};