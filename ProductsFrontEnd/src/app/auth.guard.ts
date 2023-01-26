import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { ProductServiceService } from './product-service.service';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {
  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): boolean {
      if(!this.service.isLoggedIn)
      return true;
    else {
      this.router.navigate(['']);
      return false;
    }
  }
  constructor(private service:ProductServiceService, private router: Router){}
}
