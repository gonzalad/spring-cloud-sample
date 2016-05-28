import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import 'rxjs/add/operator/toPromise';

@Injectable()
export class HelloService {

    helloServiceUrl = 'http://localhost:8080/v1'

	constructor(private http:Http) {
	}

    getHello() {
        //return Promise.resolve('Dummy Hello');
        return this.http.get(this.helloServiceUrl)
        .toPromise()
        .then(response => 
			response.json().data
		)
        .catch(this.handleError)
    }

	private handleError(error: any) {
		console.error('An error occurred', error);
		return Promise.reject(error.message || error);
	}
}

