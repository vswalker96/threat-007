import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { LucidChartComponent } from "./component/LucidChart/lucid-chart/lucid-chart.component";

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, LucidChartComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'threat-007';
}
