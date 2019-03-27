import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Projeto de Aula';

  categorias =  [
    {id: '1', nome: 'JONATHAN JOESTAR'},
    {id: '2', nome: 'JOSEPH JOESTAR'},
    {id: '3', nome: 'JOTARO KUJO'},
    {id: '4', nome: 'JOSUKE HIGASHIKATA'}

  ]
}
