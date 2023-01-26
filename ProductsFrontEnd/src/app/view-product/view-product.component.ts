import { Component, OnInit } from '@angular/core';
import { ProductServiceService } from '../product-service.service';

@Component({
  selector: 'app-view-product',
  templateUrl: './view-product.component.html',
  styleUrls: ['./view-product.component.css']
})
export class ViewProductComponent implements OnInit {

  constructor(private service:ProductServiceService) { }
  products:any[] = [];
  ngOnInit(): void {
    this.service.getProducts().subscribe((data)=>{
      console.log(data);
      this.products = data;   
    })
  }

  deleteProduct(productId:number){

    this.service.deleteProduct(productId).subscribe((data)=>{
      console.log(data);
      this.ngOnInit();
    });

  }

}
