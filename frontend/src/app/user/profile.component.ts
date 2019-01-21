import {Component} from '@angular/core';
import {AuthService} from '../auth/auth.service';
import {NewUser, SignupStatus} from '../auth/login';


@Component({
    templateUrl: './profile.component.html'
})
export class ProfileComponent {

    alertStyle = 'alert alert-success';
    userStat = new SignupStatus();
    model = new NewUser();

    constructor(private profileService: AuthService) {
    }

    onSubmit() {
        this.profileService.updateUser(this.model)
            .then((status: SignupStatus) => {
                this.userStat.code = status.code;
                this.userStat.message = status.message;
                if (this.userStat.code === 'USER_ACCOUNT_EXISTS') {
                    this.alertStyle = 'alert alert-danger';
                }
            });
        this.alertStyle = 'alert alert-success';
    }

}

