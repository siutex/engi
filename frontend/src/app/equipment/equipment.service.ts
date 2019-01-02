import {Http, Headers, RequestOptions} from '@angular/http';
import {Injectable} from '@angular/core';
import {Equipment} from './equipment';
import {Observable} from 'rxjs/Observable';
import {Cookie} from 'ng2-cookies';

@Injectable()
export class EquipmentService {
    private equipUrl = 'http://localhost:8080/equipment';
    private newEquipUrl = 'http://localhost:8080/equipment/new';

    constructor(private http: Http) {
    }

    getEquip(): Observable<Equipment[]> {
        let headers = new Headers({
            'Content-type': 'application/json',
            'Authorization': 'Bearer ' + Cookie.get('access_token')
        });

        return this.http.get(this.equipUrl, {headers: headers})
            .map(res => res.json())
            .catch(err => {
                return Observable.throw(err.json().error || 'Server error');
            });
    }

    createEquip(equipment: Equipment): Observable<Equipment> {
        let headers = new Headers();
        headers.append('Content-Type', 'application/json');
        headers.append('Authorization', 'bearer ' + Cookie.get('access_token'));
        let options = new RequestOptions({ headers: headers });

        return this.http.post(this.newEquipUrl, equipment, options)
            .map(res => res.json())
            .catch(err => {
                return Observable.throw('Server Error');
            });
    }
}
