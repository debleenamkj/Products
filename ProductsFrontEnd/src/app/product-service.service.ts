import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Product } from './product';

@Injectable({
  providedIn: 'root'
})
export class ProductServiceService {

  isLoggedIn = false;

  public addProduct(product:Product){
    return this.http.post<any>("http://localhost:8080/api/v1/saveproduct",product);
  }
   public deleteProduct(productId:number){
    return this.http.delete("http://localhost:8080/api/v1/deleteproduct/"+productId);
   }
  
   public getProducts():Observable<any>{
    return this.http.get("http://localhost:8080/api/v1/getProducts");
   }

   public getProductCategory():Observable<any>{
    return this.http.get("http://localhost:8080/api/v1/getproductcategory");
   }

  constructor(private http:HttpClient) { }
}
