import { Component, OnInit } from '@angular/core';
import {Product} from "../interface/product";
import {ProductService} from "../service/product.service";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  products!: Product[];

  constructor(private productService:ProductService) { }

  ngOnInit(): void {
    this.productService.getProducts().subscribe(res =>{
      this.products = res;
    })
  }
  addToCart(product:Product){

  }
}
