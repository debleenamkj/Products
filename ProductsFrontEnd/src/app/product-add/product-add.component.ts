import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Product } from '../product';
import { ProductServiceService } from '../product-service.service';

@Component({
  selector: 'app-product-add',
  templateUrl: './product-add.component.html',
  styleUrls: ['./product-add.component.css']
})
export class ProductAddComponent implements OnInit {

  constructor(private service:ProductServiceService, private router:Router) {
    this.products.productId = this.Products.get('productId')?.value;
    this.products.name = this.Products.get('name')?.value;
    this.products.productCategory = this.Products.get('productCategory')?.value;
    this.products.productType = this.Products.get('productType')?.value;
    this.products.productPrice = this.Products.get('productPrice')?.value;
   }

  products:Product = new Product();
  Products = new FormGroup(
    {
      productId: new FormControl('',[Validators.required]),
      name: new FormControl('',Validators.required),
      productType: new FormControl('',Validators.required),
      productCategory: new FormControl('',Validators.required),
      productPrice: new FormControl('',Validators.required)
    }
  );

  add(){
    console.log(this.Products.get('name')?.value);
    this.products.productId = this.Products.get('productId')?.value;
    this.products.name = this.Products.get('name')?.value;
    this.products.productCategory = this.cate;
    this.products.productType = this.Products.get('productType')?.value;
    this.products.productPrice = this.Products.get('productPrice')?.value;
    
    
    this.service.addProduct(this.products).subscribe(
      data => {
        console.log("added");
        this.router.navigate(['/product/view'])
    },
      error => {
        console.log(this.products);
        
      }
    )
    console.log(this.products);
  }

  cate:any="";
  myCategory:any[] = [];
  ngOnInit(): void {
    this.service.getProductCategory().subscribe((data)=>{
      this.myCategory = data; 
      console.log(this.myCategory);      
    })
  }

}
