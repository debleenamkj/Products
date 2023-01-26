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
    this.service.deleteProduct(this.productId).subscribe((data)=>{
      this.router.navigate(['/product/view']);
    }
    );
  }

  id:any="Select ID";
  myID:any[] = [];
  ngOnInit(): void {
    this.service.getProducts().subscribe((data)=>{
      this.myID = data; 
      console.log(this.myID);      
    })
  }

}
