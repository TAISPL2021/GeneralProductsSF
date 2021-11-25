import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';
import {UsuariosService} from '../../../core/services/usuarios/usuarios.service';
import {User} from '../../../core/entity/user.model';
import {UserDelete} from '../../../core/entity/userDelete.model';
import {environment} from '../../../../environments/environment';

@Component({
  selector: 'app-usuarios-list',
  templateUrl: './usuarios-list.component.html',
  styleUrls: ['./usuarios-list.component.scss']
})
export class UsuariosListComponent implements OnInit {

  displayedColumns: string[] = ['id', 'name', 'secondName', 'lastName','secondLastName', 'address', 'phone', 'gender', 'userName', 'email', 'role', 'actions'];
  usuarios: User[];
  
  /*usuarioDelete: UserDelete[] =[
    {
      
    } 
  ];*/
  programacion: any;
  version: string;

  constructor(private usuariosService: UsuariosService, private router: Router,private changeDetectorRefs: ChangeDetectorRef) { 
    this.programacion = environment.programacion;
    this.version = environment.Version;
  }

  ngOnInit(): void {
    this.fetchPromotions();
  }

  fetchPromotions(): any{
    console.log("a")
    this.usuariosService.getAllUsers("").subscribe(usuarios =>
    {
      console.log(usuarios)
      console.log("ok")
      console.log(this.usuarios);
      this.usuarios = usuarios;
      this.changeDetectorRefs.detectChanges();
    });
  }

  DisableUser( nameUser: string): any{

    const request: UserDelete = {

      userName:nameUser,
      password:""
  
    } ;

    console.log(request);
      
    this.usuariosService.disabledUsuarios(request).subscribe( (usuario) => {
      console.log(usuario);
      alert('Usuario Deshabilitado.');
    });

    this.fetchPromotions();
  }

}
