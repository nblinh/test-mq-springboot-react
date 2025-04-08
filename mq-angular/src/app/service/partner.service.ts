import { Inject, Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { catchError, map, tap } from 'rxjs/operators';
import { ENV_CONFIG, EnvironmentConfig } from '../environment-config';
import { Partner } from '../partner/partner';

@Injectable({
  providedIn: 'root'
})
export class PartnerService {

  public apiUrl: string;
  public path: string = "partners";
  constructor(private http: HttpClient, @Inject(ENV_CONFIG) private config: EnvironmentConfig) {
    this.apiUrl = `${config.environment.baseUrl}`;
  }

  getPartners(): Observable<Partner[]> {
    return this.http.get<Partner[]>(`${this.apiUrl}/${this.path}`)
      .pipe(
        tap(_ => console.log('fetched partners')),
        catchError(this.handleError<Partner[]>('getPartners', []))
      );
  }

  addPartner(partner: Partner): Observable<Partner> {
    return this.http.post<Partner>(`${this.apiUrl}/${this.path}`, partner)
      .pipe(
        tap(_ => console.log('add partner')),
        catchError(this.handleError<Partner>('addPartner'))
      );
  }

  deletePartner(id: number) {
    return this.http.delete(`${this.apiUrl}/${this.path}/${id}`)
      .pipe(
        tap(_ => console.log('delete partner id: ', id)),
        catchError(this.handleError<Partner>('deletePartner'))
      )
  }



  /**
* Handle Http operation that failed.
* Let the app continue.
*
* @param operation - name of the operation that failed
* @param result - optional value to return as the observable result
*/
  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {

      // TODO: send the error to remote logging infrastructure
      console.error(error); // log to console instead

      // TODO: better job of transforming error for user consumption
      console.log(`${operation} failed: ${error.message}`);

      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }
}
