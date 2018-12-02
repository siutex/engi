import {Headers, Http} from '@angular/http';
import {Injectable} from '@angular/core';
import {Hospital} from './hospital';
import {Observable} from 'rxjs/Observable';
import {Cookie} from 'ng2-cookies';


@Injectable()
export class HospitalService {
    private hospitalUrl = 'http://localhost:8080/hospital';
    constructor(private http: Http) {
    }

    getHospital(): Observable<Hospital[]> {
        let headers = new Headers({
            'Content-type': 'application/json',
            'Authorization': 'Bearer ' + Cookie.get('access_token')
        });

        return this.http.get(this.hospitalUrl, {headers: headers})
            .map(res => res.json())
            .catch(err => {
                return Observable.throw(err.json().error || 'Server error');
            });
    }


}
