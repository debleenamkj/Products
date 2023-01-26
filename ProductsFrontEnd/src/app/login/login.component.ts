import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ProductServiceService } from '../product-service.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']

})
export class LoginComponent implements OnInit {

  constructor(private router:Router, private service:ProductServiceService) { }

  Login = new FormGroup(
    {
      emailid: new FormControl('',Validators.required),
      password: new FormControl('',Validators.required)
    }    
    );
    message!:string;

  login(){
    console.log(this.Login.get('emailid')?.value);
      if (this.Login.get('emailid')?.value === "admin" && this.Login.get('password')?.value === "admin"){
        this.service.isLoggedIn = true;
        this.router.navigate(['/product/view']);
      } else{
        this.message = "You Are Not Authorized To Enter.";
      }
  }

  ngOnInit(): void {
  }

}
