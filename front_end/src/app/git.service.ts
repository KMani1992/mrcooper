import { Injectable } from '@angular/core';
import { Http, Headers, Response, RequestOptions } from '@angular/http';
import 'rxjs/add/operator/toPromise';
import * as globalSymbol from "./globalSymbol"


@Injectable()
export class GitService {

  // hold the base URL
  private baseUrl: string = globalSymbol.baseURL;

  isAuthenticated:boolean =false;

  constructor(private http: Http) {
  }

  // API to get the components
  storeGitRepo(userName:string): Promise<Object[]> {
    return this.http.get(`${this.baseUrl}/grp/storeUserRepo${globalSymbol.qryParamHead}userName=${userName}`, { headers: this.getHeaders() })
      .toPromise()
      .then(this.extractData)
      .catch(this.handleError);
  }

// API to get the headers
  private getHeaders() {
    let headers = new Headers();
    headers.append('Accept', 'application/json');
    return headers;
  }

  // API used to extract data to json object array
  private extractData(res: Response) {
    console.log("res", res);
    let resbody = res.json() as Object[];
    console.log(resbody, "data");
    return resbody;
  }
  

  // API used to handle the error
  private handleError(error: any): Promise<any> {
    console.error('An error occurred', error); // for demo purposes only
    return Promise.reject(error.message || error);
  }

}