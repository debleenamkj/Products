import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { throws } from 'assert';
import { ProductServiceService } from '../product-service.service';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {

  constructor(private service:ProductServiceService, private router:Router) { }

  ngOnInit(): void {
  }

  logout(){

    this.service.isLoggedIn = false;
    this.router.navigate(['/']);
  }
}
