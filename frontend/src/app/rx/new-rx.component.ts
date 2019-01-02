import {Rx, RxStatus} from './rx';
import {Component} from '@angular/core';
import {RxService} from './rx.service';
import {Router} from '@angular/router';

@Component({
  templateUrl: './new-rx.component.html'
})
export class NewRxComponent {
  rx: Rx;
  rxStatus: RxStatus;
  alertStyle: string;

  constructor(private rxService: RxService, private router: Router) {
    this.rx = new Rx();
    this.rxStatus = new RxStatus();
    this.alertStyle = '';
  }

  onSubmit() {
    this.rxService.createRx(this.rx)
      .subscribe((rx: Rx) => {
        this.rxStatus.code = 'SUCCESS';
        this.rxStatus.message = 'Wizyta dodana';
        this.alertStyle = 'alert alert-success';
      },
      error =>  {
        if (error === 'invalid_token') {
          this.router.navigateByUrl('/auth/login');
          this.rxStatus.code = 'FAILURE';
          this.rxStatus.message = 'Wizyta niedodana. Zaloguj się ponownie';
          this.alertStyle = 'alert alert-danger';
        } else {
          console.error('Błąd przy tworzeniu wizyty przekierowanie na główną: ', error);
        }
          // this.router.navigateByUrl('/rx/new');
          this.rxStatus.code = 'FAILURE';
          this.rxStatus.message = 'Taki pacjent nie istnieje';
          this.alertStyle = 'alert alert-danger';
      });
  }
}
