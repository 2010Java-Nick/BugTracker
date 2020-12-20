import { Component } from '@angular/core';
import { faBug } from '@fortawesome/free-solid-svg-icons';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'bug-tracker-ui';
  faBug = faBug;
}
