import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ProductServiceService } from '../product-service.service';

@Component({
  selector: 'app-product-delete',
  templateUrl: './product-delete.component.html',
  styleUrls: ['./product-delete.component.css']
})
export class ProductDeleteComponent implements OnInit {

  productId:any;
  constructor(private service:ProductServiceService, private router:Router) { }

  delete(){
    this.service.deleteProduct(this.productId).subscribe((data)=>console.log(data)
    );
  }

  ngOnInit(): void {
  }

}
