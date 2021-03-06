// This file can be replaced during build by using the `fileReplacements` array.
// `ng build --prod` replaces `environment.ts` with `environment.prod.ts`.
// The list of file replacements can be found in `angular.json`.

export const environment = {
  production: false,
  url_api: 'http://apigateway-env.eba-32fcsrbi.us-east-1.elasticbeanstalk.com',
  Version: 'P3',
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

/*
 * For easier debugging in development mode, you can import the following file
 * to ignore zone related error stack frames such as `zone.run`, `zoneDelegate.invokeTask`.
 *
 * This import should be commented out in production mode because it will have a negative impact
 * on performance if an error is thrown.
 */
// import 'zone.js/dist/zone-error';  // Included with Angular CLI.
