import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-footer',
  templateUrl: './footer.component.html',
  styleUrls: ['./footer.component.css']
})
export class FooterComponent implements OnInit {

  mostrarFooter : boolean;

  constructor() { }

  ngOnInit(): void {

    this.mostrarFooter = JSON.parse( localStorage.getItem("usuarioValidado")!);
  }

}
